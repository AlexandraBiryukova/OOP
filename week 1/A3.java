import java.util.Scanner;
public class A3 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a,a1;
        a=input.nextInt();
        a1=input.nextInt();
        for(int i=a;i<=a1;i++){
            if(i%2==0)
                System.out.printf("%d ",i);


        }

    }
}
