import java.util.Scanner;

public class A2 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int a, a1;
        a = input.nextInt();
        a1 = input.nextInt();
        if (a > a1)
            System.out.println(a);
        else
            System.out.println(a1);
    }

}
