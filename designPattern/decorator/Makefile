JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Shape.java \
	Circle.java \
	Square.java \
	ShapeDecorator.java \
	RedShapeDecorator.java \
	DecoratedPatternDemo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java DecoratedPatternDemo
	echo "";


