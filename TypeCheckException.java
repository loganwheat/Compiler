import java.util.*;

class TypeCheckException extends Exception
{
  String fault;
  public TypeCheckException(String s)
  {
    fault = s;
  }
  
  public String toString()
  {
    return fault;
  }
}