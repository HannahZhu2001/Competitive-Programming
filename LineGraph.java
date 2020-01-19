import java.io.*;
import java.util.*;

public class LineGraph {
    
    static int [] parent;
    static int [] depth;
    static long weight = 0;
    static Edge current;
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
        weight += current.distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = in.readLine().split(" ");
        int nodes = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        parent= new int [nodes+1];
        depth = new int [nodes+1];
        String [] temp = in.readLine().split(" ");
        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
        for (int x = 1; x <= Math.min(nodes, k); x++)
        {
            parent[x] = x;
        }
        for (int x = 1; x <= Math.min(nodes, k); x++)
        {
            int count = x;
            while (count<=nodes)
            {
                parent[count] = x;
                count+=k;
            }
        }
        for (int x= 1; x < nodes; x++)
        {
            heap.add(new Edge(x, x+1, Integer.parseInt(temp[x-1])));
        }
        while (heap.isEmpty() == false)
        {
            current = heap.poll();
            union(current.node, current.node2);
        }
        System.out.print(weight);
    }
}
class Edge implements Comparable<Edge>
{
    public int node;
    public int node2;
    public int distance;
    public Edge (int n, int n2, int d)
    {
        node = n;
        node2 = n2;
        distance = d;
    }
    public int compareTo (Edge other)
    {
        return distance-other.distance;
    }
}