class Printlinelist implements Token
{
    Printlist printlist;
    boolean exists;

    public Printlinelist(Printlist pl)
    {
        exists = true;
        printlist = pl;
    }
    public Printlinelist()
    {
        exists = false;
    }

    public String toString(int t)
    {
        String ret = "";
        if(!exists) {
            ret = "";
        }
        else if (printlist != null) {
            ret = printlist.toString(t);
        }
        return ret;
    }
}