class Printlist extends Token
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
        String ret = "";
        if (expr != null && readlist != null) {
            ret = expr.toString(t) + " , " + readlist.toString(t);
        }
        else if (expr != null) {
            ret = expr.toString(t);
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if (expr != null && readlist != null) {
            expr.typeCheck(s);
            readlist.typeCheck(s);
        }
        else if (expr != null) {
            expr.typeCheck(s);
        }
        
    }
}