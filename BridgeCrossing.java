import java.io.*;
import java.util.*;

public class BridgeCrossing {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int group = Integer.parseInt(in.readLine());
        int peopleN = Integer.parseInt(in.readLine());
        int [] people = new int [peopleN+1];
        String [] name = new String [peopleN+1];
        int [] dp = new int [peopleN+1];
        int [] start = new int [peopleN+1];
        for (int x =1; x <= peopleN; x++)
        {
            name[x] = in.readLine();
            people[x] = Integer.parseInt(in.readLine());
        }
        for (int x = 1; x <=peopleN; x++)
        {
            dp[x] = dp[x-1]+ people[x];
            start[x] = x;
            for (int y = x-1; y > Math.max(0, x-group) ; y--)
            {
                int max= people[x];
                for (int c = x-1; c >= y; c--)
                {
                    max = Math.max(max, people[c]);
                }
                if (dp[x]> dp[y-1]+max)
                {
                    dp[x] = dp[y-1]+max;
                    start[x] = y;
                }
            }
        }
        ArrayList<String> output = new ArrayList<String>();
        System.out.println("Total Time: "+dp[peopleN]);
        int count = peopleN;
        int num = 0;
        while (count >= 1)
        {
            //count = start[count];
          output.add("");
            for (int x =count; x >= start[count]; x--)
            {
                output.set(num, output.get(num)+(name[x]+" "));
            }
            if (start[count] >= 1 && count !=1)
            {
            num++;
            }
            count = start[count]-1;
        }
        for (int x = 1; x <= output.size(); x++)
        {
          System.out.println(output.get(output.size()-x));
        }
    }
}