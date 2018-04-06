### Q1. Do we obtain same set of system calls on running the same application again?

>Monkey tool provides us with the seed option which will generate the same random events provided the seed is same. This implies it will generate the events by same percentage
  say 10% upswipe, 10% downswipe events and so on. However, test showed that these similar events do not correspond to same system calls.
  
       `adb shell monkey -p $pkgname -v 500 -s 152`
  
### Q2. Could you try to explain each word in these two system calls? As an example, we want to know what is the meaning of `38` in first param, and so on. What is `=16`?
 `sendto(38, "\3\0\0\0X\\\246\377\200\0\0\0\1\36H\350", 16, MSG_DONTWAIT|MSG_NOSIGNAL, NULL, 0) = 16`
 
From strace man page: 
> Each line in the trace contains the system call name, followed by its arguments in parentheses and its return value.

If sendto() is used on a connection-mode (SOCK_STREAM, SOCK_SEQPACKET) socket, the arguments dest_addr and addrlen are ignored
           (and the error EISCONN may be returned when they are not NULL and 0), and the error ENOTCONN is returned when the socket was 
            not actually connected. Otherwise, the address of the target is given by dest_addr with addrlenspecifying its size.
       SEQPACKET: sequenced, reliable, [two-way] connection-based data transmission path for datagrams" (from linux man documentation).
So,  sockfd = 38 is the connection description between the source and the destination. No need to specify the destination once again and thus given NULL. Data is copied from the 
*buf address (16 bytes of data)  and sent to the destination as indicated by the sockfd. Returns the size of bytes sent

####  ioctl - control device
int ioctl(int fd, unsigned long request, ...);
The ioctl() system call manipulates the underlying device parameters of special files. In particular, many operating characteristics of
       character special files (e.g., terminals) may be controlled with ioctl() requests. The argument fd must be an open file descriptor.

To initiate an IPC transaction, ioctl() call with BINDER_READ_WRITE command is invoked.


[Details on linux system calls can be easily accessed here](http://syscalls.kernelgrok.com/)

### Q3. Analysis and inference attempt on system calls. Is there significant difference in say lockscreen app made system calls and some other malicicous app that donot lock screen?

Initially, I assumed an app with lockscreen feature should invoke large numnber of 
 > `epoll_wait(int epfd, struct epoll_event *events, int
maxevents, int timeout): blocks for timeout milliseconds
waiting for an I/O event on a descriptor file. `

and say an app that leaks information would use large number of 
> ` recv(int s, void *buf, size_t len, int flags)` & 

>`recvfrom(int s,void *buf, size_t len, int flags,struct sockaddr *from,
socklen_t *fromlen): allow to read incoming data from the
remote side locally or via network.
`
OR
>`send(int sockfd, const void *buf, size_t len, int flags) and
sendto(int sockfd, const void *buf, size_t len, int flags)`

But a plot of system calls made by LOCKSCREEN-featured app and non lockscreen app doesnot relate to the idea.
[Click here to donwlaod the file](https://raw.githubusercontent.com/AppAnalysis-BGSU/DynamicAnalysis/master/Graph.docx)

### Q4. Does strace record all the system calls associated with that process? 

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
 

