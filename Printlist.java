class Printlist extends Token
{
    Expr expr;
    Printlist printlist;

    public Printlist(Expr e, Printlist pl)
    {
        expr = e;
        printlist = pl;
    }
    public Printlist(Expr e)
    {
        expr = e;
        printlist = null;
    }

    public String toString(int t)
    {
        String ret = "";
        if (expr != null && printlist != null) {
            ret = expr.toString(t) + " , " + printlist.toString(t);
        }
        else if (expr != null) {
            ret = expr.toString(t);
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if (expr != null && printlist != null) {
            expr.typeCheck(s);
            printlist.typeCheck(s);
        }
        else if (expr != null) {
            expr.typeCheck(s);
        }
        if(s.keyIsArray(expr.getId(), s)) {
            throw new TypeCheckException("Error: Print does not work on an array");
        }
        if(s.getTypeFromKey(expr.getId(), s).equals("void")) {
            throw new TypeCheckException("Error: Print does not work on void type");
        }
    }
}