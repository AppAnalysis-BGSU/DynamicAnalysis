The hierarchy or organization of files(Android applications) in the Dr. Roy Machine is highlighted below
________________

## On the 8TB drive /media/seagate/Androzoo  
  > we have Virustotal related reports and downloads. Do not use this drive for any other purposes.
  [Click here to see how to manage downloads](https://github.com/AppAnalysis-BGSU/ApkDownlodScan/blob/master/whendownloadstops_alternate.md)
  
## On the 4TB drive /media/wd-duo

 * Before we go 
  > AMD is Android Malware Dataset : has only malicious apps
  
  > Androzoo dataset has both Malicious and Benign apps, thus we need to fileter which apps are malicious and which ones are benign based on the VirusTotal reports obtained.


 * This drive has both malicious and benign android applications. I will walk into detail of this drive (mostly used drive).
 
                                            /media/wd-duo (4TB)
                                                    |
                                                    |
        ----------------------------------------------------------------------------------
        |                        |                          |                            | 
        |                        |                          |                            | 
        AMD                   AMD-filtered                 Androzoo               Androzoo-filtered
        (original copy)                                   (original copy)                                        
        |                                                      |         
        |                                                      |     
       -------------------------                               -----------------------------     
       |                       |                                        |                  | 
       |                       |                                        |                  |
       AMDapks                  reports                               downloads           report 
       (all apks inside)      (all corresponding reports inside)      downloads2          report2
       (no sub directories)    (no sub directories)                   downloads3          report3
                                                                      downloads4          report4

Unless needed for certain, do not use the original dataset that we have. Instead use AMD-filtered and Androzoo-filtered dataset. Move data from above 8TB drive do orginal copy folders and then filter them, save them to filtered folder. Organization explained here:

                                                         AMD-filtered
                                                              |
                                                              |
            ---------------------------------------------------------------------------------------
            |                                       |                                           |
            |                                       |                                           |      
     ExecutedApksFolder (no sub directories)      Malicious-dir001              Output-syscall-files     
    * when an app is executed                     Malicious-dir-002             (has output syscall files)
    (systrace collected, place it here)           .                             (no sub directories)        
                                                  .                                              ^    
                   ^                             (execute apps from these directories)           | 
                   |                              * save syscall to ------------------------------
                   ------------------------------* move executed apps to 
                                                  
    
    
    
                                                        Androzoo-filtered
                                                                |
                                                                |
             ----------------------------------------------------------------------------------------------
             |                                          |                         |                       |
             |                                          |                         |                       |
          downloads                                downloads2                 downloads3           downloads4
    
   each downloads.* folder has roughly 50K apps, organized into folders for simplicity. If you have executed all applications from each of these downloads folder, copy next `downloads` folder from `/media/seagate/Androzoo`
     
  
 Following is the organization of data in Androzoo-filtered (explained with downloads2)
 
                                                         downloads2
                                                              |
                                                              |
            ----------------------------------------------------------------------------------------------------
            |                                      |                        |                                  |     
            |                                      |                        |                                  |     
    Androzoo-Benign                       Androzoo-malicious                Executed Apks                 Output-syscalls
    * consists of Benign apks                * consists of malicious apks    (once executed, move here)           |
    * maintained in subdirectories within    * not executed apks                  |                               |
    * not exeuted apks here                                                       |                           save Benign and     
                                                                 -------------------------------------        malicious output 
                                                                 |                                   |        files to separate 
                                                                 |                                   |              folders
                                                            ExecutedBenignApks             ExecutedMaliciousApks
                                                         (all benign executed .apk files) (all malicious executed .apk files)


    
    
