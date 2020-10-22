class Token
{
    public String toString(int t){return "";};

    public String getTabs(int tabs)
    {
        String t = "\n";
        for (int i = 0; i < tabs ; i++)
        {
            t += "\t";
        }
        return t;
    }
}