class ArgdeclList extends Token
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
        String ret = "";

        if (aList != null && argdecl != null) {
            ret = argdecl.toString(t) + " , " + aList.toString(t);
        }
        else if (argdecl != null){
            ret = argdecl.toString(t);
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if (aList != null && argdecl != null) {
            argdecl.typeCheck(s);
            aList.typeCheck(s);
        }
        else if (argdecl != null){
            argdecl.typeCheck(s);
        }
    }
}