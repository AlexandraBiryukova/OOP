public class l2_2 {
    public static class StarTriangle{
        public static String element="[*]";
        public int width;

        public StarTriangle(int w){
            width=w;
        }
        public String To_String(){
            String res="";
            for(int i=0;i<width;i++){
                for(int j=0;j<=i;j++){
                    res+=element;
                }
                res+="\n";
            }
            return res;
        }
    }
    public static void main(String[] args){
        StarTriangle s=new StarTriangle(5);

        System.out.println(s.To_String());
    }
}
