JFLAGS = -g -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AddVec.java \
	TestAddVec.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

