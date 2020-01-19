import java.io.*;
import java.util.*;

public class RiceBall {
  static int [][] dp;
  static int [] rice;
  static int [] psa;
  
  public static int recursion (int left, int right)
  {
    if (dp[left][right] != 0)
    {
      return dp[left][right];
    }
    for (int i= left, j = right; i < j;)
    {
      if (recursion(j, right) == recursion(left, i) && dp[j][right] != -1 && recursion(i, j) != -1)
      {
        dp[left][right] = psa[right] - psa[left-1];
        return dp[left][right];
      }
      else 
      {
        if (psa[i] - psa[left-1] > psa[right]-psa[j-1])
        {
          j--;
        }
        else
          i++;
      }
    }
    dp[left][right] = -1;
    return -1;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int size = 0;
    int length = Integer.parseInt(in.readLine());
    dp = new int [length+1][length+1];
    psa = new int [length+1];
    rice = new int [length+1];
    String [] temp = in.readLine().split(" ");
    for (int x =0; x< length; x++)
    {
      rice[x+1]= Integer.parseInt(temp[x]);
      dp[x+1][x+1] = rice[x+1];
      psa[x+1] = psa[x] + rice[x+1];
    }
   // recursion(1, length);
    int answer = 0;
    for (int x = 1; x <= length; x++)
    {
      for (int c =1; c+x <= length; c++)
      {
        dp[c][x+c] = -1;
        for (int i= c, j = x+c; i < j;)
        {
          if (dp[j][x] == dp[length-x][i] && dp[j][length-x] != -1 && dp[i][j] != -1)
          {
            dp[left][right] = psa[right] - psa[left-1];
            return dp[left][right];
          }
          else 
          {
            if (psa[i] - psa[x-1] > psa[length-x    ]-psa[j-1])
            {
              j--;
            }
            else
              i++;
          }
        }
      }
    }
    System.out.print(answer);
  }
}