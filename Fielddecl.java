class Fielddecl implements Token
{
    boolean isFinal = false;
    boolean isIntLit = false;
    Type type;
    String id;
    Optionalexpr optionalexpr;
    int intlit;
    
    public Fielddecl(boolean isF, Type t, String i, Optionalexpr oe)
    {
        if (isF == true){
            isFinal = true;
        }
        type = t;
        id = i;
        optionalexpr = oe;
    }
    public Fielddecl(Type t, String i, int il)
    {
        isIntLit = true;
        type = t;
        id = i;
        intlit = il;
    }

    public String toString(int t)
    {
        String ret = "";
        if (isIntLit == true)
        {
            ret = type.toString(t) + " " + id + " [" + intlit.toString(t) + "] ;\n";
        }
        else
        {
            if (isFinal == true)
            {
                ret = "final " + type.toString(t) + " " + id + " " + optionalexpr.toString(t) + ";\n";
            }
            else
            {
                ret = type.toString(t) + " " + id + " " + optionalexpr.toString(t) + ";\n";
            }
        }
        return ret;
    }
}