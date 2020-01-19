import java.util.*;
import java.io.*;
public class AGame
{

    static int [] coins;
    static int [] psa; 
    static int [][] dp;
    
    public static int recursion(int left, int right)
    {
        if (dp[left][right] > 0)
        {
            return dp[left][right];
        }
        else if (left == right)
        {
            dp[left][right] = coins[left];
            return dp[left][right];
        }
        else
        {
            dp[left][right] = Math.max(psa[right] - psa[left-1]-recursion(left, right-1),psa[right] - psa[left-1]-recursion(left+1, right));
            return dp[left][right];
        }
    }
     
  public static void main (String [] args) throws IOException
  {
    BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
    int num = Integer.parseInt(in.readLine());
    dp = new int [num+1][num+1];
    coins= new int [num+1];
    psa= new int [num+1];
    for (int x =1; x<= num; x++)
    {
        coins[x] = Integer.parseInt(in.readLine());
        psa[x] = psa[x-1] + coins[x];
    }
    System.out.print(AGame.recursion(1, num));
    
}
}
    
