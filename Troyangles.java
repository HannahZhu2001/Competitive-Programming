import java.io.*;
import java.util.*;

public class Troyangles {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num =0;
        int length = Integer.parseInt(in.readLine());
        int [][] grid = new int [length+2][length+2];
        for (int x =0; x<length; x++)
        {
            String temp = in.readLine();
            for (int r =0; r < length; r++)
            {
                if (temp.charAt(r)=='#')
                {
                    grid[x+1][r+1] = 1;
                    //num++;
                }
            }
        }
        for (int r = length; r>0; r--)
        {
            for (int c = 1; c<=length; c++)
            {
                if (grid[r][c] == 1)
                {
                    grid[r][c] = Math.min(Math.min(grid[r+1][c-1], grid[r+1][c]), grid[r+1][c+1]) +1;
                    num += grid[r][c];
                    
                }
                //System.out.println(r+ " " + c + " " + grid[r][c]);
            }
        }
        System.out.print(num);
        }
}