import java.util.Scanner;
public class A5 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n;
        n=input.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++) {
            arr[i] = input.nextInt();
        }
        for(int i=0;i<n;i++){
            if(arr[i]%2==0)
                System.out.print(arr[i]+" ");
        }


    }



}





