import java.util.Scanner;

public class HK3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String i = scan.next();
        int ii=Integer.parseInt(i);
        double d= scan.nextDouble();
        scan.nextLine();
        String s=scan.nextLine();

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + ii);
    }
}