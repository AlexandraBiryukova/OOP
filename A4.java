import java.util.Scanner;
public class A4 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a;
        a=input.nextInt();
        int i=1;
        while(i<=a){
            double c=Math.sqrt((double)i);
            if((int)c*(int)c==i)
                System.out.printf("%d ",i);
            i++;


        }

    }
}
