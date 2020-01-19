import java.io.*;
import java.util.*;

public class S5 {
    public static void main(String[] args) throws IOException{
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(in.readLine());
      int [] pies = new int[num+1];
      //int [] dp = new int [num];
      for (int x =1; x <= num; x++)
      {
        pies[x] = Integer.parseInt(in.readLine());
      }
      for (int x =3; x <= num; x++)
      {
        pies[x] += Math.max(pies[x-2], pies[x-3]);
      }
      int more = Integer.parseInt(in.readLine());
      int [] morePies = new int [more];
      for (int x =0; x< more; x++)
      {
        morePies[x] = Integer.parseInt(in.readLine());
      }
      System.out.print (Math.max(pies[num-1], pies[num]));
    }   
}