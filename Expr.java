class Expr extends Token
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

    public String getType(Scope s) throws TypeCheckException
    {
        String eType = "";

        if(statuscode == 1 && name != null) {
            eType += name.nameType(s);
        } if(statuscode == 4) {
            eType += "int";
        } else if(statuscode == 5) {
            eType += "char";
        } else if(statuscode == 6) {
            eType += "string";
        } else if(statuscode == 7) {
            eType += "float";
        } else if(statuscode == 8) {
            eType += "bool";
        } else if(statuscode == 9 || statuscode == 10 || statuscode == 11 || statuscode == 12) {
            return expr.getType(s);
        } else if(statuscode == 13) {
            // confusion
        } else if(statuscode == 14) {
            eType += "bool";
        } else if(statuscode == 15) {
            if(!(expr.getType(s).equals("bool"))) {
                throw new TypeCheckException("Error: " + expr.toString(0) + " must be of type bool");
            } else if (!(expr2.getType(s).equals(expr3.getType(s)))) {
                throw new TypeCheckException("Error: " + expr2.toString(0) + " must have equal type to " + expr3.toString(0));
            } else {
                return expr2.getType(s);
            }
        }

        return eType;
    }


    public String getId() {
        if(id != null) {
            return id;
        }
        else if(name != null) {
            return name.nameId();
        }
        else if(expr != null) {
            return expr.getId();
        }
        else {
            return "";
        }
    }

    public boolean isFunction()
    {
        boolean isFunc = false;
        if(statuscode == 2 || statuscode == 3) {
            isFunc = true;
        }
        return isFunc;
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
                    ret += "(~" + expr.toString(t) + ")";   
                }
                break;
            case 11:
                if (expr != null) {
                    ret += "(-" + expr.toString(t) + ")";   
                }
                break;
            case 12:
                if (expr != null) {
                    ret += "(+" + expr.toString(t) + ")";   
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
                    ret += "( " + expr.toString(t) + " ? " + expr2.toString(t) + " : " + expr3.toString(t) + " )";
                }
                break;
            default:
                ret += "ERROR in Expr.java";
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        switch(statuscode) {
            case 1:
                if(name != null) {
                    name.typeCheck(s);
                }
                break;
            case 2:
                if(!(s.keyIsFunction(id, s))) {
                    throw new TypeCheckException("Error: Invalid call to function " + id);
                }
                break;
            case 3:
                if(!(s.keyIsFunction(id, s))) {
                    throw new TypeCheckException("Error: Invalid call to function " + id);
                }
                args.typeCheck(s);
                break;
            case 4:
                // handled in getType
                break;
            case 5:
                // handled in getType
                break;
            case 6:
                // handled in getType
                break;
            case 7:
                // handled in getType
                break;
            case 8:
                // handled in getType
                break;
            case 9:
                expr.typeCheck(s);
                break;
            case 10:
                if(!(expr.getType(s).equals("bool"))) {
                    throw new TypeCheckException("Error: " + expr.getId() + " not a valid type (bool) to use ~");
                }
                expr.typeCheck(s);
                break;
            case 11:
                if(!(expr.getType(s).equals("int") || expr.getType(s).equals("float"))) {
                    throw new TypeCheckException("Error: " + expr.getId() + " not a valid type (int or float) to use -");
                }
                expr.typeCheck(s);
                break;
            case 12:
                if(!(expr.getType(s).equals("int") || expr.getType(s).equals("float"))) {
                    throw new TypeCheckException("Error: " + expr.getId() + " not a valid type (int or float) to use +");
                }
                expr.typeCheck(s);
                break;
            case 13:
                // will come back to it
                break;
            case 14:
                binaryop.typeCheck(s);
                break;
            case 15:
                if(!(expr.getType(s).equals("bool"))) {
                    throw new TypeCheckException("Error: " + expr.toString(0) + " must be of type bool");
                } else if (!(expr2.getType(s).equals(expr3.getType(s)))) {
                    throw new TypeCheckException("Error: " + expr2.toString(0) + " must have equal type to " + expr3.toString(0));
                }
                expr.typeCheck(s);
                expr2.typeCheck(s);
                expr3.typeCheck(s);
                break;
            default:
                throw new TypeCheckException("ERROR in Expr.java");
        }
    }
}