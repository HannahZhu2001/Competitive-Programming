import java.io.*;
import java.util.*;

public class Artskjid {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        int nodes = Integer.parseInt(temp[0]);
        int roads = Integer.parseInt(temp[1]);
        int [] distance = new int [nodes];
        Arrays.fill (distance, -1);
        List<Edge> [] list = new ArrayList[nodes];
        for(int x=0; x< nodes; x++)
        {
             list[x] = new ArrayList<Edge>();
        }
        for (int x =0; x < roads; x++)
        {
            String [] temp1 = in.readLine().split(" ");
            int start = Integer.parseInt(temp1[0]);
            int fin = Integer.parseInt(temp1[1]);
            int dist = Integer.parseInt(temp1[2]);
            list[start].add(new Edge(fin, dist, 0));
            //list[fin].add(new Edge(start, dist));
        }
        Queue<Edge> queue = new LinkedList<Edge>();
       // Queue<Integer> visited = new LinkedList<Integer>();
        queue.add(new Edge(0, 0, 1));
        int [][] furthest = new int [1<<18][nodes];
        furthest[1][0] = -1;
       // visited.add(1);
        int max=0;
        while(queue.isEmpty() == false)
        {
            Edge current = queue.poll();
            //current.visited = current.visited|1<<current.node;
            //visit = visit|1<<current.node;
            if (furthest[current.visited][current.node]<=current.distance )
            {
            //furthest[visit][current.node] = Math.max(furthest[visit][current.node], current.distance);
            //current.distance = furthest[visit][current.node];
            if (current.node == nodes-1&& current.distance > max)
                max = current.distance;
            
            for (Edge adj: list[current.node])
            {
              //System.out.println(visit);
              //System.out.println(furthest[visit]);
                if(((1<<adj.node)&current.visited) ==0 && furthest[(1<<adj.node)|current.visited][adj.node] < current.distance+adj.distance)
                {
                  //System.out.println("+");
                  furthest[(1<<adj.node)|current.visited][adj.node] = current.distance+adj.distance;
                    queue.add(new Edge(adj.node,current.distance+adj.distance, current.visited|(1<<adj.node)));
                    //visited.add(current.visited|(1<<adj.node));
                }
            }
            }
        }
        System.out.print(max);
    }
}
class Edge implements Comparable<Edge> 
  {
    public int node;
    public int distance;
    public int visited;
    public Edge (int n, int d, int v)
    {
        node = n;
        distance = d;
        visited = v;
    }
    public int compareTo (Edge other)
    {
        return distance - other.distance;
    }
  }