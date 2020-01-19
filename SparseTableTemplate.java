import java.io.*;
import java.util.*;

public class SparseTableTemplate {
   public static void main(String[] args) throws IOException{
      BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
      String []temp= in.readLine().split(" ");
      int num = Integer.parseInt(temp[0]);
      int queries = Integer.parseInt(temp[1]);
      int [][] st = new int [num+1][16];
      int [][] st2 = new int [num+1][16];
      int [] array = new int [num+1];
      for (int x =1; x<= num; x++)
      {
        array[x] = Integer.parseInt(in.readLine());
        st[x][0] = array[x];
        st2[x][0] = array[x];
      }
      for (int q =1; q <= (int)(Math.log(num)/Math.log(2)); q++)
      {
        for (int c =1; c<= num; c++)
        {
          if ((c + (1<<(q-1))) <= num)
          {
          st[c][q] = Math.min(st[c][q-1], st[c + (1<<(q-1))][q-1]);
          
          st2[c][q] = Math.max(st2[c][q-1], st2[c + (1<<(q-1))][q-1]);  
         // System.out.print(st[c][q-1] +" " + st[c + (1<<(q-1))][q-1]+" ");
         // System.out.print(st[c][q] + " " + st2[c][q]);
          }
          else
            break;
         // System.out.println();
        }
      //  System.out.println();
      }
      for (int x =0; x< queries; x++)
      {
        temp = in.readLine().split(" ");
        int left = Integer.parseInt(temp[0]);
        int right = Integer.parseInt(temp[1]);
        int len = right - left + 1;
        int min = Math.min(st[left][(int)(Math.log(len)/Math.log(2))], st[right-(int)(1<<((int)(Math.log(len)/Math.log(2))))+1][(int)(Math.log(len)/Math.log(2))]);
        int max = Math.max(st2[left][(int)(Math.log(len)/Math.log(2))], st2[right-(int)(1<<((int)(Math.log(len)/Math.log(2))))+1][(int)(Math.log(len)/Math.log(2))]);
        System.out.println(max-min);
      }
      
      
   }
}