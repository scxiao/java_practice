JFLAGS = -g -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	MyHashTable.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class impl/*.class

