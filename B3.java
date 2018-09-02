import java.util.Scanner;
public class B3 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a,b,c,d;
        a=input.nextInt();
        b=input.nextInt();
        c=input.nextInt();
        d=input.nextInt();

        for(int i=a;i<=b;i++){
            if(i%d==c)
                System.out.printf("%d ",i);


        }

    }
}
