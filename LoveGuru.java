import java.io.*;
import java.util.*;

public class LoveGuru {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String name1 = in.readLine();
        String name2 = in.readLine();
        name1 = name1.toUpperCase();
        name2 = name2.toUpperCase();
        long total1 =0;
        long total2 = 0;
        for (int x =0; x < name1.length(); x++)
        {
            total1 += (Math.pow(name1.charAt(x)-64, x%4+1))%10;
            //System.out.println (total1);
        }
        for (int x =0; x < name2.length(); x++)
        {
          //System.out.println  ((Math.pow(name2.charAt(x)-64, x%4+1))%10);
          
            total2 += (Math.pow(name2.charAt(x)-64, x%4+1))%10;
            //System.out.println (total2);
        }
        System.out.println (total1);
        System.out.println(total2);
        total1 = (total1-1)%10 +1;
        total2 = (total2-1)%10 +1;
        System.out.println (total1);
        System.out.println(total2);
        System.out.print(total1+total2);
    }
}