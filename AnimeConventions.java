import java.io.*;
import java.util.*;

public class AnimeConventions {
    
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
        int queries = Integer.parseInt(tokens[1]);
        parent = new int [nodes+1];
        depth = new int [nodes+1];
        //ArrayList<Integer> store = new ArrayList<Integer> ();
        for (int x = 1; x <= nodes; x++)
        {
            parent[x] = x;
        }
        for (int x = 1; x <= queries; x++)
        {
            tokens = in.readLine().split(" ");
            int num1 = Integer.parseInt(tokens[1]);
            int num2 = Integer.parseInt(tokens[2]);
            if (tokens[0].equals("Q"))
            {
              if (find(num1) == find(num2))
              {
                System.out.println("Y");
              }
              else
              {
                System.out.println("N");
              }
            }
            else
            {
              union(num1, num2);
            }
            
        }
      
        
    }
}
