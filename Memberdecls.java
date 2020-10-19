class Memberdecls implements Token
{
    Fielddecls fielddecls;
    Methoddecls methoddecls;

    public Memberdecls(Fielddecls fd, Methoddecls md)
    {
        fielddecls = fd;
        methoddecls = md;
    }

    public String toString(int t)
    {
        return fielddecls.toString(t) + " " + methoddecls.toString(t);
    }
}