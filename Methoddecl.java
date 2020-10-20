class Methoddecl implements Token
{
    Type type;
    String id;
    Argdecls argdecls;
    Fielddecls fielddecls;
    Stmts stmts;
    Optionalsemi optionalsemi;
    boolean isVoid = false;

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
        String ret = "";
        if (isVoid) {
            ret = "void " + id + " (" + argdecls.toString(t) + ") {" + fielddecls.toString(t) + stmts.toString(t) + "}" + optionalsemi.toString(t) + "\n";
        }
        else {
            ret = type.toString(t) + id + " (" + argdecls.toString(t) + ") {" + fielddecls.toString(t) + stmts.toString(t) + "}" + optionalsemi.toString(t) + "\n";
        }

        return ret;
    }
}