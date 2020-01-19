import java.io.*;
import java.util.*;

public class NotEnoughTime {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        int num = Integer.parseInt(temp[0]);
        int time = Integer.parseInt(temp[1]);
        int [][] dp = new int [2][time+1];
        int [][] cost = new int [3][2]; 
        for (int x = 1; x <= num; x++)
        {
            String [] temp1 = in.readLine().split(" ");
            cost[0][0] = Integer.parseInt(temp1[0]);
            cost[0][1] = Integer.parseInt(temp1[1]);
            cost[1][0] = Integer.parseInt(temp1[2]);
            cost[1][1] = Integer.parseInt(temp1[3]);
            cost[2][0] = Integer.parseInt(temp1[4]);
            cost[2][1] = Integer.parseInt(temp1[5]);
            for (int c = 1; c<=time; c++)
            {
                dp[x % 2][c] = dp[(x+1) % 2][c];
                for (int r =0; r < 3; r++)
                {
                    if (cost[r][0]<= c)
                    {
                        dp[x % 2][c] = Math.max(dp[x % 2][c], cost[r][1] + dp[(x+1) % 2][c-cost[r][0]] );
                        //System.out.println (dp[x%2][c]);
                    }
                }
            }
            System.out.print (dp[(num) % 2][time]);
        }
    }
}