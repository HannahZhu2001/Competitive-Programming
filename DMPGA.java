import java.io.*;
import java.util.*;

public class DMPGA
{
  public static void main(String [] args) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String word = in.readLine();
    int zeros=0;
    int valid= 0;
    boolean pass = true;
    word += " ";
    for (int x =word.length()-2; x >=0; x--)
    {
      //System.out.println(x);
      if (word.charAt(x)=='0')
      {
        zeros++;
      }
      else
      {
        String temp =  word.substring(x, x+1);
        int hold = Integer.parseInt(temp);
        //System.out.println(hold+ " "+ zeros + " " + valid);
        if (hold <= (zeros+valid))
        {
          int total = hold;
          if (total <= zeros)
          {
            zeros -= total;
            valid++;
          }
          else if (total <= valid)
          {
            valid -= total;
            valid++;
          }
          else
          {
            total -= zeros;
            zeros = 0;
            valid -= total;
            valid++;
          }
        }
        else
        {
          pass = false;
          break;
        }
      }
    }
    if ((zeros + valid) != 1)
    {
      pass = false;
    }
    if (pass)
    {
      System.out.print("Valid");
    }
    else
    {
      System.out.print("Invalid");
    }
        
    //System.out.print("Test");
  }
}

