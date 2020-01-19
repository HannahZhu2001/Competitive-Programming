import java.io.*;
import java.util.*;

public class Gates {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int gates = Integer.parseInt(in.readLine());
        int planes = Integer.parseInt(in.readLine());
        boolean [] visited = new boolean [gates+1];
        visited[0] = true;
        int [] prefered = new int[planes];
        int count =0;
        for (int x =0; x<planes; x++)
        {
            prefered[x] = Integer.parseInt(in.readLine());
            boolean finished = true;
            for (int i =prefered[x]; i >=0; i--)
            {
              if (visited[i]==false)
              {
                count++;
                visited[i] = true;
                finished = false;
                break;
              }
            }
            if (finished)
            {
              break;
            }
        }
//        long count = 0;
//        int gateStart = gates;
//        boolean finished = false;
//        for (int x = planes-1; x>= 0; x--)
//        {
//            for (int i =Math.min(gateStart, prefered[x]); i >=0; i--)
//            {
//              if (visited[i]==false)
//              {
//                count+=1;
//                gateStart = Math.min(gateStart--, prefered[x]--);
//                visited[i] = true;
//                break;
//              }
//            }
//        }
        System.out.print(count);
    }
}