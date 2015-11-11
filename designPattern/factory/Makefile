JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Shape.java \
	Circle.java \
	Square.java \
	Color.java \
	Blue.java \
	Green.java \
	Red.java \
	AbstractFactory.java \
	ShapeFactory.java \
	ColorFactory.java \
	FactoryProducer.java \
	TestShape.java \
	FactoryPatternDemo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./factory/*.class

test:
	java TestShape
	echo "";
	java FactoryPatternDemo

