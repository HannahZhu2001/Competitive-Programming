import java.io.*;
import java.util.*;

public class PrefixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        while (true)
        {
            String [] temp = in.readLine().split(" ");
            if (temp[0].equals("0")==true)
                break;
            Stack<String> stack = new Stack<String>();
            for(int x = temp.length-1; x >=0; x--)
            {
                if (temp[x].equals("+")==false && temp[x].equals("-")==false)
                {
                    stack.push(temp[x]+"");
                }
                else
                {
                    String one = stack.pop();
                    String two = stack.pop();
                    stack.push(one+""+two+""+temp[x]+"");
                }
            }
            String fin = stack.pop();
            for (int x = 0; x < temp.length; x++)
            {
                System.out.print(fin.charAt(x)+ " ");
            }
            System.out.println();
        }
    }
}