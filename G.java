import java.util.Scanner;
public class G {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a;
        a=input.nextInt();
        for(int i=2;i<=a;i++){
            if(a%i==0) {
                System.out.print(i);
                return;
            }



        }

    }
}


