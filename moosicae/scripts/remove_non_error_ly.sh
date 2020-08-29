#!/bin/bash

if [ $# != 1 ]; then
	echo "Missing parameter"
	exit -1
fi

if [ $(grep -c "Success:" $1) == 1 ]; then
	# if success, remove if
	echo $1
	#rm $1
fi