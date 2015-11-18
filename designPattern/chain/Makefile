JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AbstractLogger.java \
	ConsoleLogger.java \
	ErrorLogger.java \
	FileLogger.java \
	ChainPatternDemo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java ChainPatternDemo
	echo "";


