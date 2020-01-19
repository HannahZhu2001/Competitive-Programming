import java.io.*;
import java.util.*;

public class OCanada {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int gridSize = Integer.parseInt(in.readLine());
        int gridsNum = Integer.parseInt(in.readLine());
        int [][][] grids = new int [gridSize][gridSize][gridsNum];
        for (int x = 0; x < gridsNum; x++)
        {
            for (int y =0; y < gridSize; y++)
            {
                String temp = in.readLine();
                for (int c =0; c < gridSize; c++)
                {
                    if (temp.charAt(c) == 'W')
                    {
                        grids[y][c][x] = 0;
                    }
                    else
                    {
                        grids[y][c][x] = 1;
                    }
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int x = 0; x < gridsNum; x++)
        {
            for (int y =0; y < gridSize-1; y++)
            {
                for (int c =0; c < gridSize-1; c++)
                {
                    if (grids[y][c][x] ==1)
                    {
                        grids[y][c][x] = 0;
                        grids[y][c+1][x] = grids[y][c+1][x]^1;
                        grids[y+1][c][x] = grids[y+1][c][x]^1;
                        grids[y+1][c+1][x] = grids[y+1][c+1][x]^1;
                    }
                }
            }
            String hold = "";
            for (int q = 0; q < gridSize; q++)
            {
                hold+=grids[gridSize-1][q][x];
            }
            for (int q = 0; q < gridSize; q++)
            {
                hold+=grids[q][gridSize-1][x];
            }
            int hold2 = Integer.parseInt(hold, 2);
            if (map.containsKey(hold2))
            {
                map.put(hold2, map.get(hold2)+1);
            }
            else
            {
                map.put(hold2, 1);
                arrayList.add(hold2);
            }
        }
        int fin = 0;
        for (int x =0; x< arrayList.size(); x++)
        {
            //if (map.get(arrayList.get(x))>=2)
            fin += map.get(arrayList.get(x))*(map.get(arrayList.get(x))-1)/2;
        }
        System.out.print(fin);
    }
}