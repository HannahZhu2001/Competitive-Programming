import java.io.*;
import java.util.*;

public class MinimumCostFlow {
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
        int connections  = Integer.parseInt(tokens[1]);
        long strength = Long.parseLong(tokens[2]);
        parent = new int [nodes+1];
        depth = new int [nodes+1];
        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
        Edge [] hold = new Edge[connections];

        for (int x = 1; x <= nodes; x++)
        {
            parent[x] = x;
        }
        for (int x =0; x<nodes-1; x++)
        {
            String [] temp = in.readLine().split(" ");
            heap.offer(new Edge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), 1));
            hold [x]= new Edge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), 1);
        }
        for (int x = nodes-1; x < connections; x++)
        {
            String [] temp = in.readLine().split(" ");
            heap.offer(new Edge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), 0));
            hold [x]= new Edge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), 0);
        }
        int days = 0;
        int edges = 0;
        Edge last = new Edge(0, 0, 0, 0);
        int count =0;
        while (edges < nodes-1)
        {
            Edge current = heap.poll();
            if (find(current.node) != find(current.node2))
            {
              last = current;
                union(current.node, current.node2);
                days+= (1-current.exist);
                edges++;
            }
            count++;
        }
        heap = new PriorityQueue<Edge>();
        depth = new int [nodes+1];
        for (int x = 1; x <= nodes; x++)
        {
            parent[x] = x;
        }
        //days = 0;
        edges = 0;
        for (int x =0; x < connections; x++)
        {
          heap.offer(hold[x]);
        }
        //int count =0;
        int copy = count;
        while (edges < nodes-1 && count >0 )
        {
            Edge current = heap.poll();
            if (find(current.node) != find(current.node2))
            {
                if (current.exist == 1 || current.distance < last.distance)
                {
                union(current.node, current.node2);
                //days+= (1-current.exist);
                edges++;
                }
            }
            count--;
        }
        boolean used = false;
        Arrays.sort(hold);
        if (last.exist == 0)
        {
        for (int x = copy; x < connections; x++)
        {
          if (hold[x].exist == 1 && hold[x].distance <= strength && used == false)
          {
            System.out.println("Here");
            if (find(hold[x].node) != find(hold[x].node2))
            {
              System.out.println("w");
              days --;
              used = true;
            }
            break;
          }
        }
        }
        System.out.print(days);
    }
}
class Edge implements Comparable<Edge> 
  {
    public int node;
    public int node2;
    public int distance;
    public int exist;
    public Edge (int n, int n2, int d, int e)
    {
        node = n;
        node2 = n2;
        distance = d;
        exist = e;
    }
    public int compareTo (Edge other)
    {
        if (distance == other.distance)
        {
            return other.exist-exist;
        }
        return distance - other.distance;
    }
  }
