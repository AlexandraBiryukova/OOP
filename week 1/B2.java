import java.util.Scanner;

public class B2 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int a;
        a = input.nextInt();
        if (a%400==0||(a%4==0&&a%100!=0))
            System.out.println("YES");
        else
            System.out.println("NO");


    }

}
