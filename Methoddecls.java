class Methoddecls implements Token
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
            return methoddecl.toString(t) + " " + methoddecls.toString(t);
        }
        else {
            return "";
        }
    }
}