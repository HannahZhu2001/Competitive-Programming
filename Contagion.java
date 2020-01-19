import java.io.*;
import java.util.*;

public class Contagion {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int countries = Integer.parseInt(in.readLine());
        long [][] edges = new long [countries+1][countries+1];
        long [] distance = new long [countries+1];
        int [][] xy = new int [countries+1][2];
        boolean [] visited = new boolean [countries+1];
        //Arrays.fill (distance, 100000000);
        for (int x =1; x <= countries; x++)
        {
            String [] temp = in.readLine().split(" ");
            xy[x][0] = Integer.parseInt(temp[0]);
            xy[x][1] = Integer.parseInt(temp[1]);
        }
        for (int r = 1; r <= countries; r++)
        {
            for (int c = 1; c<=countries; c++)
            {
                edges[r][c] = (long)(xy[r][0]-xy[c][0])*(xy[r][0]-xy[c][0])+(xy[r][1]-xy[c][1])*(xy[r][1]-xy[c][1]);
            }
        }
        int start = Integer.parseInt(in.readLine());
        distance[start] = 0;
        visited[start] = true;
        for (int x = 1; x<= countries; x++)
        {
            distance[x] = edges[start][x];
        }
        while(true)
        {
            visited[start] = true;
            boolean found = false;
            int min = 0;
            for (int x= 1; x <= countries; x++)
            {
                if (visited[x] == false && (distance[start] + edges[start][x]) < distance[x])
                {
                    distance[x] = distance[start] + edges[start][x];
                    
                }
            }
                for (int x =1; x <= countries; x++)
                {
                    if (found == true && distance[x] < distance[min] && visited[x] == false)
                    {
                        min = x;
                    }
                    else if (found == false && visited[x] == false)
                    {
                        min = x; 
                        found = true;
                    }
                }
                if (found)
            start = min;
            else
            break;
            
        }
        Arrays.sort(distance);
        int queries = Integer.parseInt(in.readLine());
//        for (int x =1; x<= countries; x++)
//        {
//          System.out.println(distance[x]);
//        }
        for (int x =0; x<queries; x++)
        {
            long time = Long.parseLong(in.readLine());
            int left= 0;
            int right = distance.length-1;
            int middle;
            int key = 0;
            while (left<=right)
            {
                middle = (int)Math.ceil((left + right)/2);
                //System.out.println(middle);
                if (distance[middle] == time || (distance[middle] < time && middle < distance.length-1 && distance[middle+1] > time))
                {
                 // System.out.println ("found");
                    key = middle;
                    while (key < distance.length-1 && distance[key+1] <= time)
                    {
                      key++;
                    }
                    break;
                }
                else if (distance [middle] < time )
                {
                    left = middle +1;
                }
                else
                {
                    right = middle-1;
                }
            }
            System.out.println(key);
        }
    }
}