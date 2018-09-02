import java.util.Scanner;
public class B {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int a, a1, a2;
        a = input.nextInt();
        a2 = a + 1;
        a1 = a - 1;
        System.out.printf("The next number for the number %d is %d.\n", a,a2);
        System.out.printf("The previous number for the number %d is %d.\n", a,a1);
    }


}
