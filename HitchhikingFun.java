import java.io.*;
import java.util.*;

public class HitchhikingFun {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] tokens = in.readLine().split(" ");
        int nodes = Integer.parseInt(tokens[0]);
        int connections  = Integer.parseInt(tokens[1]);
        int [] distance = new int [nodes+1];
        int [] dangerous = new int [nodes+1];
        Arrays.fill (distance, 1000000);
        Arrays.fill (dangerous, 1000000);
        List<Edge> [] list = new ArrayList[nodes+1];;
        boolean [] visited = new boolean [nodes+1];
        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
        for(int x=0; x<= nodes; x++)
        {
             list[x] = new ArrayList<Edge>();
        }
        for (int x =0; x < connections; x++)
        {
            String [] temp = in.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int fin = Integer.parseInt(temp[1]);
            int dist = Integer.parseInt(temp[2]);
            list[start].add(new Edge(fin,1, dist));
            list[fin].add(new Edge(start,1, dist));
        }
        
        distance[1] = 0;
        dangerous[1] = 0;
        heap.offer(new Edge(1, 0, 0));
        while (!heap.isEmpty())
        {
            int current = heap.poll().node;
            if (visited[current] == false)
            {
            visited[current] = true;
            for (Edge adj: list[current])
            {
              //System.out.println(current + " " + dangerous[adj.node] +" " + adj.node);
                if (!visited[adj.node] && (dangerous[current] + adj.dangerous ) < dangerous[adj.node])
                {
                  //System.out.println(current + " " + adj.node + " c");
                    distance[adj.node] = distance[current] + adj.distance;
                    dangerous[adj.node] = dangerous[current] + adj.dangerous;
                    heap.offer (new Edge( adj.node, distance[adj.node], dangerous[adj.node]));
                }
                else if (!visited[adj.node] && (dangerous[current] + adj.dangerous ) <= dangerous[adj.node] && (distance[current] + adj.distance ) < distance[adj.node]) 
                {
                  //System.out.println(current + " " + adj.node + " c");
                    distance[adj.node] = distance[current] + adj.distance;
                    dangerous[adj.node] = dangerous[current] + adj.dangerous;
                    heap.offer (new Edge( adj.node, distance[adj.node], dangerous[adj.node]));
  }
            }
            }
        }
        if (dangerous[nodes] != 1000000 && distance[nodes] != 1000000)
        {  
        System.out.print(dangerous[nodes] + " " + distance[nodes]);
        }
        else
        {
          System.out.println(-1);
        }
    }
}
class Edge implements Comparable<Edge> 
  {
    public int node;
    public int distance;
    public int dangerous;
    public Edge (int n, int d, int c)
    {
        node = n;
        distance = d;
        dangerous = c;
    }
    public int compareTo (Edge other)
    {
        if (dangerous != other.dangerous)
        {
            return dangerous -other.dangerous;
        }
        return distance - other.distance;
    }
  }
