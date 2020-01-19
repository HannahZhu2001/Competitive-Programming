import java.io.*;
import java.util.*;

public class Harvest {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        long k = Long.parseLong(temp[2]);
        int rows = Integer.parseInt(temp[0]);
        int columns = Integer.parseInt(temp[1]);
        long [] array = new long [(int)rows+1];
        //Arrays.fill(array, columns);
        //array[0] = 0;
        //int [] array1 = new int [rows+1];
        for (int x = 0; x < columns; x++)
        {
            String [] tokens = in.readLine().split(" ");
            int start = Integer.parseInt(tokens[0]);
            int fin = Integer.parseInt(tokens[1]);
            array[start]-=1;
            //System.out.print (start+" ");
            if (fin < rows)
            {
              array[fin+1]++;
            }
        }

        for (int r =1; r<= rows; r++)
        {
            array[r] += array[r-1];
        }
        for (int r =1; r<= rows; r++)
        {
          array[r] += columns;  
            array[r] += array[r-1];            
        }

        int min = 100000000;

        //if (array[0] > k)
        //{
        //    min = 1;
        //}
        //else
        //{
        int f = 0;
        for (int r= 1; r < rows; r++)
        {
            int s = r;
            if (array[s] - array[f] >= k)
            {
                for (int i = f+1; i <s; i++)
                {
                    if (array[s] - array[i-1] >= k)
                    {
                        f=i;
                    }
                    else
                    {
                      f = i-1;
                      break;
                    }
                }
                min = Math.min(min, s-f);
            }
        }
        if (min == 100000000)
        {
          System.out.print(-1);
        }
        else
        {
        System.out.print(min);
        }
    }
}