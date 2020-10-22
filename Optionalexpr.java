class Optionalexpr extends Token
{
    Expr expr;
    boolean exists;

    public Optionalexpr(Expr e)
    {
        expr = e;
        exists = true;
    }
    public Optionalexpr()
    {
        exists = false;
    }

    public String toString(int t)
    {
        String ret = "";
        if(!exists) {
            ret = "";
        }
        else if (expr != null) {
            ret = " = " + expr.toString(t);
        }
        return ret;
    }
}