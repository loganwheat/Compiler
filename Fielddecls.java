class Fielddecls implements Token
{
    Fielddecl fielddecl;
    Fielddecls fielddecls;
    
    public Fielddecls(Fielddecl fd, Fielddecls fds)
    {
        fielddecl = fd;
        fielddecls = fds;
    }

    public String toString(int t)
    {
        String ret ="";
        if (fielddecls == null)
            ret = fielddecl.toString(t);
        else
            ret = fielddecl.toString(t) + " " + fielddecls.toString(t);
        
        return ret;
    }
}