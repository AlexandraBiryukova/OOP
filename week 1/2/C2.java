import java.util.Scanner;

public class C2 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int a, a1;
        a = input.nextInt();
        a1 = input.nextInt();
        if ((a ==1&& a1==1)||(a!=1&&a1!=1))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
