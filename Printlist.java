class Printlist implements Token
{
    Expr expr;
    Readlist readlist;

    public Printlist(Expr e, Readlist rl)
    {
        expr = e;
        readlist = rl;
    }
    public Printlist(Expr e)
    {
        expr = e;
        readlist = null;
    }

    public String toString(int t)
    {
        if (readlist != null) {
            return expr.toString(t) + " , " + readlist.toString(t);
        }
        else {
            return expr.toString(t);
        }
    }
}