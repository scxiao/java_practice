JFLAGS = -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	MediaPlayer.java \
	AdvancedMediaPlayer.java \
	Mp4Player.java \
	VlcPlayer.java \
	MediaAdapter.java \
	AudioPlayer.java \
	AdapterPatternDemo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class ./impl/*.class

test:
	java AdapterPatternDemo
	echo ""

