import java.io.*;
import java.util.*;

public class SegmentTreeTemplate {
  static Edge [] seg;
  static int [] a;
  public static void build (int l, int r, int id)
  {
    seg[id] = new Edge(l, r, 0, 0);
    //seg[id].left = l;
    //seg[id].right = r;
    if (l == r)
    {
      seg[id].value = a[l];
      seg[id].min = a[l];
      seg[id].gcd = a[l];
      seg[id].frequency = 1;
      
      return;
    }
    int mid = (l+r)/2;
    build(l, mid, 2*id);
    build(mid+1, r, 2*id+1);
    seg[id].min = Math.min(seg[id*2].min, seg[id*2+1].min);
    seg[id].gcd = GCD(seg[id*2].gcd, seg[id*2+1].gcd);
    //hereeee
    if(seg[id*2].gcd == seg[id*2+1].gcd )
      seg[id].frequency = seg[id*2].frequency+ seg[id*2+1].frequency;
    else if (seg[id*2].gcd == seg[id].gcd)
      seg[id].frequency = seg[id*2].frequency;
    else if(seg[id*2+1].gcd == seg[id].gcd)
      seg[id].frequency = seg[id*2+1].frequency;
    else 
      seg[id].frequency =0;
    //System.out.println(id + " " + seg[id].frequency);
  }
  
  static void update(int pos, int val, int id)
  {
    if(seg[id].left == pos && seg[id].right == pos)
    {
      seg[id].value = val;
      seg[id].gcd = val;
      seg[id].min = val;
      seg[id].frequency =1;
      return;
    }
    int mid = (seg[id].left + seg[id].right)/2;
    if (pos <= mid)
      update(pos, val, 2 * id);
    else 
      update(pos, val, 2 * id +1);
    seg[id].min = Math.min(seg[id*2].min, seg[id*2+1].min);
    seg[id].gcd = GCD(seg[id*2].gcd, seg[id*2+1].gcd);
    if(seg[id*2].gcd == seg[id*2+1].gcd )
      seg[id].frequency = seg[id*2].frequency+ seg[id*2+1].frequency;
    else if (seg[id*2].gcd == seg[id].gcd)
      seg[id].frequency = seg[id*2].frequency;
    else if(seg[id*2+1].gcd == seg[id].gcd)
      seg[id].frequency = seg[id*2+1].frequency;
    else 
      seg[id].frequency =0;
    
    
  }
  static int queryMin (int l, int r, int id)
  {
    if(seg[id].left == l && seg[id].right == r)
      return seg[id].min;
    int mid = (seg[id].left+seg[id].right)/2;
    if (r <= mid)
      return queryMin(l, r, 2 * id);
    else if (l > mid)
      return queryMin(l, r, 2 * id + 1);
    else 
      return Math.min(queryMin(l, mid, 2*id),queryMin(mid+1, r, 2*id+1));
  }   
  
  static int queryGCD (int l, int r, int id)
  {
    if(seg[id].left == l && seg[id].right == r)
      return seg[id].gcd;
    int mid = (seg[id].left+seg[id].right)/2;
    if (r <= mid)
      return queryGCD(l, r, 2 * id);
    else if (l > mid)
      return queryGCD(l, r, 2 * id + 1);
    else 
      return GCD(queryGCD(l, mid, 2*id),queryGCD(mid+1, r, 2*id+1));
  }   
  
  static int queryFreq (int l, int r, int id)
  {
    if(seg[id].left == l && seg[id].right == r)
      return seg[id].frequency;
    int mid = (seg[id].left+seg[id].right)/2;
    if (r <= mid)
      return queryFreq(l, r, 2 * id);
    else if (l > mid)
      return queryFreq(l, r, 2 * id + 1);
    else 
    {
      int gcd1 = queryGCD(l, mid, 2*id);
      int gcd2=queryGCD(mid+1, r, 2*id+1);
      int gcd = GCD(gcd1, gcd2);
      int answer =0;
      if(gcd == gcd1)
      {
        answer +=queryFreq(l, mid, 2*id);
      }
      if (gcd == gcd2)
        answer +=queryFreq(mid+1, r, 2*id+1);
      return answer;
    }
  }   
  public static int GCD (int num1 , int num2)
  {
    
    if (num2 == 0)
      return num1;
    else
    {
      int rem = num1 %num2;
      return GCD (num2, rem);
    }
  }
  
    public static void main(String[] args) throws IOException{
      BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
      
      String [] temp = in.readLine().split(" ");
      int nodes = Integer.parseInt(temp[0]);
      int queries = Integer.parseInt(temp[1]);
      int depth = (int) Math.round(Math.log(nodes)/Math.log(2) + 0.5);
      seg = new Edge [(int)Math.pow(2, depth)*2 +1];
      temp = in.readLine().split(" ");
      a = new int [nodes+1];
      for (int x =1; x<nodes+1; x++)
      {
        a[x] = Integer.parseInt(temp[x-1]);
      }
      build(1, nodes, 1);
      for (int x=0; x< queries; x++)
      {
      temp = in.readLine().split(" ");
      if (temp[0].equals("C"))
      {
        update(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), 1);
      }
      else if (temp[0].equals("M"))
      {
        System.out.println(queryMin(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), 1));
      }
      else if (temp[0].equals("G"))
      {
        System.out.println(queryGCD(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), 1));
      }
      else
      {
        System.out.println(queryFreq(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), 1));
      }
      }    
           
    }
}

class Edge // implements Comparable<Edge>
{
  public int left;
  public int right;
  public int min = 1000000099;
  public int gcd;
  public int frequency;
  public int value;
  public Edge (int l, int r, int g, int f)
  {
    left= l;
    right = r;
    //min = m;
    gcd = g;
    frequency = f;
 //   value = v;
  }
}
