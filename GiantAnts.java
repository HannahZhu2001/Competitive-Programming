import java.io.*;
import java.util.*;

public class GiantAnts {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String [] tokens = in.readLine().split(" ");
    int nodes = Integer.parseInt(tokens[0]);
    int roads = Integer.parseInt(tokens[1]);
   // boolean [] visited = new boolean [nodes+1];
    List<Integer> [] list = new ArrayList[nodes+1];
    for(int x=0; x <= nodes; x++)
    {
      list[x] = new ArrayList<Integer>();
    }
    for (int x =0; x < roads; x++)
    {
      String [] temp = in.readLine().split(" ");
      list[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
      list[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
    }                                               
    int antNum = Integer.parseInt(in.readLine());
    //int [] ants = new int [antNum];
    int [] antTime = new int [nodes+1];
    for (int x = 0; x <= nodes; x++)
    {
      antTime[x] = 100000;
    }
    boolean [] visited = new boolean [nodes+1];
      Queue<Integer> queue = new LinkedList<Integer> ();
      Queue<Integer> time = new LinkedList<Integer> ();
      int position;
        int currentTime;
    for (int x =0; x < antNum; x++)
    {
      visited = new boolean [nodes+1];
      queue = new LinkedList<Integer> ();
      time = new LinkedList<Integer> ();
      int antIn = Integer.parseInt(in.readLine());
      queue.add(antIn);
      time.add(0);
      visited[antIn] = true;
      while (queue.isEmpty() == false)
      {
        position = queue.poll();
        currentTime = time.poll();
        antTime[position] = Math.min(currentTime, antTime[position]);
        for (int i = 0; i < list[position].size(); i++)
        {
          if (visited[list[position].get(i)] == false)
          {
            visited[list[position].get(i)] = true;
            time.add(currentTime+4);
            queue.add(list[position].get(i));
          }
        }
      }
    }
    boolean found = false;
    visited = new boolean [nodes+1];
    queue = new LinkedList<Integer> ();
    time = new LinkedList<Integer> ();
    queue.add(1);
    time.add(0);
    int finishTime = 0;
    visited[1] = true;
    while (queue.isEmpty() == false)
    {
      position = queue.poll();
      currentTime = time.poll();
      if (position == nodes)
      {
        found = true;
        finishTime = currentTime;
      }
      for (int i = 0; i < list[position].size(); i++)
      {
        if (visited[list[position].get(i)] == false && (currentTime+1)<= antTime[list[position].get(i)])
        {
          visited[list[position].get(i)] = true;
          time.add(currentTime+1);
          queue.add(list[position].get(i));
        }
      }
    }
    if(found)
    {
      System.out.print(finishTime);
    }
    else
    {
      System.out.print("sacrifice bobhob314");
    }
  }
}