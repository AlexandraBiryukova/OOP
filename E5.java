import java.util.Scanner;
public class E5 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n,c=0;
        n=input.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++) {
            arr[i] = input.nextInt();
        }
        for(int i=0;i<n-1;i++){
            int min=arr[i],max=arr[i+1];
            if(max*min>0){
                System.out.print("YES");
                return;
            }

        }
        System.out.print("NO");

    }




}





