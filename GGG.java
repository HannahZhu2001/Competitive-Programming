import java.io.*;
import java.util.*;

public class GGG {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int size1 = Integer.parseInt(in.readLine());
        String [] temp = in.readLine().split(" ");
        int [] list = new int[1000000];
        for (int x =0; x < size1; x++)
        {
            list[Integer.parseInt(temp[x])] = x+1;
        }
        int size2 = Integer.parseInt(in.readLine());
        ArrayList<Integer> lis = new ArrayList<Integer>();
        temp = in.readLine().split(" ");
       // int count = 1;
        
        lis.add(list[Integer.parseInt(temp[0])]);
        for (int x =1; x< size2; x++)
        {
            int hold = Integer.parseInt(temp[x]);
            if (list[hold] == 0 == false)
            {
             // System.out.println("v" + list[hold]);
            
                if (list[hold] > lis.get(lis.size()-1))
                {
                    lis.add(list[hold]);
                   // count++;
                }
                else
                {
                //  System.out.println((Arrays.binarySearch(lis,list[hold])+1)*(-1));
                    lis.set(-(Collections.binarySearch(lis,list[hold])+1), list[hold]);
                }
            }
        }
        System.out.print(lis.size());
    }
}