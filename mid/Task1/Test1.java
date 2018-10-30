package mid.Task1;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Sequence s=new Sequence(input.next());
        if(s.isPalindrome())
            System.out.println("YES");
        else
            System.out.println("NO");
        Sequence s2=new Sequence(input.next());
        if(s.isSubString(s2))
            System.out.println("Is a SUB");
        else
            System.out.println("Is not a SUB");
    }

}
