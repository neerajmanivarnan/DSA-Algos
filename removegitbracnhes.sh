#!/bin/bash

while read line ; do
	if [[ "$line" = "* master" ]] ; then
		echo master branch found : $line
	else
		$(git branch -d "$line")
		echo "Branch $line deleted"
	fi
done < "$1"

