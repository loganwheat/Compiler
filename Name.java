class Name implements Token
{
    String id;
    Expr expr;

    public Name(String i, Expr e)
    {
        id = i;
        expr = e;
    }
    public Name(String i)
    {
        id = i;
        expr = null;
    }

    public String toString(int t)
    {
        if(expr != null){
            return id + "[" + expr.toString(t) + "]";
        }
        else {
            return id;
        }
    }
}