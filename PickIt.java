import java.io.*;
import java.util.*;

public class PickIt {
    public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String [] temp = in.readLine().split(" ");
      while (temp.length != 1 && temp[0].equals("0") == false)
      {
        int [] values = new int [temp.length+1];
        for (int x =1; x<=temp.length; x++)
        {
          values[x] = Integer.parseInt(temp[x-1]);
        }
        int [][] dp = new int [temp.length+1][temp.length+1];
        for (int x = 3; x <=temp.length; x++)
        {
          dp[x-2][x] = values[x-2] + values[x-1]+values[x];
        }
        for (int x=4; x<=temp.length; x++)
        {
          for (int y=1; y <= temp.length+1-x; y++)
          {
            for (int c = y+1; x < y+x-2; c++)
            {
              dp[y][y+x-2] = Math.max(dp[y][y+x-2], dp[y][c] + dp[c][y+x-2] + values[y] + values[y+x-2] + values[c]);
            }
          }
        }
        System.out.println(dp[1][temp.length]);
        temp = in.readLine().split(" ");
        
        
      }
    }
}