class Stmts extends Token
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
        String ret = "";
        if (!exists) {
            ret = "";
        }
        else if(stmt != null){
            ret = stmt.toString(t) + stmts.toString(t);
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if (exists) {
            stmt.typeCheck(s);
            stmts.typeCheck(s);
        }
    }
}