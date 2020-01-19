import java.io.*;
import java.util.*;

public class SaveNagato {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(in.readLine());
        List<Integer> [] list = new ArrayList[nodes+1];;
        boolean [] visited = new boolean [nodes+1];
        for(int x=0; x<= nodes; x++)
        {
             list[x] = new ArrayList<Integer>();
        }
        for (int x =0; x < nodes-1; x++)
        {
            String [] temp = in.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int fin = Integer.parseInt(temp[1]);
            //int dist = Integer.parseInt(temp[2]);
            list[start].add(fin);
            list[fin].add(start);
        }
        long [] distance = new long [nodes+1];
        long [] distance2 = new long [nodes+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        visited[1] = true;
        while (queue.isEmpty()==false)
        {
            int current = queue.poll();
            //if (visited[current] == false)
            //{
            //visited[current] = true;
            for (int adj: list[current])
            {
                if (!visited[adj] )
                {
                    distance[adj] = distance[current] + 1;
                    queue.add (adj);
                    visited[adj] = true;
                }
            }
            //}
        }
        int furthest = 0;
        for (int x =1; x <= nodes; x++)
        {
            if(distance[furthest] < distance[x])
            {
                furthest = x;
            }
        }
        queue.add(furthest);
        visited = new boolean [nodes+1];
        
        distance = new long [nodes+1];
        while (queue.isEmpty()==false)
        {
            int current = queue.poll();
           // if (visited[current] == false)
           // {
           // visited[current] = true;
            for (int adj: list[current])
            {
                if (!visited[adj] )
                {
                    distance[adj] = distance[current] + 1;
                    queue.add (adj);
                    visited[adj] = true;
                }
            }
            //}
        }
        
        furthest = 0;
        for (int x =1; x <= nodes; x++)
        {
            if(distance[furthest] < distance[x])
            {
                furthest = x;
            }
        }
        queue.add(furthest);
        visited = new boolean [nodes+1];
        visited[furthest] = true;
        while (queue.isEmpty()==false)
        {
            int current = queue.poll();
            //if (visited[current] == false)
            //{
            //visited[current] = true;
            for (int adj: list[current])
            {
                if (!visited[adj] )
                {
                    distance2[adj] = distance2[current] + 1;
                    queue.add (adj);
                    visited[adj] = true;
                }
            }
            //}
        }
        
        //Arrays.sort(distance);
        //Arrays.sort(distance2);
        for (int x =0; x < nodes; x++)
        {
            System.out.println(1+Math.max(distance[x+1], distance2[x+1]));
        }
       // System.out.println(Math.max(distance[nodes-1], distance2[nodes-1]));
    }
}
class Edge implements Comparable<Edge> 
  {
    public int node;
    public int distance;
    public Edge (int n, int d)
    {
        node = n;
        distance = d;
    }
    public int compareTo (Edge other)
    {
        return distance - other.distance;
    }
  }
