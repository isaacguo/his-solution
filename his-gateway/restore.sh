#!/bin/bash

FOLDER=$1
password="His_Solution_p4ssw0rd"
dropDatabase=$2
createDatabase=$3
importData=$4

restore()
{
DOCKER_DB_NAME=$1
DB_NAME=$2
SQL_FILE_NAME=$3
PASSWORD=$4


if [ "$dropDatabase" = true ]; then
docker ps -aqf "name=$DOCKER_DB_NAME" | xargs -I % sh -c "docker exec % mysql -uroot --password=${password} -Bse 'drop database ${DB_NAME}'"
fi
if [ "$createDatabase" = true ]; then
docker ps -aqf "name=$DOCKER_DB_NAME" | xargs -I % sh -c "docker exec % mysql -uroot --password=${password} -Bse 'create database ${DB_NAME}'"
fi
if [ "$importData" = true ]; then
docker ps -aqf "name=$DOCKER_DB_NAME" | xargs -I % sh -c "cat ${SQL_FILE_NAME} | docker exec -i % mysql -uroot --password=${password} ${DB_NAME}"
fi
}

cd ${FOLDER}

db_names=("employee" "finance" "gateway" "medicaltest" "medicine" "procurement" "treatment")

for i in "${db_names[@]}"
do
  restore his-db $i $i.sql ${password}
done

