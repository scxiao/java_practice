JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Person.java \
	Criteria.java \
	CriteriaFemale.java \
	CriteriaMale.java \
	CriteriaSingle.java \
	AndCriteria.java \
	OrCriteria.java \
	CriteriaPatternDemo.java


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java CriteriaPatternDemo
	echo "";

