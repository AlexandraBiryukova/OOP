import java.util.Scanner;
public class A6 {
    public static int min(int a,int b,int c, int d){
        int minim=a;
        if(minim>b)
            minim=b;
        if(minim>c)
            minim=c;
        if(minim>d)
            minim=d;
        return minim;

    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int a,b,c,d;
        a=input.nextInt();
        b=input.nextInt();
        c=input.nextInt();
        d=input.nextInt();
        System.out.print(min(a,b,c,d));



    }

}
