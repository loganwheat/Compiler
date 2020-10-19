JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-1.8.2/lib/jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
	$(JAVAC) -cp $(CP) $*.java

FILE=	Scanner.java parser.java sym.java ParserTest.java

dump: parserD.java $(FILE:java=class)

run: testFile.txt

testFile.txt: all
	$(JAVA) -cp $(CP) ParserTest testFile.txt > testFile-output.txt
	cat -n testFile-output.txt

all: Lexer.java parser.java $(FILE:java=class)

clean:
	rm -f *.class *~ *.bak Scanner.java parser.java sym.java

Scanner.java: grammar.jflex
	$(JFLEX) grammar.jflex

parser.java: tokens.cup
	$(CUP) -interface -progress < tokens.cup

parserD.java: tokens.cup
	$(CUP) -interface -dump < tokens.cup
