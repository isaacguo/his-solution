#!/bin/sh
. ./stopJenkinsMaster.sh
#docker run  --name his-jenkins-master -d -p 8080:8080 -p 50000:50000 -v /var/jenkins_home:/var/jenkins_home isaacguo/his-jenkins-master:latest
#wget https://repo.jenkins-ci.org/releases/org/jenkins-ci/plugins/swarm-client/3.7/swarm-client-3.7.jar

docker-compose up -d
#nohup java -jar swarm-client-3.7.jar -master http://localhost:8080 -username admin -password admin@1 -name jenkins-swarm-slave-1  &

