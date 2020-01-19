import java.io.*;
import java.util.*;

public class NotEnoughServers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        int rows= Integer.parseInt(temp[0]);
        int columns = Integer.parseInt(temp[1]);
        String [] origin = new String [(int) Math.round(Math.pow(2, 20))];
        int [] dp = new int [(int) Math.round(Math.pow(2, 20))];
        String [] values = new String [columns];
        int [] servers = new int [columns];
        int [] pass = new int [rows];
        String fin = "";
        for (int x =0; x < columns; x++)
        {
            values[x] = "";
        }
        for (int x= 0; x < rows; x++)
        {
            String temp1 = in.readLine();
            
            for (int y =0; y < columns; y++)
            {
                if (temp1.charAt(y) == 'X')
                {
                    values[y] += "1";
                    pass[x] = 1;
                }
                else
                {
                    values[y] += "0";
                }
            }
            fin += (pass[x]+"");
        }
        int [] indexes = new int [(int) Math.round(Math.pow(2, 20))];
        for (int x =0; x < columns; x++)
        {
            servers[x] = Integer.parseInt(values[x], 2);
            indexes[servers[x]] = x+1;
        }
        ArrayList<Integer> store = new ArrayList<Integer> ();
        HashSet<Integer> storeH = new HashSet<Integer> ();
        Arrays.fill(dp, 10000);
        //dp[0] = 0;
        for (int x = 0 ; x < columns; x++)
        {
            if (storeH.contains(servers[x]) == false)
            {
                store.add(servers[x]);
                storeH.add(servers[x]);
                
            }
            origin[servers[x]] = (indexes[servers[x]]+" ");
            dp[servers[x]] = 1;
            int h = store.size();
            for (int y =0; y < h; y++)
            {
                if (storeH.contains(servers[x]|store.get(y))==false)
                {
                    storeH.add(servers[x]|store.get(y));
                    store.add(servers[x]|store.get(y));
                   // origin[servers[x]|store.get(y)] = (x+"/");
                }
                if (dp[servers[x]|store.get(y)]> 1 + dp[store.get(y)])
                {
                  origin[servers[x]|store.get(y)] = (origin[servers[x]]+origin[store.get(y)]);
                  dp[servers[x]|store.get(y)] = Math.min(dp[servers[x]|store.get(y)], 1 + dp[store.get(y)]);
                }
            }
            
        }
        System.out.println (dp[Integer.parseInt(fin, 2)]);
        System.out.print(origin[Integer.parseInt(fin, 2)].substring(0,origin[Integer.parseInt(fin, 2)].length()-1) );
        
    }
}