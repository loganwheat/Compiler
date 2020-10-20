class Type implements Token
{
    int statuscode;

    public Type(int code)
    {
        statuscode = code;
    }

    public String toString(int t)
    {
        String ret = "";

        switch(statuscode) {
            case 1:
                ret = "int ";
                break;
            case 2:
                ret = "char ";
                break;
            case 3:
                ret = "bool ";
                break;
            case 4:
                ret = "float ";
                break;
            default:
                ret = "ERROR in Type.java";
        }

        return ret;
    }
}