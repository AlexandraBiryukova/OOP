import java.util.Scanner;
public class Middle1 {

    public static void main(String[] args){
        class Player{
            String name;
            int score;
            Player(String name, int score){
                this.name=name;
                this.score=score;
            }

        }
         Scanner input=new Scanner(System.in);
         int n=input.nextInt();
         Player[] list=new Player[n];
         for(int i =0;i<n;i++){
             list[i]=new Player(input.next(),input.nextInt());
         }
         Player maxi;
        for(int k = 0; k < n; k++){
            for(int l = 0; l < n - k - 1; l++) {
                if (list[l].score > list[l + 1].score) {
                    maxi=list[l];
                    list[l]=list[l+1];
                    list[l+1]=maxi;
                }
            }
        }

        Player names;
        for(int k = 0; k < n; k++){
            for(int l = 0; l < n - k - 1; l++) {
                if (list[l].score == list[l + 1].score&&(int)list[l].name.charAt(0)<(int)list[l+1].name.charAt(0)) {
                    names=list[l];
                    list[l]=list[l+1];
                    list[l+1]=names;
                }
            }
        }

         for(int p=n-1;p>=0;p--){
             System.out.println(list[p].name+" "+Integer.toString(list[p].score));
         }
    }

}
