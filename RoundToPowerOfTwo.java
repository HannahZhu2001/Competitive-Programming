import java.io.*;
import java.util.*;

public class RoundToPowerOfTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int x =0; x< 5; x++)
        {
            int num = Integer.parseInt(in.readLine());
            int close = 0;
            for(int y =0; y <=20; y++)
            {
                if (Math.abs(close-num)>= Math.abs((1<<y)-num))
                    close = 1<<y;
            }
            System.out.println(close);
        }
    }
}