JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	UserInterface.java \
	ChatRoom.java \
	User.java \
	MediatorPatternDemo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java MediatorPatternDemo
	echo "";




