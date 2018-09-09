import java.util.Scanner;
public class l2_4 {
    public static class Time{
        public int hour;
        public int minute;
        public int second;

        public Time(int h,int m,int s){
            if(h>=0&&h<=23&&m>=0&&m<=59&&s>=0&&s<=59){
                hour=h;
                minute=m;
                second=s;
            }else
                System.out.println("INVALID INPUT");
        }
        public String toUniversal(){
            String res="";
            if(hour>=10)
                res=res+hour+":";
            else
                res=res+"0"+hour+":";
            if(minute>=10)
                res=res+minute+":";
            else
                res=res+"0"+minute+":";
            if(second>=10)
                res=res+second;
            else
                res=res+"0"+second;
            return res;

        }
        public String toStandard(){
            String res="";
            Boolean isAm=true;
            if(hour>=0&&hour<=10)
                res=res+"0"+hour+":";
            else{
                if(hour==11)
                    res=res+"11:";
                else {
                    if (hour - 12 <= 11)
                        res = res + (hour - 12) + ":";
                    else
                        res = res + "0" + (hour - 12) + ":";
                    isAm = false;
                }
            }
            if(minute>=10)
                res=res+minute+":";
            else
                res=res+"0"+minute+":";
            if(second>=10)
                res=res+second;
            else
                res=res+"0"+second;
            if(isAm)
                res+=" AM";
            else
                res+=" PM";
            return res;


        }
        public Time add(Time t1){
            second+=t1.second;
            if(second>59) {
                minute += second / 60;
                second%=60;
            }
            minute+=t1.minute;
            if(minute>59) {
                hour += minute / 60;
                minute%=60;
            }
            hour+=t1.hour;
            if(hour>23)
                hour=hour%24;
            return new Time(hour,minute,second);

        }
    }
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        Time t=new Time(Integer.parseInt(s.nextLine()),Integer.parseInt(s.nextLine()),Integer.parseInt(s.nextLine()));
        System.out.println(t.toUniversal());
        System.out.println(t.toStandard());
        Time t1=new Time(Integer.parseInt(s.nextLine()),Integer.parseInt(s.nextLine()),Integer.parseInt(s.nextLine()));
        System.out.println(t.add(t1).toUniversal());
    }
}
