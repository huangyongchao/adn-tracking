#!/bin/sh
name=sdk
echo "start to deploy $name"
echo "enter into workspace, " `pwd`
git pull

for i in `ps -ef | grep  $name | grep java | awk '{print $2}'`
do
  echo $i
  kill $i
  sleep 3
done


datetime=`date +%Y%m%d%H%M%S`
echo $datetime

mvn clean install -Dmaven.test.skip=true
`mv ./target/$name*.jar  ./target/$name.jar`
java -server  -Xms256M -Xmx2048M -Xmn256M  -jar "target/$name.jar"  --spring.profiles.active=prod &
echo "$name service is up..."
