import java.io.*;
import java.util.*;

public class FenwickTreeTemplate 
{
  static int [] array;
 // static int [] array2 = new int [100001];
  static long [] tree;
 // static long [] frequency = new long [100001];
  static int max;
  
  static void update(int value, int index)
  {
//    int old = array[index];
//   // array2[old]--;
//    while (old < 100001)
//    {
//      frequency[old]--;
//      old += (old & -old);
//    }
   // array2[value]++;
   // int value2 = value;
   // while (value < 100001)
    //{
    //  frequency[value]++;
    //  value += (value & -value);
    //}
    //value = value2;
    int num = value- array[index];
    array[index] = value;
    while (index < max)
    {
      tree[index] += num;
      index += (index & -index);
    }
  }
  
  
  static long query (int left, int right)
  {
    long sum =0;
    while (right >0)
    {
      sum += tree[right];
      right -= (right & -right);
    }
    long sum2= 0;
    while (left >0)
    {
      sum2 +=tree[left];
      left -= (left & -left);
    }
    return (sum-sum2);
  }
    
//  static long query2 (int index)
//  {
//    long sum =0;
//    while (index >0)
//    {
//      sum += frequency[index];
//      index -= (index & -index);
//    }
//    return (sum);
//  }
    
    
  public static void main (String [] args) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String [] temp = in.readLine().split(" ");
    max = Integer.parseInt(temp[0]) +1;
    int queries = Integer.parseInt(temp[1]);
    tree = new long [max];
    array = new int [max];
    //array2 = new int [max];
    temp = in.readLine().split(" ");
    for (int x =1; x < max; x++)
    {
      array[x] = Integer.parseInt(temp[x-1]);
    //  array2[array[x]]++;
      tree[x] += array[x];
      int j = x+ (x & -x);
      if (j < max)
      {
        tree[j] += tree[x];
      }
      //while(j <max)
      //{
      //  tree[j] += array[x];
      //  j += (j & -j);
      //}
    }
//   
//    for (int x =1; x < 100001; x++)
//    {
//      //array[x] = Integer.parseInt(temp[x-1]);
//      //frequency[array[x]]++;
//      frequency[x] += array2[x];
//      int j = x+ (x & -x);
//      if (j < 100001)
//      {
//        frequency[j] += frequency[x];
//        //j += (j & -j);
//                
//      }
//    }

    
    /*for (int x =0; x < max; x++)
    {
      System.out.println(tree[x]);
    }*/
    for (int x = 0; x < queries; x++)
    {
      temp = in.readLine().split(" ");
      if (temp[0].equals("C"))
      {
       // update2(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]));
        update(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]));
      }
      else if (temp[0].equals("S"))
      {
        System.out.println(query(Integer.parseInt(temp[1])-1, Integer.parseInt(temp[2])));
      }
      else
      {
        System.out.println(query2(Integer.parseInt(temp[1])));
      }
      
      
      
    }
    
//     for (int x =0; x< max; x++)
//    {
//      System.out.println(tree[x]);
//    }
//    System.out.println();
//    for (int x =0; x< 20; x++)
//    {
//      System.out.println(array2[x] + " "+frequency[x]);
//    }
  }
}
