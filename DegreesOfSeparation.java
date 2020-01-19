import java.io.*;
import java.util.*;

public class DegreesOfSeparation {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> [] list = new ArrayList[51];
        for(int x=0; x <= 50; x++)
        {
             list[x] = new ArrayList<Integer>();
        }
        list[1].add(6);
        list[2].add(6);
        list[3].add(15);
        list[3].add(6);
        list[3].add(5);
        list[3].add(4);
        list[4].add(6);
        list[4].add(5);
        list[4].add(3);
        list[5].add(6);
        list[5].add(4);
        list[5].add(3);
        list[6].add(7);
        list[6].add(5);
        list[6].add(4);
        list[6].add(3);
        list[6].add(2);
        list[6].add(1);
        list[7].add(6);
        list[7].add(8);
        list[8].add(9);
        list[8].add(7);
        list[9].add(12);
        list[9].add(10);
        list[9].add(8);
        list[10].add(9);
        list[10].add(11);
        list[11].add(12);
        list[11].add(10);
        list[12].add(13);
        list[12].add(11);
        list[12].add(9);
        list[13].add(12);
        list[13].add(14);
        list[13].add(15);
        list[14].add(13);
        list[15].add(13);
        list[15].add(3);
        list[16].add(18);
        list[16].add(17);
        list[17].add(18);
        list[17].add(16);
        list[18].add(17);
        list[18].add(16);
        char command = in.readLine().charAt(0);
        while (command != 'q')
        {
          if (command == 'i')
          {
            int num1 = Integer.parseInt(in.readLine());
            int num2 = Integer.parseInt(in.readLine());
            boolean exsists = false;
            for (int x = 0; x < list[num1].size(); x++)
            {
              if (list[num1].get(x) == num2)
              {
                exsists = true;
              }
            }
            if (exsists == false)
            {
              list[num1].add(num2);
              list[num2].add(num1);
            }
          }
          else if (command == 'd')
          {
            int num1 = Integer.parseInt(in.readLine());
            int num2 = Integer.parseInt(in.readLine());
            for (int x = 0; x < list[num1].size(); x++)
            {
              if (list[num1].get(x) == num2)
              {
                list[num1].remove(x);
                break;
              }
            }
            for (int x = 0; x < list[num2].size(); x++)
            {
              if (list[num2].get(x) == num1)
              {
                list[num2].remove(x);
                break;
              }
            }
          }
          else if (command == 'n')
          {
            int num1 = Integer.parseInt(in.readLine());
            System.out.println (list[num1].size());
          }
          else if (command == 'f')
          {
            int num1 = Integer.parseInt(in.readLine());
            int count = 0;
            ArrayList<Integer> friends = new ArrayList<Integer> (list[num1]);
            friends.add(num1);
            for (int x = 0; x < list[num1].size(); x++)
            {
              for (int i = 0; i < list[list[num1].get(x)].size();i++)
              {
                if (friends.contains(list[list[num1].get(x)].get(i))==false)
                {
                  friends.add(list[list[num1].get(x)].get(i));
                  count++;
                }
              }
            
            }
            System.out.println (count);
          }
          else if (command == 's')
          {
            Queue<Integer> people = new LinkedList<Integer> ();
            Queue<Integer> degrees = new LinkedList<Integer> ();
            int num1 = Integer.parseInt(in.readLine());
            int num2 = Integer.parseInt(in.readLine());
            boolean [] visited = new boolean[51];
            people.add(num1);
            degrees.add(0);
            visited[num1] = true;
            boolean found = false;
            while (people.isEmpty()==false)
            {
              int check = people.poll();
              int degree = degrees.poll();
              visited[check] = true;
              if (check == num2)
              {
                System.out.println (degree);
                found =true;
                break;
              }
              else
              {
                for (int x =0; x < list[check].size(); x++)
                {
                  if (visited[list[check].get(x)] == false)
                  {
                  people.add(list[check].get(x));
                  degrees.add(degree+1);
                  }
                }
              }
            }
              if (found == false)
              {
                System.out.println ("Not connected");
              }
            }
          
          command = in.readLine().charAt(0);
        }
        
    }
}