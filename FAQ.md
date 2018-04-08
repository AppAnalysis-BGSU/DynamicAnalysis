### Q1. Do we obtain the same list of system calls on running the same android application again?

> As per official documentation, `Running monkey with a same seed value generates the same sequence of events.` We expected same seed value will thus generate same events and thus same list of system calls. However, **experiment shows it is not the case.**

         `adb shell monkey -p $pkgname -v 500 -s 152`
       
  In the above command we set monkey to verbose and feed the seed 512 to an application with 3 activities. Though same seed was used, we observed the following on the emulator: 
  
  > On execution of above command the first time, the application's third activity was **not launched** at all. The events generated were confined within first and second activity.
  
  > On execution of above command second time, the application's third activity was **launched** and the buttons associated with  malicious activity (get device IMEI) was clicked. 
  
  This explains why we get different system calls. 
  
### Q2. Could you try to explain each word in two example system calls? 

 `sendto(38, "\3\0\0\0X\\\246\377\200\0\0\0\1\36H\350", 16, MSG_DONTWAIT|MSG_NOSIGNAL, NULL, 0) = 16`
 
From strace man page: 
> Each line in the trace contains the system call name, followed by its arguments in parentheses and its return value.

ssize_t sendto(int sockfd, const void *buf, size_t len, int flags,const struct sockaddr *dest_addr, socklen_t addrlen);

38 -- socket descriptor

"\3\0\0\0X\\\246\377\200\0\0\0\1\36H\350" -- pointer to data location

16 -- send 16 bytes of data

MSG_DONTWAIT|MSG_NOSIGNAL --flags

NULL,0 -- sockfd = 38 is the connection description between the source and the destination. No need to specify the 
destination once again and thus given NULL.

= 16 -- return value that equals number of bytes sent. Error EISCONN may be returned when they are not NULL and 0), and the error ENOTCONN is returned when the socket was not actually connected

-----------------------

`ioctl(8, BINDER_WRITE_READ, 0xffdb7098) = 0`

int ioctl(int fd, unsigned long request, ...);

8 -- open file descriptor

BINDER_WRITE_READ -- device-dependent request code

0xffdb7098 -- pointer to memory

To initiate an IPC transaction, ioctl() call with BINDER_READ_WRITE command is invoked.


[Details on linux system calls can be easily accessed here](http://syscalls.kernelgrok.com/)

[Strace Hello World](http://timetobleed.com/hello-world/)


### Q3. Does strace record system calls associated with ONLY that specific android application (which is attached to strace)? 

In my understanding, **YES** .

As per strace documentation
> `It intercepts and records the system calls which are called by a process and the signals which are received by a process.`

However, the monkey tool generates random events which may also increase the device volume, may enter settings etc. which may invoke their random system calls. I interpret those as 
signals received by the process.

Furthermore, `strace` documentation states 
> `If a system call is being executed and meanwhile another one is being called from a different thread/process then strace will try to preserve the order of those events and mark the ongoing call as being unfinished. When the call returns it will be marked as resumed.
 
 >>`[pid 28772] select(4, [3], NULL, NULL, NULL <unfinished ...>`

 >>`[pid 28779] clock_gettime(CLOCK_REALTIME, {1130322148, 939977000}) = 0`

 >>`[pid 28772] <... select resumed> )      = 1 (in [3])`
 
 
 Our system call list obtained only has `<unfinished>` at the end (when random events to the process is completed and the process is terminated). Thus implying the entire list of system calls is associated with the single application process only.
 
 ### Q4. Can we guess the behavior of the apps using system calls?

Let's take two applications example. 

Application 1 -- locks the screen and thus very few events can be triggered as it locks entire screen.

Application 2 -- fetches device information and then sends it through sms 

We expected to see some difference in frequencies of some system calls. We expected app 1 with lockscreen feature to invoke large numnber of 

> `epoll_wait(.....): blocks for timeout milliseconds waiting for an I/O event on a descriptor file. `

and app 2  that leaks information to invoke  large number of 
>`send(....) and sendto(....)`

But a plot of system calls made by App 1 and App 2 doesnot relate to the idea.
[Click here to donwlaod the file](https://raw.githubusercontent.com/AppAnalysis-BGSU/DynamicAnalysis/master/Graph.docx)
 

