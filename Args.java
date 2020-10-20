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
    }

    public String toString(int t)
    {
        
    }
}