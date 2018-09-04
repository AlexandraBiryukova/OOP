import java.util.Scanner;
public class J {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int sum=0;
        for(int i=0;i<100;i++){
            int a=input.nextInt();
            sum+=a;
        }
        System.out.print(sum);

    }
}


