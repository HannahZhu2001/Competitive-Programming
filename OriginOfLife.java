import java.io.*;
import java.util.*;

public class OriginOfLife  {
    public static void main(String[] args) {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = in.readLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int columns = Integer.parseInt(tokens[1]);
        int stay = Integer.parseInt(tokens[2]);
        int die = Integer.parseInt(tokens[3]);
        int revive = Integer.parseInt(tokens[4]);
        boolean [] notEden = new boolean [1000000];
        int [] next = new int [1<<(rows*columns)];
        for (int x =0; x<(1<<n*m); x++)
        {
          int j = nextGen(i);
          next[i] = j;
          notEden[j] = true;
        }
        boolean [] visited = new boolean[1<<(rows*columns)];
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> steps = new LinkedList<Integer>();
        for (int x =0; x<(1<<n*m); x++)
        {
          if (notEden[x]== false)
          {
            queue.add(x);
            steps.add(0);
          }
        }
        while(queue.isEmpty()==false)
        {
          int current = queue.poll();
    }
}