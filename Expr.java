class Expr implements Token
{
    int statuscode;
    Name name;
    String id;
    Args args;
    int intlit;
    String charlit;
    String strlit;
    double floatlit;
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
    }

    public Expr(int code, String i, Args a)
    {
        statuscode = code;
        id = i;
        args = a;
    }

    public Expr(int code, int i)
    {
        statuscode = code;
        intlit = i;
    }

    public Expr(int code, double fl)
    {
        statuscode = code;
        floatlit = fl;
    }

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
                ret = name.toString(t);
                break;
            case 2:
                ret = id + " ()";
                break;
            case 3:
                ret = id + "  (" + args.toString(t) + ") ";
                break;
            case 4:
                ret = String.valueOf(intlit);
                break;
            case 5:
                ret = charlit;
                break;
            case 6:
                ret = strlit;
                break;
            case 7:
                ret = String.valueOf(floatlit);
                break;
            case 8:
                if(trueorfalse == true) {
                    ret = "true";
                }
                else if(trueorfalse == false) {
                    ret = "false";
                }
                break;
            case 9:
                ret = "(" + expr.toString(t) + ")";
                break;
            case 10:
                ret = "~" + expr.toString(t);
                break;
            case 11:
                ret = "-" + expr.toString(t);
                break;
            case 12:
                ret = "+" + expr.toString(t);
                break;
            case 13:
                ret = "(" + type.toString(t) + ") " + expr.toString(t);
                break;
            case 14:
                ret = binaryop.toString(t);
                break;
            case 15:
                ret = "( " + expr.toString(t) + " ? " + expr2.toString(t) + " : " + expr3.toString(t) + " )\n";
                break;
            default:
                ret = "ERROR in Expr.java";
        }
        return ret;
    }
}