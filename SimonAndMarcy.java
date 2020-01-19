import java.io.*;
import java.util.*;

public class SimonAndMarcy {
    public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String[] tokens = in.readLine().split(" ");
        int cages = Integer.parseInt(tokens[0]);
        int time = Integer.parseInt(tokens[1]);
        int [][] dp = new int [cages+1][time+1];
        for (int x =1; x <= cages; x++)
        {
            tokens = in.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
            for (int y = 1; y <= time; y++)
            {
                if (y< k)
                {
                    dp [x][y] = dp[x-1][y];
                }
                else
                {
                    dp [x][y] = Math.max(dp[x-1][y], dp[x-1][y-k] + n);
                }
            }
        }
        System.out.print (dp[cages][time]);
    }
}