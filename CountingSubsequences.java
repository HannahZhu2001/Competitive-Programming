import java.util.*;
import java.io.*;
public class CountingSubsequences
{
  public static void main (String [] args) throws IOException
  {
    BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
    String temp = in.readLine();
    int [] dp = new int[temp.length()+1];
    int [] letters = new int [26];
    for (int x =1; x<= temp.length(); x++)
    {
        dp[x] = dp[x-1] *2;
        if (letters[temp.charAt(x-1)- 97] == 0)
        {
            dp[x]++;
            letters[temp.charAt(x-1)- 97] = x;
        }
        else 
        {
            dp[x] -= dp[letters[temp.charAt(x-1)- 97]-1];
            letters[temp.charAt(x-1)- 97] = x;
        }
    }
    System.out.print(dp[temp.length()]);
    }
    } 
             
    
