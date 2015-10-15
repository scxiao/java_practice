all:
	cd binarytree; make
	cd generics; make
	cd lracache; make
	cd seqalign; make

clean:
	cd binarytree; make clean
	cd generics; make clean
	cd lracache; make clean
	cd seqalign; make clean

