#!/bin/bash


branch_name="$(git symbolic-ref HEAD 2>/dev/null)" || branch_name="(unnamed branch)"     # detached HEAD
branch_name=${branch_name##refs/heads/}

if [[ $branch_name == release/* ]]; then
  echo 'this is a release branch'
else
  echo 'this is not a release barnch, please swith to a release branch'
fi


versionNumber=`echo $branch_name | awk -F '[/ -]' '{ print $2 }'`
echo $versionNumber


git checkout master
git merge --no-ff $branch_name

cd `pwd`/..
mvn versions:set -DnewVersion=$versionNumber
mvn versions:commit

git commit -am 'update to release version:' v$versionNumber

git tag v$versionNumber
git push --tags

