#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "A release version number is needed"
        exit 1
	fi

	branch_name="$(git symbolic-ref HEAD 2>/dev/null)" || branch_name="(unnamed branch)"     # detached HEAD
	branch_name=${branch_name##refs/heads/}


	if [ $branch_name != "develop" ]
	then
	  echo 'Current branch is: '$branch_name'. Please checkout develop branch and then run this shell script again'
	    exit 2;

	    else 
	      echo 'Current branch is develop branch. We are good to go' 
	      fi

	      rcVersionNumber=$1-SNAPSHOT
	      rcBranchName=release/$rcVersionNumber

	      echo 'Version to be applied: ' $rcVersionNumber 


	      echo 'Confirm? [Y/N]'
	      read response
	      if [ -n "$response" ]; then
	        confirmResult=$response
		fi

		if [ $confirmResult == 'Y' ] || [ $confirmResult == 'y' ]; then
		  echo 'yes'
		  else 
		    echo 'no'
		      exit 3;
		      fi 

		      git checkout -b $rcBranchName develop

		      cd `pwd`/..
		      mvn versions:set -DnewVersion=$rcVersionNumber
		      mvn versions:commit

		      git commit -am "$rcBranchName is created"
		      git push --set-upstream origin $rcBranchName

