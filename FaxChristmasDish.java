import java.io.*;
import java.util.*;

public class FaxChristmasDish {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        int nodes = Integer.parseInt(temp[0]);
        int recipies = Integer.parseInt(temp[1]);
        int days = Integer.parseInt(temp[2]);
        
        List<Integer> [] list = new ArrayList[nodes+1];;
        boolean [] visited = new boolean [nodes+1];
        for(int x=0; x<= nodes; x++)
        {
             list[x] = new ArrayList<Integer>();
        }
        int [] from = new int [nodes+1];
        //boolean [] visited = new boolean [nodes+1];
        for (int x=0; x< recipies; x++)
        {
            temp = in.readLine().split(" ");
            int current = Integer.parseInt(temp[0]);
            int size = Integer.parseInt(temp[1]);
            for (int y=0; y<size; y++)
            {
                list[current].add(Integer.parseInt(temp[2+y]));
                from[Integer.parseInt(temp[2+y])]= current;
            }
        }
        int minDays = -1;
        temp = in.readLine().split(" ");
        for (int x=1; x <=days; x++)
        {
            int dish = Integer.parseInt(temp[x-1]);
            
           // System.out.println();
            while (from[dish] != 0)
            {
              //System.out.println(from[dish]);
             // System.out.println(x+"h" + from[dish]);
                list[from[dish]].remove(list[from[dish]].indexOf(dish));
                int hold = dish;
                if (list[from[dish]].size() ==0 && from[dish] !=0)
                {
                  
                    dish= from[dish];
                    from[hold] =0;
                }
                else
                {
                  from[hold] =0;
                    break;
                }
            }
            if (list[1].size() ==0)
            {
                minDays = x;
                break;
            }
        
            
        }
        System.out.print(minDays);
    }
}