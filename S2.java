import java.io.*;
import java.util.*;

public class S2 {
    public static void main(String[] args) throws IOException{
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int jerseys = Integer.parseInt(in.readLine());
      int athletes = Integer.parseInt(in.readLine());
//      HashMap<String, Integer> sizeConversion = new HashMap<String, Integer> ();
//      sizeConversion.put ("S", 1);
//      sizeConversion.put ("M", 2);
//      sizeConversion.put ("L", 3);
      HashMap<Integer, Character> available = new HashMap<Integer, Character>();
      for (int x = 1; x <= jerseys; x++)
      {
        available.put(x, in.readLine().charAt(0));
      }
      int count = 0;
      for (int x =0; x < athletes; x++)
      {
        String [] temp = in.readLine().split(" ");
        int number = Integer.parseInt(temp[1]);
        if (available.containsKey(number) && available.get(number) <= temp[0].charAt(0))
        {
          count++;
          available.remove(number);
        }
      }
      System.out.print (count);
    }
}
