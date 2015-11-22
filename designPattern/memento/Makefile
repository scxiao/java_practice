JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Memento.java \
	Originator.java \
	CareTaker.java \
	MementoPatternDemo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java MementoPatternDemo
	echo "";




