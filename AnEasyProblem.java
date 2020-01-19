import java.io.*;
import java.util.*;

public class AnEasyProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(in.readLine());
        int [] dp = new int [32];
        int max =0;
        String [] temp = in.readLine().split(" ");
        for (int x =0; x < temp.length; x++)
        {
            String hold = Integer.toBinaryString(Integer.parseInt(temp[x]));
            //System.out.println (hold);
            max = 0;
            for (int y = 0; y < hold.length() ;y++)
            {
                if(hold.charAt(hold.length()-1-y) == '1')
                {
                    dp[y]++;
                    max = Math.max(max, dp[y]);
                    //System.out.println("v "+y); 
                }
            }
            for (int y = 0; y < hold.length() ;y++)
            {
                if(hold.charAt(hold.length()-1-y) == '1')
                {
                    dp[y]= max;
                    //max = Math.max(max, dp[y]);
                }
            }
        }
        max =0;
        for(int x =0; x< 32; x++)
        {
          max=Math.max(max, dp[x]);
        }
        System.out.print(max);
        
    }
}