JFLAGS = -g -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	MyLinkedList.java \
	MyStack.java \
	MyHashTable.java \
	TestBox.java \
	TestMyStack.java \
	TestMyHashTable.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class impl/*.class

