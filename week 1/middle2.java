import java.util.Scanner;
public class middle2 {

    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        String res="";
        input.nextLine();
        while(n>0){
            String s=input.nextLine();
            n--;
            String[] ss=s.split(" ");
            res+=ss[0]+" ";
            for(int i=1;i<ss.length;i++){
                if(!ss[i].toLowerCase().equals(ss[i-1].toLowerCase()))
                    res+=ss[i]+" ";

            }
            res+="\n";


        }
        System.out.print(res);
    }
}