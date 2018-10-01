import java.util.Scanner;
public class l2_3 {
    public static class Data{
        private static double average;
        private static double maxim;
        private static int count;
        public Data(){
            average=0;
            count=0;
            maxim=0;
        }
        public void addData(double x){
            count++;
            if(maxim<x)
                maxim=x;
            average+=x;
        }
        public double average(){
            if(count==0)
                return 0;
            return average/count;
        }
        public double maximum(){
            return maxim;
        }

    }
    public static class Analyzer {
        public static void test() {
            Scanner s = new Scanner(System.in);
            String str="";
            Data d = new Data();
            System.out.print("Enter number(Q to quit):");
            str = s.nextLine();
            while (!str.equals("Q")) {
                double x = Double.parseDouble(str);
                d.addData(x);
                System.out.print("Enter number(Q to quit):");
                str = s.nextLine();
            }
            System.out.println("Average: " + d.average());
            System.out.println("Maximum: " + d.maximum());

        }
    }
    public static void main(String[] args){
        Analyzer.test();
    }
}
