class Program extends Token
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
        return "Program:" + getTabs(t) + "class " + id + getTabs(t) + "{" + memberdecls.toString(t+1) + getTabs(t) + "}\n";
    }
}