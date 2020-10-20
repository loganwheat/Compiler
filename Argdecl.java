class Argdecl implements Token
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
        if(containsBrackets) {
            return type.toString(t) + id + " []";
        }
        else {
            return type.toString(t) + id;
        }
    }
}