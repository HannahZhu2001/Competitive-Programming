import java.io.*;
import java.util.*;

public class WhoIsTaller {
    public static void main(String[] args) throws IOException  {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        int friends = Integer.parseInt(temp[0]);
        int comparisons = Integer.parseInt(temp[1]);

        List<Integer> [] list = new ArrayList[friends+1];
        for(int x=0; x <= friends; x++)
        {
             list[x] = new ArrayList<Integer>();
        }
        for (int x =0; x < comparisons; x++)
        {
            temp = in.readLine().split(" ");
            int first = Integer.parseInt(temp[0]);
            int second = Integer.parseInt(temp[1]);
            list[first].add(second);
        }
        int found = 0;
        temp = in.readLine().split(" ");
        int q = Integer.parseInt(temp[0]);
        int p = Integer.parseInt(temp[1]);
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean [] visited = new boolean [friends+1];
        visited[q] = true;
        queue.add(q);
        while (queue.isEmpty() == false)
        {
            int hold = queue.poll();
            if (hold == p)
            {
                found = 1;
                break;
            }
            for (int x  =0 ; x < list[hold].size(); x++)
            {
                if (visited[list[hold].get(x)] == false)
                {
                    visited[list[hold].get(x)] = true;
                    queue.add(list[hold].get(x));
                }
            }
        }
        queue = new LinkedList<Integer>();
        queue.add(p);
        visited = new boolean [friends+1];
        visited[p] = true;
        while (queue.isEmpty() == false)
        {
            int hold = queue.poll();
            if (hold == q)
            {
                found = 2;
                break;
            }
            for (int x  =0 ; x < list[hold].size(); x++)
            {
                if (visited[list[hold].get(x)] == false)
                {
                    visited[list[hold].get(x)] = true;
                    queue.add(list[hold].get(x));
                }
            }
        }
        if (found == 1)
        {
            System.out.print("yes");
        }
        else if (found == 2)
        {
            System.out.print("no");
        }
        else
        {
            System.out.print("unknown");
        }
        
    }
}