#!/bin/sh

#docker stop his-jenkins-master
pkill -f "swarm-client"
docker-compose down
