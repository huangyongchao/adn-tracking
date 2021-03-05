#!/bin/sh
source /etc/profile
projectdir=/root
pno=0
for i in `ps -ef | grep  luminati-io  |grep -v auto |grep -v grep  | awk '{print $2}'`
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
    `luminati -d`
    echo "luminati service is restart..."
else
    echo 'luminati running'
fi



pno=0
for i in `ps -ef | grep  sdk.jar  |grep -v auto |grep -v grep | grep java | awk '{print $2}'`
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
    sh deploysdk.sh 2>&1 &
    echo "sdk service is restart..."
else
    echo 'sdk running'
fi