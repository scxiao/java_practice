all:
	cd binarytree; make
	cd generics; make
	cd lracache; make
	cd seqalign/ver1; make
	cd seqalign/tools; make
	cd simpleExamples; make
	cd multithread; make
	cd designPattern; make

clean:
	cd binarytree; make clean
	cd generics; make clean
	cd lracache; make clean
	cd seqalign/ver1; make clean
	cd seqalign/tools; make clean
	cd simpleExamples; make clean
	cd multithread; make clean
	cd designPattern; make clean

