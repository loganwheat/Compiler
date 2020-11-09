class FullType {
    String type;
    boolean fin; //final
    boolean arr; //array
    boolean func; //function

    FullType(String t, boolean f, boolean a, boolean fu) 
    {
        type = t;
        fin = f;
        arr = a;
        func = fu;
    }

    boolean getType()
    {
        return type;
    }

    boolean isFinal()
    {
        return fin;
    }

    boolean isArray()
    {
        return arr;
    }

    boolean isFunction()
    {
        return func;
    }
}