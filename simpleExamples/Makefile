JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	EnumeratorTester.java \
	GenQueue.java \
	GetKthNum.java \
	InputStreamDemo.java \
	IteratorDemo.java \
	ReadDir.java \
	TestSort.java \
	TestStringByte.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class impl/*.class


