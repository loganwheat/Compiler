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
        s.addArg(s); // keep track of total number of args
        FullType ft = null;
        if(containsBrackets && type != null && id != null) {
            ft = new FullType(type.toString(0), false, true, false);
        }
        else if (type != null && id != null) {
            ft = new FullType(type.toString(0), false, false, false);
        }

        if(s.validKeyInScope(id, s)) {
            s.addToHash(id, ft);
        } else {
            throw new TypeCheckException("Error: " + id + " can't be redeclared");
        }
    }
}