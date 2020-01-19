import java.io.*;
import java.util.*;

public class Surfing {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(in.readLine());
        HashMap<String, Integer> cites = new HashMap<String, Integer> ();
        int count = 0;
        List<Integer> [] list = new ArrayList[nodes+100];
        for(int x=0; x < nodes+100; x++)
        {
            list[x] = new ArrayList<Integer>();
        }
        for (int x =0 ; x < nodes; x++)
        {
            String temp = in.readLine();
            if (cites.containsKey(temp)== false)
            {
                cites.put(temp, count);
                count++;
            }
            String host = temp;
            temp = in.readLine();
            while (temp.equals("</HTML>")==false)
            {
                int start = 0;
                while (temp.indexOf("<A HREF=", start) !=-1)
                {
                    String web = temp.subString(temp.indexOf("<A HREF=", start)+8, temp.indexOf('"', start+8));
                    if(cites.containsKey(web)==false)
                    {
                        cites.put(web, count);
                        count++;
                    }
                    list[cites.get(host)].add(cites.get(web));
                    start = temp.indexOf('"', start+8);
                    System.out.println("Link from "+host+" to "+web);
                }
                temp = in.readLine();
            }
            
        }
        
    }
}