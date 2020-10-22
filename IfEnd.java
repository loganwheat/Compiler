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
        String ret = "";
        if(!hasStmt) {
            ret = "fi";
        }
        else if (stmt != null){
            ret = "else " + stmt.toString(t) + " fi";
        }

        return ret;
    }
}