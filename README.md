# DynamicAnalysis
 Deep learning to classify android applications as `benign` and `malicious`. 
 
## Contents of above directories:

### Airpush-Malware 
 
 > Contains apks, system calls obtained on dynamic execution of the file , the jawa code and java code for **one Android application of Airpush Family**.

### Systemcalls-Androzoo-apps

Contains System calls of both benign and Malicious android applications obtained from Androzoo (Broken down to folders of 500 each due to github restrictions). I will keep on adding files to this directory as required.

### Systemcalls-AMD-apps
Contains System calls of Malicious android applications obtained from the AMD Dataset.

### Outputs and Observations
Contains graphs and summary of results obtained. 

Some options I have used are 

* Throttle of `20` milliseconds between each event 
* `5000` Random events  
 
## How to Obtain System calls  

We use Genymotion on AWS to execute our applications. Desktop version of Genymotion had issue with executing large number of applications and we shifted to the cloud. Android nougat emulator used to execute the applications.

OR

1. Run Genymotion as administrator and start a device
2. Change the device's read only permission to read write as `adb shell mount -o rw,remount -t yaffs2 rootfs /`
3. Change the destination on the script accordingly and run it as `bash Task.sh <apk-containing-folder>`

`aapt` and `adb` should be added to the Environnemt Path
