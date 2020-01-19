import java.io.*;
import java.util.*;

public class HappyTeachers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int teacherNum = Integer.parseInt(in.readLine());
        int [][] teachers = new int [teacherNum+1][3];
        for (int x =1; x<= teacherNum; x++)
        {
            String [] temp = in.readLine().split(" ");
            teachers [x][0] = Integer.parseInt(temp[0]);
            teachers [x][1] = Integer.parseInt(temp[1]);
            teachers [x][2] = Integer.parseInt(temp[2]);
        }
        int time = Integer.parseInt(in.readLine());
        int [][][] dp = new int [teacherNum+1][time+1][2];
        for (int x = 1; x <= teacherNum; x++)
        {
           // int happiness = teachers[x][0];
            for (int y =1; y <= teacherNum; y++)
            {
                dp[x][y][0] = dp[x-1][y][0];
                dp[x][y][1] = dp[x-1][y][1];
            }
            for (int y =1; teachers[x][0]-((y-1)*teachers[x][1])>0; y++)
            {
                for (int c = teachers[x][2]*y; c <= time; c++)
                {
                    if (dp[x][c][0]< dp[x][c-teachers[x][2]*y][0] + teachers[x][0]-((y-1)*teachers[x][1]))
                    {
                        dp[x][c][0] = dp[x][c-teachers[x][2]*y][0] + teachers[x][0]-((y-1)*teachers[x][1]);
                        dp[x][c][1] = dp[x][c-teachers[x][2]*y][1]+1;
                    }
                }
            }
        }
        System.out.println(dp[teacherNum][time][0]);
        System.out.print(dp[teacherNum][time][1]);
    }
}