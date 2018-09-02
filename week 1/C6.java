import java.util.Scanner;
public class C6 {
    public static boolean XOR(int a,int b){
        boolean res=true;
        if(a+b!=1)
            res=false;

        return res;

    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int  a,b;
        a=input.nextInt();
        b=input.nextInt();
        if(XOR(a,b)==true)
            System.out.print(1);
        else
            System.out.print(0);





    }

}

