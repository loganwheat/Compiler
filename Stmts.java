class Stmts implements Token
{
    Stmt stmt;
    Stmts stmts;
    boolean exists;

    public Stmts(Stmt s, Stmts ss)
    {
        exists = true;
        stmt = s;
        stmts = ss;
    }
    public Stmts()
    {
        exists = false;
    }

    public String toString(int t)
    {
        if (!exists) {
            return "";
        }
        else {
            return stmt.toString(t) + stmts.toString(t);
        }
    }
}