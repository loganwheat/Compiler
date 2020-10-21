class Binaryop implements Token
{
    Expr l, r;
    String bo;

    public Binaryop(Expr lhs, String o, Expr rhs)
    {
        l = lhs;
        bo = o;
        r = rhs;
    }

    public String toString(int t)
    {
        return l.toString(t) + " " + bo + " " + r.toString(t);
    }
}