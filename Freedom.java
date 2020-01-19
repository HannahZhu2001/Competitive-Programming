import java.io.*;
import java.util.*;

public class Freedom {
    
    public static long GCD (long m, long n)
    {
        if (n==0)
        {
            return m;
        }
        else 
        {
            return GCD(n, m%n);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> store = new HashSet<String>();
        String [] ship = in.readLine().split(" ");
        long shipX = Long.parseLong(ship[0]);
        long shipY = Long.parseLong(ship[1]);
        long shipZ = Long.parseLong(ship[2]);
        int enemy = Integer.parseInt(in.readLine());
        for (int i = 0; i< enemy; i++ )
        {
            String [] temp = in.readLine().split(" ");
            long x = Math.abs(Long.parseLong(temp[0])-shipX);
            long y = Math.abs(Long.parseLong(temp[1])-shipY);
            long z = Math.abs(Long.parseLong(temp[2])-shipZ);
            long div = GCD(GCD(x, y), z);
           
            store.add((Long.parseLong(temp[0])-shipX)/div + "/" + (Long.parseLong(temp[1])-shipY)/div+" "+(Long.parseLong(temp[2])-shipZ)/div);
        }
        System.out.print(store.size());
    }
}