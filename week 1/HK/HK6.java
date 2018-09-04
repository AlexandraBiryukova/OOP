import java.util.*;
import java.io.*;

class HK6{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int[][] arr=new int[t][3];
        for(int i=0;i<t;i++){
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
            arr[i][2]=in.nextInt();
        }
        for(int i=0;i<t;i++){
            int res=arr[i][0];
            for(int k=1;k<=Math.pow(2,arr[i][2]-1);k*=2){
                res+=k*arr[i][1];
                System.out.print(res+" ");
            }
            System.out.println();
        }
        in.close();

    }
}