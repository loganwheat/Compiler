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

FILE=	Scanner.java parser.java sym.java ParserTest.java \
		Program.java Memberdecls.java Fielddecls.java Methoddecls.java \
		Fielddecl.java Optionalexpr.java Methoddecl.java Optionalsemi.java \
		Type.java Argdecls.java ArgdeclList.java Argdecl.java Stmts.java Stmt.java \
		IfEnd.java Name.java Args.java Readlist.java Printlist.java Printlinelist.java \
		Expr.java Binaryop.java

dump: parserD.java $(FILE:java=class)

run: test1DE.txt test2DE.txt test3.txt test4.txt test5.txt

test1DE.txt: all
	$(JAVA) -cp $(CP) ParserTest test1DE.txt > test1DE-output.txt
	cat -n test1DE-output.txt

test2DE.txt: all
	$(JAVA) -cp $(CP) ParserTest test2DE.txt > test2DE-output.txt
	cat -n test2DE-output.txt

test3.txt: all
	$(JAVA) -cp $(CP) ParserTest test3.txt > test3-output.txt
	cat -n test3-output.txt

test4.txt: all
	$(JAVA) -cp $(CP) ParserTest test4.txt > test4-output.txt
	cat -n test4-output.txt

test5.txt: all
	$(JAVA) -cp $(CP) ParserTest test5.txt > test5-output.txt
	cat -n test5-output.txt

all: Scanner.java parser.java $(FILE:java=class)

clean:
	rm -f *.class *~ *.bak Scanner.java parser.java sym.java

Scanner.java: grammar.jflex
	$(JFLEX) grammar.jflex

parser.java: tokens.cup
	$(CUP) -interface -progress < tokens.cup

parserD.java: tokens.cup
	$(CUP) -interface -dump < tokens.cup
