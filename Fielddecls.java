class Fielddecls extends Token
{
    Fielddecl fielddecl;
    Fielddecls fielddecls;
    
    public Fielddecls(Fielddecl fd, Fielddecls fds)
    {
        fielddecl = fd;
        fielddecls = fds;
    }

    public Fielddecls()
    {
        fielddecl = null;
        fielddecls = null;
    }

    public String toString(int t)
    {
        String ret ="";

        if (fielddecls == null && fielddecl != null)
            ret = fielddecl.toString(t);
        else if(fielddecl != null && fielddecls != null)
            ret = fielddecl.toString(t) + " " + fielddecls.toString(t);

        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if (fielddecls == null && fielddecl != null) {
            fielddecl.typeCheck(s);
        } else if(fielddecl != null && fielddecls != null) {
            fielddecl.typeCheck(s);
            fielddecls.typeCheck(s);
        }
    }
}