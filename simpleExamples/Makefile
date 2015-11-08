JFLAGS = -g -d .
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
	TestStringByte.java \
	MultiThread1.java \
	MultiThread2.java \
	DisplayMessage.java \
	GuessANumber.java \
	ThreadClassDemo.java \
	Student.java \
	Undergraduate.java \
	Graduate.java \
	TestStudent.java \
	SerializeDemo.java \
	TestQueue.java \
	TestThread.java \
	TestWaitNotify.java \
	TestThread1.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class impl/*.class


