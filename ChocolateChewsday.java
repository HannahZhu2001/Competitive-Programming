import java.io.*;
import java.util.*;

public class ChocolateChewsday {
  public static void main(String[] args) throws IOException {
    //PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    for (int q =0; q<10;  q++)
    {
      int num = Integer.parseInt(in.readLine());
      String [] names = new String [num];
      String hold = in.readLine();
      int [] p = new int [num];
      int [] f= new int [num];
      int [] g = new int [num];
      int [] total = new int [num];
      for (int x =0; x<num; x++)
      {
        names[x] = hold;
        String [] judges = in.readLine().split(" ");
        while (judges[0].equals("J"))
        {
          p[x] += Integer.parseInt(judges[1]);
          f[x] += Integer.parseInt(judges[2]);
          g[x] += Integer.parseInt(judges[3]);
          judges = in.readLine().split(" ");
        }
        hold = judges[0]; 
        total[x] = p[x] + g[x] + f[x];
        
        
      }
      ArrayList<Integer> max = new ArrayList<Integer> ();
      max.add(0);
      for (int x =1; x <num; x++)
      {
        if (total[max.get(0)] < total[x])
        {
          max.clear();
          max.add(x);
        }
        else if (total[max.get(0)] == total[x])
        {
          if (g[max.get(0)] < g[x])
          {
            max.clear();
            max.add(x);
          }
          else if (g[max.get(0)] == g[x])
          {
            if (f[max.get(0)] < f[x])
            {
              max.clear();
              max.add(x);
            }
            else if (f[max.get(0)] == f[x])
            {
              if (g[max.get(0)] < g[x])
              {
                max.clear();
                max.add(x);
              }
              else if (g[max.get(0)] == g[x])
              {
                max.add(x);
              }
            }
          }
        }
        
      }
      System.out.print(names[max.get(0)]);
      for (int x =1; x< max.size(); x++)
      {
        System.out.print(","+names[max.get(x)]);
      }
      System.out.println();
    }
    //in.close();
    //out.close();
  }
}