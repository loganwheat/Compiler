class Memberdecls extends Token
{
    Fieldsmethods fieldsmethods;

    public Memberdecls(Fieldsmethods fm)
    {
        fieldsmethods = fm;
    }

    public String toString(int t)
    {
        String ret = "";

        if(fieldsmethods != null) {
            ret += fieldsmethods.toString(t);
        }
        return ret;
    }
}