import java.io.*;
import java.util.*;

public class S4 {
    public static void main(String[] args) throws IOException{
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String [] temp = in.readLine().split(" ");
      int hull = Integer.parseInt(temp[0]);
      int islands = Integer.parseInt(temp[1]);
      int paths = Integer.parseInt(temp[2]);
      int [] distance = new int [islands+1];
      Arrays.fill (distance, 1000000);
      boolean [] visited = new boolean [islands+1];
      PriorityQueue<Edges> heap = new PriorityQueue<Edges>();
      List<Edges> [] list = new ArrayList[islands+1];
      for(int x=0; x <= islands; x++)
      {
        list[x] = new ArrayList<Edges>();
      }
      for (int x =0; x < paths; x++)
      {
        String [] tokens = in.readLine().split(" ");
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);
        int t = Integer.parseInt(tokens[2]);
        int h = Integer.parseInt(tokens[3]);
        list[a].add(new Edges(b, t, h));
        list[b].add(new Edges(a, t, h));
      }
      String [] temp1 = in.readLine().split(" ");
      int start = Integer.parseInt(temp1[0]);
      int fin = Integer.parseInt(temp1[1]);
      int solution = -1;
      int time = 100000;
      for (int x =0; x<list[start].size(); x++)
      {
        if (list[start].get(x).n() == fin && list[start].get(x).hw() <= hull && list[start].get(x).d() <= time)
        {
          solution = list[start].get(x).n();
          time = list[start].get(x).d();
        }
      }
      if (time == 100000)
      {
        System.out.print(-1);
      }
      else
      {
        System.out.print(time);
      }
    }
}
class Edges implements Comparable<Edges> 
  {
    public int node;
    public int distance;
    public int hull;
    public Edges (int n, int d, int h)
    {
        node = n;
        distance = d;
        hull = h;
    }
    public int compareTo (Edges other)
    {
        return distance - other.distance;
    }
    public int d ()
    {
      return distance;
    }
    public int n ()
    {
      return node;
    }
    public int hw ()
    {
      return hull;
    }
  }