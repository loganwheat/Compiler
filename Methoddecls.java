class Methoddecls extends Token
{
    boolean exists = false;
    Methoddecl methoddecl;
    Methoddecls methoddecls;

    public Methoddecls(Methoddecl md, Methoddecls mds)
    {
        methoddecl = md;
        methoddecls = mds;
        exists = true;
    }
    public Methoddecls()
    {
        methoddecl = null;
        methoddecls = null;
    }

    public String toString(int t)
    {
        if(exists && methoddecl != null && methoddecls != null) {
            return "\n" + methoddecl.toString(t) + " " + methoddecls.toString(t);
        }
        else {
            return "";
        }
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if(exists && methoddecl != null && methoddecls != null) {
            methoddecls.typeCheck(s);
            methoddecl.typeCheck(s);
        }
    }
}