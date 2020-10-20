class Argdecls implements Token
{
    ArgdeclList aList;
    boolean exists;

    public Argdecls(ArgdeclList al)
    {
        exists = true;
        aList = al;
    }
    public Argdecls()
    {
        exists = false;
    }

    public String toString(int t)
    {
        if (!exists) {
            return "";
        }
        else {
            return aList.toString(t);
        }
    }
}