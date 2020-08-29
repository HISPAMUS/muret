#!/bin/bash
#It renders the different encodings and logs the errors to a file
DOCUMENTATIONFOLDER="/Users/drizo/cmg/investigacion/software/github/repositorioHispamus/documentation/mOOsicae/examples/allcoretests"
INPUTFOLDER="/tmp/allcoretests"
VEROVIO="verovio"
VEROVIO_OUTPUT=" -o "
VEROVIO_SKM="./verovio_skm.sh"
VEROVIO_SKM_OUTPUT=" -o "
LILYPOND="/Applications/LilyPond.app/Contents/Resources/bin/lilypond"
LILYPOND_OUTPUT=" -o "
MUSESCORE="/Applications/MuseScore 3.app/Contents/MacOS/mscore"
MUSESCORE_JOB=./add_mscore_file_to_job.sh
#MUSESCORE_OUTPUT=" -o "

# For MScore, use the batch job converting multiple documents using a JSON:
# https://musescore.org/en/handbook/command-line-options#EXAMPLES
MSCORE_JSON=/tmp/mscore.json

rm -rf ${DOCUMENTATIONFOLDER}
mkdir -p ${DOCUMENTATIONFOLDER}
cp -r ${INPUTFOLDER}/* ${DOCUMENTATIONFOLDER}



function processEncoding() {
  extension=$1
  command=$2
  outputSuffix=$3
  outputExtension=$4
  parameters=$5

	echo "[" > ${MSCORE_JSON}
  first=true

  for sourceFile in $(find $DOCUMENTATIONFOLDER -name "*.${extension}" -print); do
	echo "Processing ${sourceFile}"	  

	if [ "$first" = true ] ; then
    	first=false
    else
    	echo "," >> ${MSCORE_JSON}
	fi    

    filename=$(basename $sourceFile ".${extension}")
    errorfile="${sourceFile}.error.txt"
    outputfile="${sourceFile}.${outputExtension}"
    "${command}" ${parameters} ${outputSuffix} ${outputfile} ${sourceFile} 2> ${errorfile}
    if [ ! -s "${errorfile}" ]; then # if empty file
      rm ${errorfile}
    else 
    	./remove_non_error_${extension}.sh ${errorfile}
    fi
    
  done
}

processEncoding "mei" "${VEROVIO}" "${VEROVIO_OUTPUT}" "svg" " --adjust-page-height --adjust-page-width" 
#processEncoding "skm" "${VEROVIO_SKM}" "${VEROVIO_SKM_OUTPUT}" "svg" ""
processEncoding "ly" "${LILYPOND}" "${LILYPOND_OUTPUT}" "" "-s"


#Rather use the command below for MusicXML with MScore: processEncoding "musicxml" "${MUSESCORE}" "${MUSESCORE_OUTPUT}" "pdf"
processEncoding "musicxml" "${MUSESCORE_JOB}" "" "pdf" "${MSCORE_JSON}"
echo "]" >> ${MSCORE_JSON}

"${MUSESCORE}" -j ${MSCORE_JSON}
