import java.util.Scanner;
public class D4 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a,i=1;
        a=input.nextInt();
        if(a==1) {
            System.out.print("YES");
            return;
        }
        while(i<a){
            i*=2;
            if(i==a) {
                System.out.print("YES");
                return;
            }

        }
        System.out.print("NO");


        }

    }



