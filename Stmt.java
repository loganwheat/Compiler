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

    /*
    public Stmt(int code, Expr e, Stmt s, IfEnd ie)
    {
        statuscode = code;
        expr = e;
        stmt = s;
        ifEnd = ie;
    }
    */
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
        
    }
}