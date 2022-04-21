OUTDIR := ./build

run: clean build
	java -cp ${OUTDIR} Main ${arg1}
build:
	mkdir -p ${OUTDIR}
	javac Main.java -g -d ${OUTDIR}
rebuild: clean run
clean:
	rm -r -f ${OUTDIR}