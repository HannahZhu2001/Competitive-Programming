import java.io.*;
import java.util.*;

public class PyramidMessageScheme {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       // String [] temp = in.readLine().split(" ");
        int times = Integer.parseInt(in.readLine());
        for (int x =0; x< times; x++)
        {
            int lines = Integer.parseInt(in.readLine());
            String [] places = new String [lines+1];
            int distance = 0;
            int count = 0;
            places [0] = "temp";
            for (int i = 1; i <= lines; i++)
            {
                places[i] = in.readLine();
            }
            places[0] = places[lines];
            String [] hold = new String [lines+1];
            hold[0] = "";
            hold[1] = places[0];
            count = 1;
            for (int i =lines-1; i >= 0; i--)
            {
                if (places[i].equals(hold[count-1]))
                {
                    count--;
                }
                else
                {
                    hold[count+1] = places[i];
                    count++;
                    distance = Math.max(count, distance);
                }
            }
            distance--;
            System.out.println((lines-distance*2)*10);
        }
        

    }
}