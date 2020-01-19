import java.io.*;
import java.util.*;

public class PhonomenalReviews {
    static boolean [] pho;
    static List<Integer> [] list;
    static List<Integer> [] list2;
    static int edgeNum =0;
    static boolean []v;
    static int nodes;
    public static boolean dfs(int u , int parent)
    {
        boolean flag = pho[u];
        if (v[u] == false)
        {
          v[u] = true;
        for (int adj: list[u])
        {
          if (v[adj] == false)
          {
            if (dfs(adj, u))
            {
                flag = true;
            }
          }
        }
        if (flag && parent != nodes)
        {
            list2[u].add(parent);
            list2[parent].add(u);
            edgeNum++;
           // System.out.println(u + " "+ parent + " " +pho[u]);
        }
        }
        return flag;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        nodes = Integer.parseInt(temp[0]);
        int phoNum = Integer.parseInt(temp[1]);
        pho = new boolean [nodes+1];
        v = new boolean[nodes+1];
        temp = in.readLine().split(" ");
        int firstPho = Integer.parseInt(temp[0]);
        for (int x =0; x < phoNum; x++)
        {
            pho[Integer.parseInt(temp[x])] = true;
        }
        
        list = new ArrayList[nodes+1];;
        boolean [] visited = new boolean [nodes+1];
        for(int x=0; x<= nodes; x++)
        {
             list[x] = new ArrayList<Integer>();
        }
        list2 = new ArrayList[nodes+1];;
        //boolean [] visited = new boolean [nodes+1];
        for(int x=0; x<= nodes; x++)
        {
             list2[x] = new ArrayList<Integer>();
        }
        for (int x= 1; x < nodes; x++)
        {
            temp = in.readLine().split(" ");
            int fin = Integer.parseInt(temp[0]);
            int start = Integer.parseInt(temp[1]);
            list[fin].add(start);
            list[start].add(fin);
        }
        //v[firstPho] = true;
        dfs(firstPho, nodes);
        long [] distance = new long [nodes+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(firstPho);
        visited[firstPho] = true;
        while (queue.isEmpty()==false)
        {
            int current = queue.poll();
            //if (visited[current] == false)
            //{
            //visited[current] = true;
            for (int adj: list2[current])
            {
                if (!visited[adj] )
                {
                    distance[adj] = distance[current] + 1;
                    queue.add (adj);
                    visited[adj] = true;
                }
            }
            //}
        }
        int furthest = firstPho;
        for (int x =0; x < nodes; x++)
        {
          //System.out.println(distance[x]);
            if(distance[furthest] < distance[x])
            {
                furthest = x;
            }
        }
        //System.out.println();
        queue.add(furthest);
        visited = new boolean [nodes+1];
        visited[furthest] = true;
        distance = new long [nodes+1];
        //System.out.println(edgeNum);
        //edgeNum--;
        while (queue.isEmpty()==false)
        {
            int current = queue.poll();
           // if (visited[current] == false)
           // {
           // visited[current] = true;
            for (int adj: list2[current])
            {
                if (!visited[adj] )
                {
                    distance[adj] = distance[current] + 1;
                    queue.add (adj);
                    visited[adj] = true;
                }
            }
            //}
        }
        furthest = firstPho;
        //System.out.println(firstPho);
        for (int x =0; x < nodes; x++)
        {
          //System.out.println(distance[x]);
            if(distance[furthest] < distance[x])
            {
                furthest = x;
            }
        }
        //System.out.println(furthest + " " + distance[furthest]);
        System.out.print(edgeNum*2 - distance[furthest]);
    }
}