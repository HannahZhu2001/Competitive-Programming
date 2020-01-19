import java.io.*;
import java.util.*;

public class ChainRule {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] tokens = in.readLine().split(" ");
        int nodes = Integer.parseInt(tokens[0]);
        int connections  = Integer.parseInt(tokens[1]);
        long [] distance = new long [nodes];
        long [] distance2 = new long [nodes];
        Arrays.fill (distance, 1000000);
        Arrays.fill (distance2, 1000000);
        List<Edge> [] list = new ArrayList[nodes];;
        boolean [] visited = new boolean [nodes];
        boolean [] visited2 = new boolean [nodes];
        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
        for(int x=0; x< nodes; x++)
        {
             list[x] = new ArrayList<Edge>();
        }
        for (int x =0; x < connections; x++)
        {
            String [] temp = in.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int fin = Integer.parseInt(temp[1]);
            int dist = Integer.parseInt(temp[2]);
            list[start].add(new Edge(fin, dist));
            list[fin].add(new Edge(start, dist));
        }
        int current = 0;
        distance[0] =0 ;
        heap.offer(new Edge(0, 0));
        while (!heap.isEmpty())
        {
            current = heap.poll().node;
            if (visited[current] == false)
            {
            visited[current] = true;
            for (Edge adj: list[current])
            {
                if (!visited[adj.node] && (distance[current] + adj.distance ) < distance[adj.node])
                {
                    distance[adj.node] = distance[current] + adj.distance;
                    heap.offer (new Edge( adj.node, distance[adj.node]));
                }
            }
            }
        }
        //visited = new boolean [nodes];
        heap = new PriorityQueue<Edge>();
        distance2[nodes-1] =0 ;
        heap.offer(new Edge(nodes-1, 0));
        while (!heap.isEmpty())
        {
          
            current = heap.poll().node;
            if (visited2[current] == false)
            {
            visited2[current] = true;
            for (Edge adj: list[current])
            {
              
                if (!visited2[adj.node] && (distance2[current] + adj.distance ) < distance2[adj.node])
                {
                  //System.out.print(".");
                    distance2[adj.node] = distance2[current] + adj.distance;
                    heap.offer (new Edge(adj.node, distance2[adj.node]));
                }
            }
            }
        }
        long max = 0;
        for (int x = 0; x < nodes; x++)
        {
           //System.out.print(distance[x]+" ");
            distance2[x] += distance[x];
            //System.out.println(distance2[x]+" ");
            max = Math.max(distance2[x], max);
        }
        System.out.print(max);
    }
}
class Edge implements Comparable<Edge> 
  {
    public int node;
    public long distance;
    public Edge (int n, long d)
    {
        node = n;
        distance = d;
    }
    public int compareTo (Edge other)
    {
        return (int)(distance - other.distance)/100;
    }
  }
