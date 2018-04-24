# DynamicAnalysis
 Deep learning to classify android applications as `benign` and `malicious`. 
 
 `Benign Android Applications:` As the term suggests, these android are not of threat to users using them as they do not show bad behaviors like deleting user info, stealing user info, sending unsolicited sms, making unauthorized phone calls etc. On the other hand, applications that depict such behavior are `Malicious Applications`.
 
  
## Airpush-Malware 
 
 > Contains apks, system calls obtained on dynamic execution of the file , the jawa code and java code for **one Android application of Airpush Family**.

## Systemcalls-Androzoo-apps

Contains System calls of both benign and Malicious android applications obtained from Androzoo. I will keep on adding files to this directory as required.

Some options I have used are 

* Throttle of `10` milliseconds between each event 
* `2500` Random events  
 
## How to Obtain System calls  

1. Run Genymotion as administrator and start a device
2. Change the device's read only permission to read write as `adb shell mount -o rw,remount -t yaffs2 rootfs /`
3. Change the destination on the script accordingly and run it as `bash Task.sh <apk-containing-folder>`

`aapt` and `adb` should be added to the Environnemt Path
