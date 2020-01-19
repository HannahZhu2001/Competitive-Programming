import java.io.*;
import java.util.*;

public class Peg {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int [][] map = new int [7][7];
        Queue<Integer> xcoord = new LinkedList<Integer>();
        Queue<Integer> ycoord = new LinkedList<Integer>();
        for (int x =0; x < 7; x++)
        {
            String temp = in.readLine();
            for (int c =0; c< 6; c++)
            {
                if (temp.substring(c, c+1).equals(" "))
                {
                    map[x][c] = 0;
                }
                else if (temp.substring(c, c+1).equals("."))
                {
                    map[x][c] = 1;
                    xcoord.offer(x);
                    ycoord.offer(c);
                }
                else 
                {
                    map[x][c] = 2;
                }
            }
            if (temp.substring(6).equals(" "))
                {
                    map[x][6] = 0;
                }
                else if (temp.substring(6).equals("."))
                {
                    map[x][6] = 1;
                    xcoord.offer(x);
                    ycoord.offer(6);
                }
                else 
                {
                    map[x][6] = 2;
                }
        }
        int count = 0;
        int num = xcoord.size();
        for (int x= 0; x < num; x++)
        {
            int r = xcoord.poll();
            int c = ycoord.poll();
            System.out.println(map[r][c]);
           if (r > 1 && map[r-2][c] ==2 && map[r-1][c]==2)
            {
                count++;
            }
            if (r < 5 && map[r+2][c] ==2 && map [r+1][c]==2)
            {
                count++;
            }
            if (c < 5 && map[r][c+2] ==2 && map [r][c+1]==2)
            {
                count++;
            }
            if (c > 1 && map[r][c-2] ==2 && map [r][c-1]==2)
            {
                count++;
            }
        }
        System.out.print(count);
    }
}