#!/bin/bash
docker-compose down
docker ps -a | grep his | awk {'print $1'} | xargs docker stop
docker ps -a | grep his | awk {'print $1'} | xargs docker rm
docker-compose pull
docker-compose run his_start_his-config
docker-compose up -d