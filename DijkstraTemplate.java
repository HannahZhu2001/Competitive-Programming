import java.io.*;
import java.util.*;

public class DijkstraTemplate {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] tokens = in.readLine().split(" ");
        int nodes = Integer.parseInt(tokens[0]);
        int connections  = Integer.parseInt(tokens[1]);
        int [] distance = new int [nodes+1];
        Arrays.fill (distance, 1000000);
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
            list[start].add(new Edge(fin, dist));
            list[fin].add(new Edge(start, dist));
        }
        
        distance[1] =0 ;
        heap.offer(new Edge(1, 0));
        while (!heap.isEmpty())
        {
            int current = heap.poll().node;
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
        for (int x =1; x <= nodes; x++)
        {
            if (distance[x] == 1000000)
            System.out.println ("-1");
            else 
            System.out.println (distance[x]);
        }
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
