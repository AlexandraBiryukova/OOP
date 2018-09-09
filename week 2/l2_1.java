public class l2_1 {
    public static class Student{
        public String name;
        public int id;
        public int yearOfStudy;

        public Student(String s, int a){
            name=s;
            yearOfStudy=a;
        }
        public String get_name(){
            return name;
        }
        public int get_id(){
            return id;
        }
        public void set_name(String s){
            name=s;
        }
        public void set_id(int x){
            id=x;
        }
        public void incr_year(){
            yearOfStudy++;
        }
    }
    public static void main(String []args){
        Student s=new Student("Alex",2018);
        s.id=1;
        System.out.println(s.get_id());
        System.out.println(s.get_name());
        s.incr_year();
        System.out.println(s.yearOfStudy);
    }
}
