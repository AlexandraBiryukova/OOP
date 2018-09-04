import java.util.Scanner;
public class B6 {
    public static float power(float a,int b){
        float res=a;
        int p=1;
        if(b==0)
            return 1;
        while(p<b){
            res*=a;
            p++;
        }
        return res;

    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        float a;
        int b;
        a=input.nextFloat();
        b=input.nextInt();

        System.out.print(power(a,b));



    }

}
