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
		TypeCheckerTest.java TypeCheckException.java Scope.java FullType.java\
		Program.java Memberdecls.java Fieldsmethods.java Fielddecls.java Methoddecls.java \
		Fielddecl.java Optionalexpr.java Methoddecl.java Optionalsemi.java \
		Type.java Argdecls.java ArgdeclList.java Argdecl.java Stmts.java Stmt.java \
		Name.java Args.java Readlist.java Printlist.java Printlinelist.java \
		Expr.java Binaryop.java

dump: parserD.java $(FILE:java=class)

run: badDec.as badInc.as badNegation.as badString.as badTernaryCond.as badTernaryTypes.as \
	boolToFloat.as boolToInt.as callNonExistFunc.as charToFloat.as charToInt.as \
	floatToInt.as incompatBinary.as intArrayToBoolArray.as \
	noReturn.as reassignFinal.as redefMethod.as redefVar.as redefVarAsMethod.as \
	returnTypeBad.as

badDec.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/badDec.as > project3tests/badDec-output.txt
	cat -n project3tests/badDec-output.txt

badInc.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/badInc.as > project3tests/badInc-output.txt
	cat -n project3tests/badInc-output.txt

badNegation.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/badNegation.as > project3tests/badNegation-output.txt
	cat -n project3tests/badNegation-output.txt

badString.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/badString.as > project3tests/badString-output.txt
	cat -n project3tests/badString-output.txt

badTernaryCond.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/badTernaryCond.as > project3tests/badTernaryCond-output.txt
	cat -n project3tests/badTernaryCond-output.txt

badTernaryTypes.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/badTernaryTypes.as > project3tests/badTernaryTypes-output.txt
	cat -n project3tests/badTernaryTypes-output.txt

boolToFloat.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/boolToFloat.as > project3tests/boolToFloat-output.txt
	cat -n project3tests/boolToFloat-output.txt

boolToInt.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/boolToInt.as > project3tests/boolToInt-output.txt
	cat -n project3tests/boolToInt-output.txt

callNonExistFunc.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/callNonExistFunc.as > project3tests/callNonExistFunc-output.txt
	cat -n project3tests/callNonExistFunc-output.txt

charToFloat.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/charToFloat.as > project3tests/charToFloat-output.txt
	cat -n project3tests/charToFloat-output.txt

charToInt.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/charToInt.as > project3tests/charToInt-output.txt
	cat -n project3tests/charToInt-output.txt

floatToInt.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/floatToInt.as > project3tests/floatToInt-output.txt
	cat -n project3tests/floatToInt-output.txt

fullValidProgramDE.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/fullValidProgramDE.as > project3tests/fullValidProgramDE-output.txt
	cat -n project3tests/fullValidProgramDE-output.txt

incompatBinary.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/incompatBinary.as > project3tests/incompatBinary-output.txt
	cat -n project3tests/incompatBinary-output.txt

intArrayToBoolArray.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/intArrayToBoolArray.as > project3tests/intArrayToBoolArray-output.txt
	cat -n project3tests/intArrayToBoolArray-output.txt

noReturn.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/noReturn.as > project3tests/noReturn-output.txt
	cat -n project3tests/noReturn-output.txt

reassignFinal.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/reassignFinal.as > project3tests/reassignFinal-output.txt
	cat -n project3tests/reassignFinal-output.txt

redefMethod.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/redefMethod.as > project3tests/redefMethod-output.txt
	cat -n project3tests/redefMethod-output.txt

redefVar.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/redefVar.as > project3tests/redefVar-output.txt
	cat -n project3tests/redefVar-output.txt

redefVarAsMethod.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/redefVarAsMethod.as > project3tests/redefVarAsMethod-output.txt
	cat -n project3tests/redefVarAsMethod-output.txt

returnTypeBad.as: all
	$(JAVA) -cp $(CP) TypeCheckerTest project3tests/returnTypeBad.as > project3tests/returnTypeBad-output.txt
	cat -n project3tests/returnTypeBad-output.txt

all: Scanner.java parser.java $(FILE:java=class)

clean:
	rm -f *.class *~ *.bak Scanner.java parser.java sym.java dump.txt

Scanner.java: grammar.jflex
	$(JFLEX) grammar.jflex

parser.java: tokens.cup
	$(CUP) -interface -progress < tokens.cup

parserD.java: tokens.cup
	$(CUP) -interface -dump < tokens.cup 2> dump.txt
