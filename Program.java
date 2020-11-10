class Program extends Token
{
    String id;
    Memberdecls memberdecls;
    Scope scope;

    public Program(String i, Memberdecls md)
    {
        id = i;
        memberdecls = md;
        scope = new Scope();
    }

    public Scope getScope()
    {
        return this.scope;
    }

    public String toString(int t)
    {
        return "Program:" + getTabs(t) + "class " + id + getTabs(t) + "{" + memberdecls.toString(t+1) + getTabs(t) + "}\n";
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        Scope memberdeclsScope = new Scope(s);
        memberdecls.typeCheck(memberdeclsScope);
    }
}