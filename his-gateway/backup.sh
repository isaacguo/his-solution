#!/bin/bash
#Explanation: The $(...) returns the output from the subcommands as a string, which we store in the variable d.
d="$(date +"%F-%H-%M-%S")"
cd /his-backup
mkdir "$d"
cd "$d"

PASSWORD="His_Solution_p4ssw0rd"
db_names=("employee" "finance" "gateway" "medicaltest" "medicine" "procurement" "treatment")

for i in "${db_names[@]}"
do
  docker ps -aqf "name=his-db" | xargs -I % docker exec % /usr/bin/mysqldump -uroot --password=${PASSWORD} $i > $i.sql
done

