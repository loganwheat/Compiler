class Fielddecls implements Token
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
}