import java.util.Scanner;
public class B4 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a,i=2;
        a=input.nextInt();
        while(i<=a){
            if(a%i==0) {
                System.out.print(i);
                return;
            }
            i++;



        }

    }
}


