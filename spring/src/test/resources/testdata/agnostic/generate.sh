VEROVIOMR=/Users/drizo/apps/veroviomr/tools/verovio
rm files.lst 2> /dev/null
rm *.agnostic
rm *.svg
for krn in $(find . -name "*.krn" -print); do
	echo $krn
	fbname=$(basename "$krn" .krn)
	outputFileName=${fbname}.agnosticv4
	${VEROVIOMR} ${krn} | sort -k1 -k2r -n > ${outputFileName}
	echo ${outputFileName} >> files.lst
	echo "-----"
done
