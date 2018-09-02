import java.util.Scanner;
public class C4 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a,i=0;
        a=input.nextInt();
        while(Math.pow(2,i)<=a){
            System.out.print((int)Math.pow(2,i)+" ");
            i++;



        }

    }
}


