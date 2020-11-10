#!/bin/sh
pname='redis'
echo "restart to deploy redis"
projectdir=/opt/redis
pno=0
for i in `ps -ef | grep  redis-server  |grep -v auto |grep -v grep | awk '{print $2}'`
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
    $(src/redis-server redis.conf &)
    echo "Redis service is restart..."
else
    echo 'Redis running'
fi