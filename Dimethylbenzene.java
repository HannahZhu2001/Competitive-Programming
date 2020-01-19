import java.io.*;
import java.util.*;

public class Dimethylbenzene {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = in.readLine().split(" ");
        int nodes = Integer.parseInt(temp[0]);
        int roads = Integer.parseInt(temp[1]);
        List<Integer> [] list = new ArrayList[nodes+1];
        for(int x=0; x <= nodes; x++)
        {
             list[x] = new ArrayList<Integer>();
        }
        for (int x = 0; x < roads; x++)
        {
            temp = in.readLine().split(" ");
            int first = Integer.parseInt(temp[0]);
            int second = Integer.parseInt(temp[1]);
            list[first].add(second);
            list[second].add(first);
        }
        
    }
}