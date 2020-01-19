import java.io.*;
import java.util.*;

public class GoldenLily {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        int columns = Integer.parseInt(temp[0]);
        int rows = Integer.parseInt(temp[1]);
        int [][] density = new int [rows][columns];
        int [][] dp = new int [rows][columns];
        for (int x =0; x<rows; x++)
        {
            temp = in.readLine().split(" ");
            for (int y =0; y<columns; y++)
            {
                density[x][y] = Integer.parseInt(temp[y]);
                
            }
        }
        temp = in.readLine().split(" ");
        int finx = Integer.parseInt(temp[0]);
        int finy = Integer.parseInt(temp[1]);
        Queue<Integer> xValue = new LinkedList<Integer>();
        Queue<Integer> yValue = new LinkedList<Integer>();
        Queue<Integer> dig = new LinkedList<Integer>();
        xValue.add(0);
        yValue.add(0);
        dig.add(density[0][0]);
        for (int[] row: dp)
        {
        Arrays.fill(row, 1000000);
        //System.out.println('*');
        }
        
        //Arrays.fill(dp, 1000000);
        while (xValue.isEmpty()==false)
        {
            int x = xValue.poll();
            int y = yValue.poll();
            //System.out.println(x);
            //System.out.println(y);
            
            int d = dig.poll();
            //System.out.println(d);
            if (d <= dp[y][x])
            {
              //System.out.println("asdf "+d);
                if (y+1< rows)
                {
                  //System.out.println("10");
                    if (dp[y+1][x] > d + density[y+1][x])
                    {
                        dp[y+1][x] = d + density[y+1][x];
                        xValue.add(x);
                        yValue.add(y+1);
                        dig.add(dp[y+1][x]);
                        //System.out.println(dp[y+1][x]);
                    }
                }
                if (x-1 >= 0)
                {
                  //System.out.println("20");
                    if (dp[y][x-1] > d + density[y][x-1])
                    {
                        dp[y][x-1] = d + density[y][x-1];
                        xValue.add(x-1);
                        yValue.add(y);
                        dig.add(dp[y][x-1]);
                        //System.out.println(dp[y][x-1]);
                    }
                }
                if(x+1 < columns)
                {
                  //System.out.println("30");
                    if (dp[y][x+1] > d + density[y][x+1])
                    {
                        dp[y][x+1] = d + density[y][x+1];
                        xValue.add(x+1);
                        yValue.add(y);
                        dig.add(dp[y][x+1]);
                        //System.out.println(dp[y][x+1]);
                    }
                }
                
                
            }
        }
        System.out.print(dp[finx][finy]);
    }
}