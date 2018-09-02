import java.util.Scanner;
public class M {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int b=input.nextInt();
        int sum=0;
        for(int i=0;i<b;i++){
            int a=input.nextInt();
            if(a==0)
                sum++;
        }
        System.out.print(sum);

    }
}


