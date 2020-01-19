import java.io.*;
import java.util.*;

public class DisjointSetUnionTemplate {
    
    static int [] parent;
    static int [] depth;
    
    public static int find (int node)
    {
        if (parent[node] == node)
        {
            return node;
        }
        else
        {
            parent[node] = find(parent[node]);
            return parent[node];
        }
        
    }
    
    public static void union (int node1, int node2)
    {
        node1 = find(node1);
        node2 = find(node2);
        if (parent[node1]==parent[node2])
        {
            return;
        }
        else if (depth[node1] > depth[node2])
        {
            parent[node2] = node1;
        }
        else if (depth[node1] < depth[node2])
        {
            parent[node1] = node2;
        }
        else
        {
            parent[node1] = node2;
            depth[node2]++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = in.readLine().split(" ");
        int nodes = Integer.parseInt(tokens[0]);
        int edges = Integer.parseInt(tokens[1]);
        parent = new int [nodes+1];
        depth = new int [nodes+1];
        ArrayList<Integer> store = new ArrayList<Integer> ();
        for (int x = 1; x <= nodes; x++)
        {
            parent[x] = x;
        }
        Edge [] list = new Edge [edges];
        for (int x =0; x< edges; x++)
        {
          tokens = in.readLine().split(" ");
           list[x] = new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]) );
        }
        Arrays.sort(list);
        
            long h =0;
        for (int x = 0; x < edges; x++)
        {
            if (find(list[x].node) != find(list[x].node2))
            {
                h +=(list[x].dist);
                union(list[x].node, list[x].node2);
            }
        }
        for (int x = 1; x <= nodes; x++)
        {
            find(x);
        }
        Arrays.sort(parent);
      //  long h = 0;
        if (parent[1] != parent[nodes])
        {
            System.out.print (0);
        }
        else
        {
            System.out.print(h);
        }
    }
}
class Edge implements Comparable<Edge> 
  {
    public int node;
    public int node2;
    public int dist;
    public Edge (int n, int d, int s)
    {
        node = n;
        node2 = d;
        dist = s;
    }
    public int compareTo (Edge other)
    {
        return dist - other.dist;
    }
  }