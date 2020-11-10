class Args extends Token
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
    public String exprId()
    {
        if(expr != null) {
            return expr.getId();
        } else {
            return "";
        }
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

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if(expr != null && args != null) {
            expr.typeCheck(s);
            args.typeCheck(s); 
        }
        else if (expr != null){
            expr.typeCheck(s);
        }
    }
}