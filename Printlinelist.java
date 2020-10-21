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
        if(!exists) {
            return "";
        }
        else {
            return printlist.toString(t);
        }
    }
}