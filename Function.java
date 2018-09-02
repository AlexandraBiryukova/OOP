import java.util.Scanner;
public class Function {
    public static char UpperCase(char s){
        if((int)s>=97&&(int)s<=122){
            int res=(int)s-32;
            s=(char)res;
        }
        return s;
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String word=s.next();
        for(int i=0;i<word.length();i++){
            char c=UpperCase(word.charAt(i));
            System.out.print(c);

        }

    }
}
