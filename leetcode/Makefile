JFLAGS = -g -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	TestPalindrome.java \
	TestGetKthNum.java \
	TestDataCheck.java \
	TestReverseWords.java \
	TestMaxPointsOnLine.java \
	TestSetColor.java


default: classes

classes: $(CLASSES:.java=.class)

run:
	java TestPalindrome aba
	java TestPalindrome abc
	java TestGetKthNum 10
	java TestGetKthNum 20

clean:
	$(RM) *.class impl/*.class

