import java.util.Scanner;

import static java.lang.Math.sqrt;

public class A {
    public static void main(String [] args) {
        float a, b;
        double c;
        Scanner input = new Scanner(System.in);
        a=input.nextInt();
        b=input.nextInt();
        c=Math.sqrt(a*a+b*b);
        System.out.print(c);
    }


}
