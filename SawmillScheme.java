import java.io.*;
import java.util.*;

public class SawmillScheme {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        int nodes = Integer.parseInt(temp[0]);
        int rivers = Integer.parseInt(temp[1]);
        List<Integer>[] list = new ArrayList[nodes+1];
        for (int x =0; x<= nodes; x++)
        {
            list [x] = new ArrayList<Integer> ();
        }
        for (int x =0; x< rivers; x++)
        {
            temp = in.readLine().split(" ");
            int num1 = Integer.parseInt(temp[0]);
            int num2 = Integer.parseInt(temp[1]);
            list[Math.min(num1, num2)].add(Math.max(num1, num2));
        }
        double [] percentages = new double [nodes+1];
        percentages[1] = 1.00;
        for (int x =1; x <= nodes; x++)
        {
            if (list[x].size()>0)
            {
                for (int c = 0; c < list[x].size(); c++)
                {
                    percentages[list[x].get(c)] += (percentages[x]/list[x].size());
                }
                percentages[x] = -1;
            }
        }
        for (int x =1; x<=nodes; x++)
        {
            if (percentages[x] >0)
            {
              //String hold = (int)Math.round(percentages[x]*1000000000) +"";
               // System.out.println( "0." + hold);
                System.out.printf("%.9f\n", percentages[x]);
              //System.out.println(percentages[x]);
            }
        }
    }
}