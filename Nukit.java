import java.io.*;
import java.util.*;

public class Nukit {
    static int [][][][] store = new int [30][30][30][30];
    public static boolean win (int a, int b, int c, int d, int turn)
    {
        boolean win = false;
        if (store[a][b][c][d] != 0)
        {
          if (store[a][b][c][d] % 2 == turn)
          {
            
            return true;
          }
          else
          {
            return false;
          }
        }
        if (a >=2 && b >= 1 && d >= 2)
        {
            if (win(a-2, b-1, c, d-2, (turn+1)% 2)==false)
            {
                win = true;
            }
        }
        if (a >=1 && b >= 1 && c>=1 && d >= 1)
        {
            if (win(a-1, b-1, c-1, d-1,(turn+1)% 2)==false)
            {
                win = true;
            }
        }
        if (d >= 1 && c >= 2)
        {
            if (win(a, b, c-2, d-1, (turn+1)% 2)==false)
            {
                win = true;
            }
        }
        if (b>=3)
        {
            if (win(a, b-3, c, d, (turn+1)% 2)==false)
            {
                win = true;
            }
        }
        if (a>=1 && d>=1)
        {
            if (win(a-1, b, c, d-1, (turn+1)% 2)==false)
            {
                win = true;
            }
        }
        if (win== false)
        {
          turn++;
          turn %= 2;
        }
        if (turn == 0)
          {
            store[a][b][c][d] = 2;
          }
          else
          {
            store[a][b][c][d] = 1;
          }
        return win;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        for (int x =0; x<cases; x++)
        {
          store = new int [30][30][30][30];
            String [] temp = in.readLine().split(" ");
            if (win(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]), 0))
            {
                System.out.println("Patrick");
            }
            else
            {
                System.out.println("Roland");
            }
        }
    }
}