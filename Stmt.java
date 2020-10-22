class Stmt implements Token
{
    int statuscode;
    Expr expr;
    Stmt stmt;
    Stmts stmts;
    IfEnd ifEnd;
    Name name;
    Readlist readlist;
    Printlist printlist;
    Printlinelist printlinelist;
    String id;
    Args args;
    Fielddecls fielddecls;
    Optionalsemi optionalsemi;

    public Stmt(int code, Expr e, Stmt s, IfEnd ie)
    {
        statuscode = code;
        expr = e;
        stmt = s;
        ifEnd = ie;
    }
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

    public String toString(int t)
    {
        String ret = "";

        switch(statuscode) {
            case 1:
                if (expr != null && stmt != null && ifEnd != null)
                    ret += "if (" + expr.toString(t) + ") " + stmt.toString(t) + ifEnd.toString(t);
                break;
            case 2:
                if (expr!= null && stmt != null)
                    ret += "while (" + expr.toString(t) + ") " + stmt.toString(t);
                break;
            case 3:
                if (name != null && expr != null)
                    ret += name.toString(t) + " = " + expr.toString(t) + ";\n";
                break;
            case 4:
                ret = "read (" + readlist.toString(t) + ");\n";
                break;
            case 5:
                ret = "print (" + printlist.toString(t) + ");\n";
                break;
            case 6:
                ret = "printline (" + printlinelist.toString(t) + ");\n";
                break;
            case 7:
                ret = id + " ();\n";
                break;
            case 8:
                ret = id + " (" + args.toString(t) + ");\n";
                break;
            case 9:
                ret = "return ;\n";
                break;
            case 10:
                ret = "return " + expr.toString(t) + ";\n";
                break;
            case 11:
                ret = name.toString(t) + "++;";
                break;
            case 12:
                ret = name.toString(t) + "--;";
                break;
            case 13:
                ret = "{ " + fielddecls.toString(t) + stmts.toString(t) + " } " + optionalsemi.toString(t);
                break;
            default:
                ret = "ERROR in Stmt.java";
        }
        return ret;
    }
}