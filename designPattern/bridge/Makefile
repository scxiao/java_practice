JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	DrawAPI.java \
	RedCircle.java \
	GreenCircle.java \
	Shape.java \
	Circle.java \
	BridgePatternDemo.java


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java BridgePatternDemo
	echo "";
