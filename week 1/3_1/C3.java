import java.util.Scanner;
public class C3 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a,b;
        a=input.nextInt();
        b=input.nextInt();
        for(int i=a;i<=b;i++){
             double c=Math.sqrt((double)i);
             if((int)c*(int)c==i)
                System.out.printf("%d ",i);


        }

    }
}
