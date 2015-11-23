JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Observer.java \
	Subject.java \
	BinaryObserver.java \
	HexaObserver.java \
	OctalObserver.java \
	ObserverPatternDemo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java ObserverPatternDemo
	echo "";




