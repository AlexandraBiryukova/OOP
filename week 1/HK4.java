import java.util.Scanner;

public class HK4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        String[] ss=new String[3];
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int s=sc.nextInt();
            String x=Integer.toString(s);
            int s2=s1.length();
            if(x.length()!=3){
                if(x.length()==2){
                    x='0'+x;
                }

                else
                    x="00"+x;
            }
            for(int k=0;k<=14-s2;k++){
                s1=s1+' ';
            }
            ss[i]=s1+x;

            //Complete this line
        }
        for(int l=0;l<3;l++){
            System.out.print(ss[l]);
            for(int i=0;i<32-ss[l].length();i++){
                System.out.print(' ');
            }
            System.out.print('\n');
        }
        System.out.println("================================");

    }
}




