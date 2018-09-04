import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HK7 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        String list="1 "+s.nextLine()+"\n";
        int i=1;
        while(s.hasNextLine()){
            String ss=s.nextLine();
            list+=Integer.toString(i+1)+" "+ss+"\n";
            i++;

        }
        System.out.println(list);

    }
}