import java.util.Scanner;
public class K {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int b=input.nextInt();
        int sum=0;
        for(int i=0;i<b;i++){
            int a=input.nextInt();
            sum+=a;
        }
        System.out.print(sum);

    }
}


