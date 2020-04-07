#!/bin/bash
outputSuffix=$1
outputFile=$2
sourceFile=$3

filename=$(basename $sourceFile ".${extension}")
sed 's/skern/kern/g' $sourceFile > /tmp/aaa.krn
verovio --adjust-page-height --adjust-page-width /tmp/aaa.krn ${outputSuffix} ${outputFile}

