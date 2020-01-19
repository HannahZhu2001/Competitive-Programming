import java.io.*;
import java.util.*;

public class CrossingField {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        int num = Integer.parseInt(temp[0]);
        int height = Integer.parseInt(temp[1]);
        int [][] map = new int [num+1][num+1];
        boolean [][] visited = new boolean [num+1][num+1];
        for (int x = 0; x <= num; x++)
        {
            visited[x][0] = true;
            visited[0][x] = true;
        }
        for (int x =1; x <= num; x++)
        {
            String [] tokens = in.readLine().split(" ");
            for (int y =0; y < num; y++)
            {
                map[x][y+1] = Integer.parseInt(tokens[y]);
            }
        }
        Queue<Integer> queueX = new LinkedList<Integer> ();
        Queue<Integer> queueY = new LinkedList<Integer> ();
        Queue<Integer> queueH = new LinkedList<Integer> ();
        queueX.add(1);
        queueY.add(1);
        //queueH.add(map[1][1]);
        boolean found = false;
        visited[1][1] = true;
        while (queueX.isEmpty() == false)
        {
            int x = queueX.poll();
            int y = queueY.poll();
            //int h = queueX.poll();
            if (x == num && y == num)
            {
                System.out.print("yes");
                found = true;
                break;
            }
            else if (x <= num && y <= num )
            {
                if ((y+1) <=num && Math.abs(map[x][y] - map[x][y+1]) <= height && visited[x][y+1] == false)
                {
                    visited[x][y+1] = true;
                    queueX.add(x);
                    queueY.add(y+1);
                    //System.out.println (x + " " + (y+1));
                }
                if ((y-1) <=num && Math.abs(map[x][y] - map[x][y-1]) <= height && visited[x][y-1] == false)
                {
                    visited[x][y-1] = true;
                    queueX.add(x);
                    queueY.add(y-1);
                    //System.out.println (x + " " + (y-1));
                }
                if ((x+1) <=num && Math.abs(map[x][y] - map[x+1][y]) <= height && visited[x+1][y] == false)
                {
                    visited[x+1][y] = true;
                    queueX.add(x+1);
                    queueY.add(y);
                    //System.out.println ((x+1) + " " + y);
                }
                if ((x-1) <=num && Math.abs(map[x][y] - map[x-1][y]) <= height && visited[x-1][y] == false)
                {
                    visited[x-1][y] = true;
                    queueX.add(x-1);
                    queueY.add(y);
                    //System.out.println ((x-1) + " " + y);
                }
            }
            
            
        }
        if (found == false)
        {
            System.out.print("no");
        }
    }
}