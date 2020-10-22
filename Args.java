class Args implements Token
{
    Expr expr;
    Args args;

    public Args(Expr e, Args a)
    {
        expr = e;
        args = a;
    }
    public Args(Expr e)
    {
        expr = e;
        args = null;
    }

    public String toString(int t)
    {
        String ret = "";
        if(expr != null && args != null) {
            ret = expr.toString(t) + " , " + args.toString(t); 
        }
        else if (expr != null){
            ret = expr.toString(t);
        }
        return ret;
    }
}