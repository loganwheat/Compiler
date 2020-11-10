class Binaryop extends Token
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
        return "(" + l.toString(t) + " " + bo + " " + r.toString(t) + ")";
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if(bo.equals("<>") || bo.equals("<=") || bo.equals(">=") || bo.equals("==") || bo.equals("<>")) {
            if(!(l.getType(s).equals("int") || l.getType(s).equals("float"))) {
                throw new TypeCheckException("Error: " + l.toString(0) + " is incompatible type for " + bo);
            } else if(!(r.getType(s).equals("int") || r.getType(s).equals("float"))) {
                throw new TypeCheckException("Error: " + r.toString(0) + " is incompatible type for " + bo);
            }
        } else if (bo.equals("||") || bo.equals("&&")) {
            if(!(l.getType(s).equals("bool"))) {
                throw new TypeCheckException("Error: " + l.toString(0) + " is incompatible type for " + bo);
            } else if(!(r.getType(s).equals("bool"))) {
                throw new TypeCheckException("Error: " + r.toString(0) + " is incompatible type for " + bo);
            }
        }
    }
}