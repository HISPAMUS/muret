VEROVIOMR=/Users/drizo/apps/veroviomr/tools/verovio
rm files.lst 2> /dev/null
rm *.agnosticv4
rm *.svg
# note some krn files will be mens
for krn in $(find . -name "*.krn" -print); do
	echo $krn
	fbname=$(basename "$krn" .krn)
	outputFileName=${fbname}.agnosticv4
	${VEROVIOMR} ${krn} | sort -k1 -k2r -n > ${outputFileName}
	echo ${outputFileName} >> files.lst
	echo "-----"
done

echo "TO-DO: Use the transducer to translate agnostic to semantic and check the obtained semantic ekern is equivalent to the krn"
