JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Shape.java \
	Circle.java \
	Rectangle.java \
	Square.java \
	ShapeCache.java \
	PrototypePatternDemo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java PrototypePatternDemo
	echo "";
