class IfEnd implements Token
{
    Stmt stmt;
    boolean hasStmt;

    public IfEnd(Stmt s)
    {
        hasStmt = true;
        stmt = s;
    }
    public IfEnd()
    {
        hasStmt = false;
    }

    public String toString(int t)
    {
        if(!hasStmt) {
            return "fi";
        }
        else {
            return "else " + stmt.toString(t) + " fi";
        }
    }
}