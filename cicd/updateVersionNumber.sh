#!/bin/bash

 cd `pwd`/..
 mvn versions:set -DnewVersion=$1
 mvn versions:commit

 git add .
 git commit -m 'updated version number to '$1
