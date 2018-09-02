import java.util.Scanner;
public class E {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int a, a1;
        a = input.nextInt();
        a1 = input.nextInt();
        if (a*a1==0) {
            System.out.println(0);
            return;
        }
        if(a>0)
            System.out.println(a1*a%109);
        else
            System.out.println((109+((a1*a)%109))%109);


    }

}
