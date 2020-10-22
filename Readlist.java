class Readlist extends Token
{
    Name name;
    Args args;

    public Readlist(Name n, Args a)
    {
        name = n;
        args = a;
    }
    public Readlist(Name n)
    {
        name = n;
        args = null;
    }

    public String toString(int t)
    {
        String ret = "";
        if(name != null && args != null) {
            ret = name.toString(t) + " , " + args.toString(t);
        }
        else if (name != null){
            ret = name.toString(t);
        }
        return ret;
    }
}