import java.util.*;
import java.io.*;

public class OrDeal 
{
  public static void main (String [] args) throws IOException
  {
    BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
    
    long num = Long.parseLong(in.readLine());
    String temp = Long.toBinaryString(num);
    //System.out.print(temp);
    for (long x =0; x < temp.length(); x++)
    {
      System.out.print("1");
    }
  }}
