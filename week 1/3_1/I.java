import java.util.Scanner;
public class I {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a,c=1;
        a=input.nextInt();
        for(int i=2;i<=a;i++){
            if(a%i==0)
                c++;
        }
        System.out.print(c);

    }
}


