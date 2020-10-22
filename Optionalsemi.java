class Optionalsemi extends Token
{
    boolean exists;
    String semicolon;

    public Optionalsemi(String semi)
    {
        semicolon = semi;
        exists = true;
    }
    public Optionalsemi()
    {
        exists = false;
    }

    public String toString(int t)
    {
        if(!exists) {
            return "";
        }
        else {
            return ";\n";
        }
    }
}