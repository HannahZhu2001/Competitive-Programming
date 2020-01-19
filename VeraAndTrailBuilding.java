import java.io.*;
import java.util.*;

public class VeraAndTrailBuilding {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int pairs = Integer.parseInt(in.readLine());
        int nodes = 1;
        ArrayList<Integer> edges = new ArrayList<Integer>();
        while (pairs > 0)
        {
          int hold = (int) Math.floor(Math.sqrt(pairs*2));
          if (hold ==1 )
          {
            hold +=1;
          }
          pairs -= (hold*(hold-1))/2;
          
          for (int x = nodes; x < nodes+hold-1; x++)
          {
            edges.add(x);
            edges.add(x+1);
          }
          edges.add(nodes);
          edges.add(nodes+hold-1);
          if (nodes > 1)
          {
            edges.add(nodes);
            edges.add(nodes-1);
          }
          nodes +=hold;
        }
        System.out.println ((nodes-1) + " " + (int) Math.round(edges.size()/2));
        for (int x = 0; x<edges.size(); x +=2)
        {
          System.out.println(edges.get(x) + " " + edges.get(x+1));
        }
          
          
        
        
    }
}