#!/bin/sh
. ./stopJenkinsMaster.sh
docker run  --name his-jenkins-master -d --rm -p 8080:8080 -p 50000:50000 -v /home/ec2-user/jenkins_home:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):/usr/bin/docker isaacguo/his-jenkins-master:latest
wget https://repo.jenkins-ci.org/releases/org/jenkins-ci/plugins/swarm-client/3.7/swarm-client-3.7.jar
nohup java -jar swarm-client-3.7.jar -master http://localhost:8080 -username admin -password admin@1 -name jenkins-swarm-slave-1  &
