import java.io.*;
import java.util.*;

public class LightsGoingOnAndOff {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(in.readLine());
        int columns = Integer.parseInt(in.readLine());
        //<Integer> [] sets = new HashSet<Integer> [rows];
        List<Integer> [] list = new ArrayList[rows];;
        for(int x=0; x< rows; x++)
        {
             list[x] = new ArrayList<Integer>();
        }

        int [] lights = new int [rows];
        for (int x =0; x< rows; x++)
        {
            String temp = in.readLine();
            lights[x] = Integer.parseInt(temp.replaceAll(" ", ""), 2);
            
        }
        list[0].add(lights[0]);
        for (int x =1; x<rows; x++)
        {
            list[x].add(lights[x]);
            for (int y =0; y < list[x-1].size(); y++)
            {
                list[x].add(list[x-1].get(y)^lights[x]);
                //System.out.println(list[x-1].get(y)^lights[x]);
            }
        }
        HashSet<Integer> set = new HashSet<Integer> (list[rows-1]);
        System.out.print(set.size());
    }
}