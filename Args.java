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
        if(args != null) {
            return expr.toString(t) + " , " + args.toString(t); 
        }
        else {
            return expr.toString(t);
        }
    }
}