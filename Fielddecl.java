class Fielddecl extends Token
{
    boolean isFinal = false;
    boolean isIntLit = false;
    Type type;
    String id;
    Optionalexpr optionalexpr;
    String intlit;
    
    public Fielddecl(boolean isF, Type t, String i, Optionalexpr oe)
    {
        if (isF == true){
            isFinal = true;
        }
        type = t;
        id = i;
        optionalexpr = oe;
    }
    public Fielddecl(Type t, String i, String il)
    {
        isIntLit = true;
        type = t;
        id = i;
        intlit = il;
    }

    public String toString(int t)
    {
        String ret = getTabs(t);
        if (isIntLit == true && type != null && id != null)
        {
            ret += type.toString(t) + " " + id + " [" + intlit + "] ;";
        }
        else
        {
            if (isFinal == true && type != null && id != null)
            {
                ret += "final " + type.toString(t) + " " + id + optionalexpr.toString(t) + ";";
            }
            else if(type != null && id != null)
            {
                ret += type.toString(t) + " " + id + optionalexpr.toString(t) + ";";
            }
        }
        return ret;
    }
}