class Fieldsmethods extends Token
{
    Fielddecl fielddecl;
    Fieldsmethods fieldsmethods;
    Methoddecl methoddecl;
    Methoddecls methoddecls;

    public Fieldsmethods(Fielddecl f, Fieldsmethods fm)
    {
        fielddecl = f;
        fieldsmethods = fm;
        methoddecl = null;
        methoddecls = null;
    }
    public Fieldsmethods(Methoddecl md, Methoddecls mds)
    {
        methoddecl = md;
        methoddecls = mds;
        fielddecl = null;
        fieldsmethods = null;
    }
    public Fieldsmethods()
    {
        fielddecl = null;
        fieldsmethods = null;
        methoddecl = null;
        methoddecls = null;
    }

    public String toString(int t)
    {
        String ret = "";

        if (methoddecl != null) {
            ret += methoddecl.toString(t);
            if (methoddecls != null) {
                ret += methoddecls.toString(t);
            }
        }
        else if (fielddecl != null) {
            ret += fielddecl.toString(t);
            if (fieldsmethods != null) {
                ret += fieldsmethods.toString(t);
            }
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if (methoddecl != null) {
            methoddecl.typeCheck(s);
            if (methoddecls != null) {
                methoddecls.typeCheck(s);
            }
        }
        else if (fielddecl != null) {
            fielddecl.typeCheck(s);
            if (fieldsmethods != null) {
                fieldsmethods.typeCheck(s);
            }
        }
    }
}