class Stmt extends Token
{
    int statuscode;
    Expr expr;
    Stmt stmt;
    Stmts stmts;
    //IfEnd ifEnd;
    Name name;
    Readlist readlist;
    Printlist printlist;
    Printlinelist printlinelist;
    String id;
    Args args;
    Fielddecls fielddecls;
    Optionalsemi optionalsemi;
    Stmt smatch;
    Stmt smatch2;
    Stmt sunmatch;

    public Stmt(int code, Expr e, Stmt s)
    {
        statuscode = code;
        expr = e;
        stmt = s;
    }
    public Stmt(int code, Name n, Expr e)
    {
        statuscode = code;
        name = n;
        expr = e;
    }
    public Stmt(int code, Readlist rl)
    {
        statuscode = code;
        readlist = rl;
    }
    public Stmt(int code, Printlist pl)
    {
        statuscode = code;
        printlist = pl;
    }
    public Stmt(int code, Printlinelist pll)
    {
        statuscode = code;
        printlinelist = pll;
    }
    public Stmt(int code, String i)
    {
        statuscode = code;
        id = i;
    }
    public Stmt(int code, String i, Args a)
    {
        statuscode = code;
        id = i;
        args = a;
    }
    public Stmt(int code)
    {
        statuscode = code;
    }
    public Stmt(int code, Expr e)
    {
        statuscode = code;
        expr = e;
    }
    public Stmt(int code, Name n)
    {
        statuscode = code;
        name = n;
    }
    public Stmt(int code, Fielddecls fds, Stmts s, Optionalsemi os)
    {
        statuscode = code;
        fielddecls = fds;
        stmts = s;
        optionalsemi = os;
    }
    public Stmt(int code, Expr e, Stmt s1, Stmt s2)
    {
        statuscode = code;
        expr = e;

        if(code == 14) {
            smatch = s1;
            smatch2 = s2;
        }
        else if (code == 16) {
            smatch = s1;
            sunmatch = s2;
        }
    }



    public String toString(int t)
    {
        String ret = getTabs(t);

        switch(statuscode) {
            case 1:
                ret += "while (" + expr.toString(t) + ") " + stmt.toString(t+1);
                break;
            case 2:
                ret += "while (" + expr.toString(t) + ") " + stmt.toString(t+1);
                break;
            case 3:
                ret += name.toString(t) + " = " + expr.toString(t) + ";";
                break;
            case 4:
                ret += "read (" + readlist.toString(t) + ");";
                break;
            case 5:
                ret += "print (" + printlist.toString(t) + ");";
                break;
            case 6:
                ret += "printline (" + printlinelist.toString(t) + ");";
                break;
            case 7:
                ret += id + " ();";
                break;
            case 8:
                ret += id + " (" + args.toString(t) + ");";
                break;
            case 9:
                ret += "return;";
                break;
            case 10:
                ret += "return " + expr.toString(t) + ";";
                break;
            case 11:
                ret += name.toString(t) + "++;";
                break;
            case 12:
                ret += name.toString(t) + "--;";
                break;
            case 13:
                ret += "{ " + fielddecls.toString(t+1) + stmts.toString(t+1) + getTabs(t) + "} " + optionalsemi.toString(t);
                break;
            case 14:
                ret += "if (" + expr.toString(t) + ") " + smatch.toString(t+1) + getTabs(t) + "else " + smatch2.toString(t+1);
                break;
            case 15:
                ret += "if (" + expr.toString(t) + ") " + stmt.toString(t+1);
                break;
            case 16:
                ret += "if (" + expr.toString(t) + ") " + smatch.toString(t+1) + getTabs(t) + "else " + sunmatch.toString(t+1);
                break;
            default:
                ret += "ERROR in Stmt.java";
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        switch(statuscode) {
            case 1:
                if(!(expr.getType(s).equals("bool"))) {
                    throw new TypeCheckException("Error: while() condition " + expr.toString(0) + " must be of type bool");
                }
                expr.typeCheck(s);
                stmt.typeCheck(s);
                break;
            case 2:
                if(!(expr.getType(s).equals("bool"))) {
                    throw new TypeCheckException("Error: while() condition " + expr.toString(0) + " must be of type bool");
                } 
                expr.typeCheck(s);
                stmt.typeCheck(s);
                break;
            case 3:
                if(!(name.nameType(s).equals(expr.getType(s)))) {
                    throw new TypeCheckException("Error: " + name.nameId() + " must be of equal type to " + expr.toString(0));
                } else if(s.keyIsFinal(name.nameId(), s)) {
                    throw new TypeCheckException("Error: " + name.nameId() + " is final and can not be reassigned to " + expr.toString(0));
                }
                name.typeCheck(s);
                expr.typeCheck(s);
                break;
            case 4:
                readlist.typeCheck(s);
                break;
            case 5:
                printlist.typeCheck(s);
                break;
            case 6:
                printlinelist.typeCheck(s);
                break;
            case 7:
                if(!(s.keyIsFunction(id, s))) {
                    throw new TypeCheckException("Error: Invalid call to function " + id);
                }
                break;
            case 8:
                if(!(s.keyIsFunction(id, s))) {
                    throw new TypeCheckException("Error: Invalid call to function " + id);
                }
                args.typeCheck(s);
                break;
            case 9:
                if(!(s.getReturnType(s).equals("void"))) {
                    throw new TypeCheckException("Error: function return type must be void");
                }
                break;
            case 10:
                if(!(s.getReturnType(s).equals(expr.getType(s)))) {
                    throw new TypeCheckException("Error: function return type must be " + s.getReturnType(s));
                }
                expr.typeCheck(s);
                break;
            case 11:
                if(s.keyIsFinal(name.nameId(), s)) {
                    throw new TypeCheckException("Error: final type " + name.nameId() + " can not be incremented");
                } else if (!(name.nameType(s).equals("int") || name.nameType(s).equals("float"))) {
                    throw new TypeCheckException("Error: invalid type " + name.nameId() + " can not be incremented");
                }
                name.typeCheck(s);
                break;
            case 12:
                if(s.keyIsFinal(name.nameId(), s)) {
                    throw new TypeCheckException("Error: final type " + name.nameId() + " can not be decremented");
                } else if (!(name.nameType(s).equals("int") || name.nameType(s).equals("float"))) {
                    throw new TypeCheckException("Error: invalid type " + name.nameId() + " can not be decremented");
                }
                name.typeCheck(s);
                break;
            case 13:
                Scope childScope = new Scope(s);
                fielddecls.typeCheck(childScope);
                stmts.typeCheck(childScope);
                break;
            case 14:
                expr.typeCheck(s);
                smatch.typeCheck(s);
                smatch2.typeCheck(s);
                break;
            case 15:
                expr.typeCheck(s);
                stmt.typeCheck(s);
                break;
            case 16:
                expr.typeCheck(s);
                smatch.typeCheck(s);
                sunmatch.typeCheck(s);
                break;
            default:
                throw new TypeCheckException("Error in Stmt");
            }
    }
}