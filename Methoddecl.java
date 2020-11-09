class Methoddecl extends Token
{
    Type type;
    String id;
    Argdecls argdecls;
    Fielddecls fielddecls;
    Stmts stmts;
    Optionalsemi optionalsemi;
    boolean isVoid = false;
    Scope methodScope;

    public Methoddecl(Type t, String i, Argdecls a, Fielddecls fds, Stmts s, Optionalsemi os)
    {
        type = t;
        id = i;
        argdecls = a;
        fielddecls = fds;
        stmts = s;
        optionalsemi = os;
    }

    public Methoddecl(boolean isV, String i, Argdecls a, Fielddecls fds, Stmts s, Optionalsemi os)
    {
        isVoid = isV;
        id = i;
        argdecls = a;
        fielddecls = fds;
        stmts = s;
        optionalsemi = os;
    }

    public String toString(int t)
    {
        String ret = getTabs(t);
        if (isVoid && id != null && argdecls != null && fielddecls != null && stmts != null) {
            ret += "void " + id + " (" + argdecls.toString(t) + ") " + getTabs(t) + "{" + fielddecls.toString(t+1) + stmts.toString(t+1) + getTabs(t) + "}" + optionalsemi.toString(t);
        }
        else if (type != null && argdecls != null && fielddecls != null && stmts != null) {
            ret += type.toString(t) + id + " (" + argdecls.toString(t) + ") " + getTabs(t) + "{" + fielddecls.toString(t+1) + stmts.toString(t+1) + getTabs(t) + "}" + optionalsemi.toString(t);
        }

        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        FullType ft = null;
        methodScope = new Scope(s);

        if (isVoid && id != null && argdecls != null && fielddecls != null && stmts != null) {
            ft = new FullType("void", false, false, true);
        }
        else if (type != null && argdecls != null && fielddecls != null && stmts != null) {
            ft = new FullType(type.toString(0), false, false, true);
        }
        if(methodScope.validKeyInScope(id, methodScope)) {
            methodScope.addToHash(id, ft);
        } else {
            throw new TypeCheckException("Error: " + id + " can't be redeclared");
        }
    }
}