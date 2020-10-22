class Memberdecls implements Token
{
    Fieldsmethods fieldsmethods;

    public Memberdecls(Fieldsmethods fm)
    {
        fieldsmethods = fm;
    }

    public String toString(int t)
    {
        String ret = "";

        if(fieldsmethods != null) {
            ret += fieldsmethods.toString(t);
        }
        return ret;
    }
    /*
    Fielddecls fielddecls;
    Methoddecls methoddecls;
    Fielddecl fielddecl;

    public Memberdecls(Fielddecls fds, Methoddecls md)
    {
        fielddecls = fds;
        fielddecl = null;
        methoddecls = md;
    }
    public Memberdecls(Fielddecl fd, Methoddecls md)
    {
        fielddecls = null;
        fielddecl = fd;
        methoddecls = md;
    }
    public Memberdecls(Methoddecls md)
    {
        fielddecls = null;
        fielddecl = null;
        methoddecls = md;
    }

    public String toString(int t)
    {
        String ret = "";
        if (fielddecls == null && fielddecl == null && methoddecls != null){
            ret = methoddecls.toString(t);
        }
        else if (fielddecl == null && fielddecls != null){
            ret = fielddecls.toString(t);
        }
        else if (fielddecl != null && methoddecls != null){
            ret = fielddecl.toString(t) + " " + methoddecls.toString(t);
        }
        return ret;
    }
    */
}