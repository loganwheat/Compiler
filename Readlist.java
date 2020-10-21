class Readlist implements Token
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
        if(args != null) {
            return name.toString(t) + " , " + args.toString(t);
        }
        else {
            return name.toString(t);
        }
    }
}