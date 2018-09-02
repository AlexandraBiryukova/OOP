import java.util.Scanner;
public class G5 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n,c=0;
        n=input.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++) {
            arr[i] = input.nextInt();
        }
        int nn=n-1;
        for(int i=0;i<n/2;i++){
            int cc=arr[i];
            arr[i]=arr[nn];
            arr[nn]=cc;
            nn--;

        }
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }



    }



}





