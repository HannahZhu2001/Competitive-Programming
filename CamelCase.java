import java.util.*;
import java.io.*;
public class CamelCase
{
  public static void main (String [] args) throws IOException
  {
    BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
    int num = Integer.parseInt(in.readLine());
    Edge [] dictionary = new Edge [num];
    for (int x =0; x< num; x++)
    {
      dictionary[x] = new Edge(in.readLine());
    }
    Arrays.sort(dictionary);
    int [] count = new int[10];
    String [] words = new String [10];
    for (int x =0; x < 10 ; x++)
    {
      words[x] = in.readLine();
    }
    
      for (int y =0; y < 10; y++)
      {
        while (words[y].length()!= 0)
        {
        for (int x = 0; x< num ; x++)
        {
        if (words[y].indexOf(dictionary[x].node)==0)
        {
          count[y]++;
          words[y] =words[y].substring(words[y].indexOf(dictionary[x].node)+dictionary[x].node.length());
        }
        }
        }
    }
    for (int x =0; x< 10; x++)
    {
      System.out.println(count[x] -1);
    }
                                                                                          
  }
}

class Edge implements Comparable<Edge> 
  {
    public String node;
    public Edge (String s)
    {
        node = s;
    }
    public int compareTo (Edge other)
    {
        return other.node.length() - node.length();
    }
  }
