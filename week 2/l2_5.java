import java.util.*;
public class l2_5 {
    public static class Tester {
        public  int[] biArr(int[] a) {
            int[] aa = new int[a.length * 2];
            int i = 0;
            for (int j = 0; j < aa.length; j++) {
                aa[j] = a[i];
                if (j % 2 == 1)
                    i++;
            }
            return aa;
        }
    }
    public static void main(String [] args){
        Tester t=new Tester();
        int[] n=new int[4];
        for(int j=0;j<4;j++){
            n[j]=j+1;
        }
        int[] nn = t.biArr(n);
        for(int i=0;i<nn.length;i++){
            System.out.print(nn[i]+" ");
        }
    }
}
