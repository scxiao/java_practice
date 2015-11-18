JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Stock.java \
	Order.java \
	BuyStock.java \
	SellStock.java \
	Broker.java \
	CommandPatternDemo.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java CommandPatternDemo
	echo "";



