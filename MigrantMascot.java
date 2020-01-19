import java.io.*;
import java.util.*;

public class MigrantMascot {
  
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
    String [] tokens = in.readLine().split(" ");
    int nodes = Integer.parseInt(tokens[0]);
    int connections = Integer.parseInt(tokens[1]);
    PriorityQueue<EdgeT> heapB = new PriorityQueue<EdgeT>();
    ArrayList<EdgeT> store = new ArrayList<EdgeT> ();
    parent = new int [nodes+1];
    depth = new int [nodes+1];
    EdgeT [] inputE = new EdgeT[connections];
    for (int x= 0; x< connections; x++)
    {
      String [] temp = in.readLine().split(" ");
      inputE [x] = new EdgeT ( Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Long.parseLong(temp[2])*(-1));
    }
    Arrays.sort(inputE);
    for (int x = 1; x <= nodes; x++)
    {
      parent[x] = x;
    }
    for (int x =0; x< connections; x++)
    {
      EdgeT e = inputE[x];
      if (find(e.node1) != find(e.node2))
      {
        //System.out.println (e.node1 + " " + e.node2);
        store.add(e);
        union(e.node1, e.node2);
      }
    }
//    for (int x =0 ; x< store.size(); x++)
//    {
//      System.out.println (store.get(x).node1 + " " + store.get(x).node2 + " " + store.get(x).distance);
//    }
    long [] distance = new long [nodes+1];
    boolean [] visited = new boolean [nodes+1];
    List<Edge> [] list = new ArrayList [nodes+1];
    for (int x =0; x<= nodes; x++)
    {
      list [x] = new ArrayList<Edge> ();
    }
    for (int x =0; x< store.size(); x++)
    {
      list[store.get(x).node1].add (new Edge(store.get(x).node2, -1*store.get(x).distance));
      list[store.get(x).node2].add (new Edge(store.get(x).node1, -1*store.get(x).distance));
    }
    Queue<Edge> queue = new LinkedList<Edge>();
    distance[1] = 100000;
    visited[1] = true;
    queue.add(new Edge(1, 10000));
    while (queue.isEmpty() == false)
    {
      Edge current = queue.poll();
      //if (visited[current] == false)
      //{
      //visited[current] = true;
      for (Edge adj : list[current.node])
      {
        if (visited[adj.node] == false)
        {
          visited[adj.node] = true;
          distance [adj.node] = Math.min (adj.distance, distance[current.node]);
          queue.add(new Edge(adj.node, 0));
        }
      }
      
    }
    distance[1] = 0;
    for (int x =1; x<= nodes; x++)
    {
      System.out.println (distance[x] );
      
    }
  }
}
class EdgeT implements Comparable<EdgeT> 
{
  public int node1;
  public int node2;
  public long distance;
  public EdgeT (int n, int n2, long d)
  {
    node1 = n;
    node2 = n2;
    distance = d;
  }
  public int compareTo (EdgeT other)
  {
    return (int)(distance - other.distance)/1;
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
    return (int)(distance - other.distance);
  }
}
