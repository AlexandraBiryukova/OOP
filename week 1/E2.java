import java.util.Scanner;

public class E2 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int a,a1;
        a = input.nextInt();
        a1=input.nextInt();
        if (a > a1)
            System.out.println(1);
        if (a < a1)
            System.out.println(2);
        if (a == a1)
            System.out.println(0);
    }

}
