import java.util.Scanner;
public class l2_6{
    public static class Numbers {
        public String Dec(int n) {
            String s = "";
            switch (n) {
                case 2:
                    s = "twenty";
                    break;
                case 3:
                    s = "thirty";
                    break;
                case 4:
                    s = "forty";
                    break;
                case 5:
                    s = "fifty";
                    break;
                case 6:
                    s = "sixty";
                    break;
                case 7:
                    s = "seventy";
                    break;
                case 8:
                    s = "eighty";
                    break;
                case 9:
                    s = "ninety";
                    break;
            }
            return s;
        }

        public String Dec_Int(int n) {
            String s = "";
            switch (n) {
                case 0:
                    s = "";
                    break;
                case 1:
                    s = "one";
                    break;
                case 2:
                    s = "two";
                    break;
                case 3:
                    s = "three";
                    break;
                case 4:
                    s = "four";
                    break;
                case 5:
                    s = "five";
                    break;
                case 6:
                    s = "six";
                    break;
                case 7:
                    s = "seven";
                    break;
                case 8:
                    s = "eight";
                    break;
                case 9:
                    s = "nine";
                    break;
            }
            return s;
        }

        public String Dec_Int_moreTen(int n) {
            String s = "";
            switch (n) {
                case 10:
                    s = "ten";
                    break;
                case 11:
                    s = "eleven";
                    break;
                case 12:
                    s = "twelve";
                    break;
                case 13:
                    s = "thirteen";
                    break;
                case 14:
                    s = "fourteen";
                    break;
                case 15:
                    s = "fifteen";
                    break;
                case 16:
                    s = "sixteen";
                    break;
                case 17:
                    s = "seventeen";
                    break;
                case 18:
                    s = "eighteen";
                    break;
                case 19:
                    s = "nineteen";
                    break;
            }
            return s;
        }

        public String inWords(int number) {
            String res = "";
            int n1 = number % 10;
            int n4 = number / 1000;
            int n5 = n4 % 10;
            int n6 = n4 / 10;
            int n3 = (number - n4 * 1000) / 100;
            int n2 = ((number - n4 * 1000 - n3 * 100) / 10);
            //res=n6+" "+n5+" "+n3+" "+n2+" "+n1;
            if (n6 == 0&&n5!=0)
                res += Dec_Int(n5) + " ";
            if (n6 == 1)
                res += Dec_Int_moreTen(10 + n5) + " ";
            if (n6 > 1)
                res += Dec(n6) + " " + Dec_Int(n5) + " ";
            if (n6 == 0 && n5 == 1)
                res += "thousand ";
            else {
                if (n6 > 0)
                    res += "thousands ";
            }
            if (n3 != 0) {
                res += Dec_Int(n3) + " hundred";
                if (n2 > 0 || n1 > 0)
                    res += " [and] ";
            }
            if((n2>0||n1>0)&&(res.indexOf("hundred")==-1&&res.indexOf("thousand")>=0))
                res+="[and] ";
            if (n2 == 0)
                res += Dec_Int(n1) + " ";
            if (n2 == 1)
                res += Dec_Int_moreTen(10 + n1) + " ";
            if (n2 > 1)
                res += Dec(n2) + " " + Dec_Int(n1) + " ";
            return res;
        }
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        Numbers n=new Numbers();
        int res=s.nextInt();
        System.out.print(n.inWords(res));
    }
}
