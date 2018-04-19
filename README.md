# DynamicAnalysis
Deep learning to analyze android applications

## Airpush-Malware 
 
 > Contains apks, system calls obtained on dynamic execution of the file , the jawa code and java code for **one Android application of Airpush Family**.

## Systemcalls-Androzoo-apps

Contains System calls of both benign and Malicious android applications obtained from Androzoo. I will keep on adding files to this directory as required.

Some options I have used are 

* Throttle of `10` milliseconds between each event 
* `2500` Random events  
 
 
 
Run Task.sh using `bash Task.sh <Path to directory containing apk files`

Make Sure you provide valid path for the files to be pulled and saved inside the `Task.sh` script.

`aapt` and `adb` should be added to the Environnemt Path
