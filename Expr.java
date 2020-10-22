class Expr implements Token
{
    int statuscode;
    Name name;
    String id;
    Args args;
    String intlit;
    String charlit;
    String strlit;
    String floatlit;
    boolean trueorfalse;
    Expr expr;
    Expr expr2;
    Expr expr3;
    Type type;
    Binaryop binaryop;

    public Expr(int code, Name n)
    {
        statuscode = code;
        name = n;
    }

    public Expr(int code, String str)
    {
        statuscode = code;

        if(code == 2) {
            id = str;
        }
        else if(code == 5) {
            charlit = str;
        }
        else if(code == 6) {
            strlit = str;
        }
        else if(code == 7) {
            floatlit = str;
        }
        else if(code == 4) {
            intlit = str;
        }
    }

    public Expr(int code, String i, Args a)
    {
        statuscode = code;
        id = i;
        args = a;
    }
/*
    public Expr(int code, int i)
    {
        statuscode = code;
        intlit = i;
    }
*/
/*
    public Expr(int code, double fl)
    {
        statuscode = code;
        floatlit = fl;
    }
*/
    public Expr(int code, boolean tf)
    {
        statuscode = code;
        trueorfalse = tf;
    }

    public Expr(int code, Expr e)
    {
        statuscode = code;
        expr = e;
    }

    public Expr(int code, Type t, Expr e)
    {
        statuscode = code;
        type = t;
        expr = e;
    }

    public Expr(int code, Binaryop b)
    {
        statuscode = code;
        binaryop = b;
    }

    public Expr(int code, Expr e1, Expr e2, Expr e3)
    {
        statuscode = code;
        expr = e1;
        expr2 = e2;
        expr3 = e3;
    }

    public String toString(int t)
    {
        String ret = "";

        switch(statuscode) {
            case 1:
                if(name != null) {
                    ret += name.toString(t);
                }
                break;
            case 2:
                if (id != null) {
                    ret += id + " ()";
                }
                break;
            case 3:
                if (id != null && args != null) {
                    ret += id + "  (" + args.toString(t) + ") ";
                }
                break;
            case 4:
                ret = intlit;
                break;
            case 5:
                if (charlit != null) {
                    ret += charlit;
                }
                break;
            case 6:
                if (strlit != null) {
                    ret += strlit;
                }
                break;
            case 7:
                ret = floatlit;
                break;
            case 8:
                if(trueorfalse == true) {
                    ret += "true";
                }
                else if(trueorfalse == false) {
                    ret += "false";
                }
                break;
            case 9:
                if (expr != null) {
                    ret += "(" + expr.toString(t) + ")";
                }
                break;
            case 10:
                if (expr != null) {
                    ret += "~" + expr.toString(t);   
                }
                break;
            case 11:
                if (expr != null) {
                    ret += "-" + expr.toString(t);   
                }
                break;
            case 12:
                if (expr != null) {
                    ret += "+" + expr.toString(t);   
                }
                break;
            case 13:
                if (type != null && expr != null) {
                    ret += "(" + type.toString(t) + ") " + expr.toString(t);   
                }
                break;
            case 14:
                if (binaryop != null) {
                    ret += binaryop.toString(t);
                }
                break;
            case 15:
                if (expr != null && expr2 != null && expr3 != null) {
                    ret += "( " + expr.toString(t) + " ? " + expr2.toString(t) + " : " + expr3.toString(t) + " )\n";
                }
                break;
            default:
                ret += "ERROR in Expr.java";
        }
        return ret;
    }
}