import java.io.*;
import java.util.*;

public class BalancedTrees {
    static HashMap<Integer, Long> dp;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(in.readLine());
        dp = new HashMap<Integer, Long>();
        
        System.out.print(f(weight));
    }
    public static long f (int n)
    {
        if(n==1)
        {
            return 1;
        }
        if(dp.containsKey(n)&& dp.get(n) != 0)
        {
          return dp.get(n);
        }
        
        int k =n;
        int w ;//= n/k;
        dp.put(n,(long)0);
        int next;
        long answer = 0;
        while (k>=2)
        {
         
         w = n/k;
        next = n/(w+1);
        answer+= (k-next)*f(w);
         k = next;
        }
        dp.put(n, answer);
        return dp.get(n);
    }
}