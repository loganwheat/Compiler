class Program implements Token
{
    String id;
    Memberdecls memberdecls;

    public Program(String i, Memberdecls md)
    {
        id = i;
        memberdecls = md;
    }

    public String toString(int t)
    {
        return ("Program:\n" + "class " + id + " {" + memberdecls.toString(t+1) + "}");
    }
}