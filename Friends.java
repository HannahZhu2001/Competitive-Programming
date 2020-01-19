import java.io.*;
import java.util.*;

public class Friends {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int friends = Integer.parseInt(in.readLine());
        List<Integer> [] list = new ArrayList[10000];
        for(int x=0; x < 10000; x++)
        {
             list[x] = new ArrayList<Integer>();
        }
        for (int x =0; x < friends; x++)
        {
            String [] temp = in.readLine().split(" ");
            int first = Integer.parseInt(temp[0]);
            int second = Integer.parseInt(temp[1]);
            list[first].add(second);
        }
        String [] temp = in.readLine().split(" ");
        int first = Integer.parseInt(temp[0]);
        int second = Integer.parseInt(temp[1]);
        while (first+second != 0)
        {
            Queue<Integer> queue = new LinkedList<Integer>();
            Queue<Integer> degree = new LinkedList<Integer>();
            boolean [] visited = new boolean [friends+1];
            visited[first] = true;
            degree.add(0);
            queue.add(first);
            boolean found = false;
            while (queue.isEmpty() == false)
            {
                int hold = queue.poll();
                int d = degree.poll();
                if (hold == second)
                {
                    found = true;
                    System.out.println ("yes " + d);
                    break;
                }
                for (int x  = 0 ; x < list[hold].size(); x++)
                {
                    if (visited[list[hold].get(x)] == false)
                    {
                        visited[list[hold].get(x)] = true;
                        queue.add(list[hold].get(x));
                        degree.add(d+1);
                    }
                }   
            }
            if (found == false)
            {
                System.out.println("no");
            }
            temp = in.readLine().split(" ");
            first = Integer.parseInt(temp[0]);
            second = Integer.parseInt(temp[1]);
        }
    }
}