import java.io.*;
import java.util.*;

public class DMPGE
{
  public static void main(String [] args) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String [] temp = in.readLine().split(" ");
    int size = Integer.parseInt(temp[0]);
    int queries = Integer.parseInt(temp[1]);
    temp = in.readLine().split(" ");
    int [] array = new int [size];
    for (int x =0;x<size; x++)
    {
      array[x] = Integer.parseInt(temp[x]);
    }
    for (int x=0; x < queries; x++)
    {
    temp = in.readLine().split(" ");
    if (Integer.parseInt(temp[0]) == 1)
    {
      int count = 0;
      int right = Integer.parseInt(temp[2]);
      int md = Integer.parseInt(temp[3]);
      for (int c = Integer.parseInt(temp[1])-1; c < right; c++)
      {
        if (array[c] % md == 0)
        {
          count++;
        }
      }
      System.out.println(count);
    }
    else
    {
      array[Integer.parseInt(temp[1])-1] = Integer.parseInt(temp[2]);
    }
    }
    //System.out.print("Test");
  }
}
