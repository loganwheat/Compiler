class Readlist extends Token
{
    Name name;
    Args args;

    public Readlist(Name n, Args a)
    {
        name = n;
        args = a;
    }
    public Readlist(Name n)
    {
        name = n;
        args = null;
    }

    public String toString(int t)
    {
        String ret = "";
        if(name != null && args != null) {
            ret = name.toString(t) + " , " + args.toString(t);
        }
        else if (name != null){
            ret = name.toString(t);
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if(name != null && args != null) {
            if(s.keyIsFinal(name.nameId(), s) || s.keyIsFinal(args.exprId(), s)) {
                throw new TypeCheckException("Error: Read does not work on final");
            }
            if(s.keyIsArray(name.nameId(), s) || s.keyIsArray(args.exprId(), s)) {
                throw new TypeCheckException("Error: Read does not work on an array");
            }
            if(s.keyIsFunction(name.nameId(), s) || s.keyIsFunction(args.exprId(), s)) {
                throw new TypeCheckException("Error: Read does not work on a function");
            }
            name.typeCheck(s);
            args.typeCheck(s);
        }
        else if (name != null){
            if(s.keyIsFinal(name.nameId(), s)) {
                throw new TypeCheckException("Error: Read does not work on final");
            }
            if(s.keyIsArray(name.nameId(), s)) {
                throw new TypeCheckException("Error: Read does not work on an array");
            }
            if(s.keyIsFunction(name.nameId(), s)) {
                throw new TypeCheckException("Error: Read does not work on a function");
            }
            name.typeCheck(s);
        }
    }
}