class Fieldsmethods implements Token
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
}