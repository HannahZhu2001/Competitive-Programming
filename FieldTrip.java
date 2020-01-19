import java.io.*;
import java.util.*;

public class FieldTrip {
    static int [] parent;
    static int [] depth;
    static int [] size;
    static boolean [] cycle;
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
            cycle[parent[node1]] = true;
            return;
        }
        else if (depth[node1] > depth[node2])
        {
            parent[node2] = node1;
            size[node1] += size[node2];
        }
        else if (depth[node1] < depth[node2])
        {
            parent[node1] = node2;
            size[node2] += size[node1];
        }
        else
        {
            parent[node1] = node2;
            depth[node2]++;
            size[node2] += size[node1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = in.readLine().split(" ");
        int nodes = Integer.parseInt(tokens[0]);
        int edges = Integer.parseInt(tokens[1]);
        int k = Integer.parseInt(tokens[2]);
        parent = new int [nodes+1];
        depth = new int [nodes+1];
        size = new int [nodes+1];
        cycle = new boolean [nodes+1];
        int total =0;
        int cuts =0;
        Arrays.fill(size, 1);
        for (int x =1; x <= nodes; x++)
        {
          parent[x] = x;
        }
        for (int x = 1; x <= edges; x++)
        {
            tokens = in.readLine().split(" ");
            int num1 = Integer.parseInt(tokens[0]);
            int num2 = Integer.parseInt(tokens[1]);
           // if (find(num1) != find(num2))
            //{
                //store.add(x);
                union(num1, num2);
           // }
        }
        for (int x = 1; x <= nodes; x++)
        {
            find(x);
        }
        
        boolean [] visited = new boolean[nodes+1];
        for (int x =1; x<= nodes; x++)
        {
            if (visited[parent[x]] == false)
            {
                total += size[parent[x]]/k *k;
                visited[parent[x]] = true;
                if (cycle[parent[x]] == false)
                {
                cuts += (Math.ceil(1.00*size[parent[x]]/k)-1);
                }
                else
                {
                    
                    if (k != size[parent[x]] && size[parent[x]]/k != 0)
                    {
                    cuts += (Math.ceil(1.00*size[parent[x]]/k));
                    }
                }
            }
        }
        System.out.print(total+" "+cuts);
    }
}