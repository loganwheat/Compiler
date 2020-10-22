class Argdecls extends Token
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
        String ret = "";
        if (!exists) {
            ret = "";
        }
        else if (aList != null) {
            ret = aList.toString(t);
        }
        return ret;
    }
}