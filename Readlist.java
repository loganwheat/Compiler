class Readlist extends Token
{
    Name name;
    Readlist readlist;

    public Readlist(Name n, Readlist rl)
    {
        name = n;
        readlist = rl;
    }
    public Readlist(Name n)
    {
        name = n;
        readlist = null;
    }

    public String toString(int t)
    {
        String ret = "";
        if(name != null && readlist != null) {
            ret = name.toString(t) + " , " + readlist.toString(t);
        }
        else if (name != null){
            ret = name.toString(t);
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if(name != null && readlist != null) {
            
            name.typeCheck(s);
        }
        else if (name != null){
            name.typeCheck(s);
        }
        if(s.keyIsFinal(name.nameId(), s)) {
            throw new TypeCheckException("Error: Read does not work on final");
        }
        if(s.keyIsArray(name.nameId(), s)) {
            throw new TypeCheckException("Error: Read does not work on an array");
        }
        if(s.keyIsFunction(name.nameId(), s)) {
            throw new TypeCheckException("Error: Read does not work on a function");
        }
    }
}