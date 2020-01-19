import java.io.*;
import java.util.*;

public class Bond {
    public static double [] dp;
    public static double [][] prob;
    public static int num;
    public static double function (int agent, int mask)
    {
        if (dp[mask] >= 0)
        {
            return mask;
        }
        if (agent >= num)
        {
            return 1;
        }
        for (int j = 0; j < num; j++)
        {
            if ((mask&(1<<j))==0)
            {
                dp[mask]=Math.max(dp[mask], function(agent+1, mask|(1<<j))*prob[agent][j]);
            }
        }
        return dp[mask];
    }
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        num = Integer.parseInt(in.readLine());
        dp = new double[1<<num];
        prob = new double [num+1][num];
        for (int x =0; x< num; x++)
        {
            String [] temp = in.readLine().split(" ");
            for (int y =0; y < num; y++)
            {
                prob[x][y] = Integer.parseInt(temp[y])/100.0;
            }
        }
       
        Arrays.fill(dp, -1);
      
        function(0, 0);
        String hold = "";
        for (int x =0; x < num; x++)
        {
            hold +="1";
        }
        //System.out.print(dp[0]);
        System.out.print(dp[Integer.parseInt(hold, 2)]*100);
    }
}