#!/bin/bash
#It renders the different encodings and logs the errors to a file

INPUTFOLDER="/tmp/allcoretests"
VEROVIO="verovio --adjust-page-height --adjust-page-width"
VEROVIO_OUTPUT=" -o "
VEROVIO_SKM="./verovio_skm.sh"
VEROVIO_SKM_OUTPUT=" -o "
LILYPOND="/Applications/LilyPond.app/Contents/Resources/bin/lilypond -s"
LILYPOND_OUTPUT=" -o "
MUSESCORE="/Applications/MuseScore 3.app/Contents/MacOS/mscore"
MUSESCORE_OUTPUT=" -o "

ERRORS="/tmp/allcoretests/output/errors"

function processEncoding() {
  extension=$1
  command=$2
  outputSuffix=$3
  outputExtension=$4
  outputFolder="/tmp/allcoretests/output/${extension}"

  mkdir -p "${ERRORS}/${extension}"
  mkdir -p ${outputFolder}

  for sourceFile in $(find $INPUTFOLDER -name "*.${extension}" -print); do
	  echo "Processing ${sourceFile}"
    filename=$(basename $sourceFile ".${extension}")
    errorfile="${ERRORS}/${extension}/${filename}.txt"
    "${command}" ${outputSuffix} "${outputFolder}/${filename}.${outputExtension}" ${sourceFile} 2> ${errorfile}
    if [ ! -s "${errorfile}" ]; then
      rm ${errorfile}
    fi
  done
}


processEncoding "musicxml" "${MUSESCORE}" "${MUSESCORE_OUTPUT}" "pdf"
#processEncoding "mei" "${VEROVIO}" "${VEROVIO_OUTPUT}" "svg"
#processEncoding "skm" "${VEROVIO_SKM}" "${VEROVIO_SKM_OUTPUT}" "svg"
#processEncoding "ly" "${LILYPOND}" "${LILYPOND_OUTPUT}" ""

