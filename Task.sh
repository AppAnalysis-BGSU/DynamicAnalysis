#!/bin/bash
for app in $1/*
do
	
	
	pkgname=$(aapt dump badging $app | gawk -v FS="'" '/package: name=/{print $2}')
	appname=$(aapt dump badging $app | gawk -v FS="'" '/application-label:/{print $2}') 
	#echo "this is "$appname
	adb install -t $app
	adb shell monkey -p $pkgname 1
	prcsid=$(adb shell ps | grep $pkgname | gawk -v FS=" " '{print $2}')
	#echo "this is the pid"$prcsid
	nametosave=$(sha1sum $app |gawk -v FS=" " '{print $1}' )
	#echo "this is nametosave"$nametosave
	adb shell strace -p $prcsid -C -o $nametosave &
	adb shell monkey -p $pkgname -v 50 -s 1521601858763 
	#sleep 5
	adb shell am force-stop $pkgname
	adb uninstall $pkgname
	#echo $appname >> $nametosave
	#adb push Task.sh "//Task.sh" 
	#adb pull "//$nametosave" ./StraceFiles      #source destination
	adb pull "//$nametosave" /c/Strace/StraceFilesOut
	adb shell rm $nametosave   #delete it from the adb 
done
