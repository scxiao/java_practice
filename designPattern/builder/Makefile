JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Packing.java \
	Item.java \
	Bottle.java \
	Wrapper.java \
	Burger.java \
	CheckenBurger.java \
	VegBurger.java \
	Drink.java \
	Coke.java \
	Pepsi.java \
	Meal.java \
	MealBuilder.java \
	BuilderPatternDemo.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java BuilderPatternDemo

