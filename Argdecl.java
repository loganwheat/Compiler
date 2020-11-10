class Argdecl extends Token
{
    boolean containsBrackets;
    Type type;
    String id;

    public Argdecl(boolean bracket, Type t, String i)
    {
        containsBrackets = bracket;
        type = t;
        id = i;
    }

    public String toString(int t)
    {
        String ret = "";
        if(containsBrackets && type != null && id != null) {
            ret = type.toString(t) + id + " []";
        }
        else if (type != null && id != null) {
            ret = type.toString(t) + id;
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        FullType ft = null;
    }
}