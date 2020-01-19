import java.io.*;
import java.util.*;

public class DeathGun {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(in.readLine());
        int count = 0;
        ArrayList<Integer> inEdges = new ArrayList<Integer>();
        ArrayList<String> equivalent = new ArrayList<String>();
        List<Integer> [] list = new ArrayList[people*2];
        for(int x=0; x < people*2; x++)
        {
             list[x] = new ArrayList<Integer>();
        }
        for (int x =0; x < people*2; x++)
        {
          inEdges.add(0);
        }
        for (int x = 0; x < people; x++)
        {
            String [] temp = in.readLine().split(" ");
            if (equivalent.contains(temp[0])==false)
            {
                equivalent.add(temp[0]);
                count ++;
            }
            if (equivalent.contains(temp[1])==false)
            {
                equivalent.add(temp[1]);
                count ++;
            }
            inEdges.set(equivalent.indexOf(temp[0]), inEdges.get(equivalent.indexOf(temp[0]))+1);
            list[equivalent.indexOf(temp[1])].add(equivalent.indexOf(temp[0]));
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean [] visited = new boolean [equivalent.size()];
        for (int x = 0; x < equivalent.size(); x++)
        {
            if (inEdges.get(x) == 0)
            {
                queue.add(x);
                visited[x] = true;
                break;
            }
        }
       // System.out.println(equivalent);
       // System.out.println(inEdges);
        
        while (queue.isEmpty() == false)
        {
            int hold = queue.poll();
            System.out.println(equivalent.get(hold));
            inEdges.set(hold, -1);
            for (int x = 0; x < list[hold].size(); x++)
            {
                
                    inEdges.set(list[hold].get(x), (inEdges.get(list[hold].get(x))-1));
                
            }
        for (int x =0; x < equivalent.size(); x++)
        {
          if (inEdges.get(x) ==0 && visited[x] == false)
                {
                    queue.add(x);
                    visited[x] = true;
                }
               
        }
        
    }
}
} 