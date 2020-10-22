class IfEnd extends Token
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
        String ret = getTabs(t);

        if(!hasStmt) {
            ret += "fi";
        }
        else if (stmt != null){
            ret += "else" + stmt.toString(t+1) + getTabs(t) + "fi";
        }

        return ret;
    }
}