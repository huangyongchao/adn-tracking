#!/bin/sh
pname='xrtb.jar'
echo "restart to deploy ${pname}"
projectdir=/opt/xrtb/
pno=0
for i in `ps -ef | grep  ${pname}  |grep -v auto |grep -v grep | grep java | awk '{print $2}'`
do
  echo $i
  pno=$i
  #kill $i
  #sleep 3
done
echo $pno

if test $pno -eq 0
then
    echo 'stoping'
    datetime=`date +%Y%m%d%H%M%S`
    echo $datetime
    cd  $projectdir
    java -Xms2g -Xmx2g  -jar xrtb.jar --spring.profiles.active=prod 2>&1 &
    echo "xrtb service is restart..."
else
    echo 'running'
fi