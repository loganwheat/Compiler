class ArgdeclList implements Token
{
    Argdecl argdecl;
    ArgdeclList aList;

    public ArgdeclList(Argdecl a, ArgdeclList al)
    {
        argdecl = a;
        aList = al;
    }
    public ArgdeclList(Argdecl a)
    {
        argdecl = a;
        aList = null;
    }

    public String toString(int t)
    {
        if (aList != null) {
            return argdecl.toString(t) + " , " + aList.toString(t);
        }
        else {
            return argdecl.toString(t);
        }
    }
}