import java.util.Scanner;
public class C5 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n,c=0;
        n=input.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++) {
            arr[i] = input.nextInt();
        }
        for(int i=0;i<n;i++){
            if(arr[i]>0)
                c++;

        }
        System.out.print(c);

    }



}





