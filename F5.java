import java.util.Scanner;
public class F5 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n,c=0;
        n=input.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++) {
            arr[i] = input.nextInt();
        }
        for(int i=1;i<n-1;i++){
            int min=arr[i-1],max=arr[i+1],cur=arr[i];
            if(max<cur&&cur>min)
                c++;


        }
        System.out.print(c);

    }



}





