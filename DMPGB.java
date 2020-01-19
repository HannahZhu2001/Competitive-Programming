import java.io.*;
import java.util.*;

public class DMPGB
{
  public static void main(String [] args) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(in.readLine());
    String [] temp = in.readLine().split(" ");
    long [] psa = new long[num+1];
    long [] psa2 = new long [num+1];
    long [] psab = new long[num+2];
    long [] psa2b = new long [num+2];
    ArrayList<Long> store= new ArrayList<Long>();
    for (int x =0; x < num; x++)
    {
      psa[x+1] = psa[x] + Integer.parseInt(temp[x]);
    }
    for (int x =0; x < num; x++)
    {
      psa2[x+1] = psa2[x] + psa[x+1];
    }
    for (int x =num-1; x >=0; x--)
    {
      
      psab[num-x] = psab[num-x-1] + Integer.parseInt(temp[x]);
      //System.out.println(psab[num-x-1]+ " " + psab[num-x]);
    }
    for (int x =0; x < num; x++)
    {
      psa2b[x+1] = psa2b[x] + psab[x+1];
      //System.out.println(psa2b[x+1]);
    }
    for (int x =1; x <= (int)Math.round(num/2.0); x++)
    {
      long total = psa[num]*x;
      
      total -= psa2b[x-1];
      //System.out.println(psa2b[x-1] + " "+ psa2[x-1]);
      total -= psa2[x-1];
      store.add(total);
    }
    for (int x =0; x < store.size(); x++)
    {
      System.out.println(store.get(x));
    }
    if (num %2 == 0)
    {
      for (int x =0; x < store.size(); x++)
    {
      System.out.println(store.get(store.size()-1-x));
    }
    }
    else
    {
      for (int x =1; x < store.size(); x++)
    {
      System.out.println(store.get(store.size()-1-x));
    }
    }
    
    //System.out.print("Test");
  }
}
