public class l3_4 {
    public static class Person{
        public String name;
        public Person(){
            name="someone";
        }
        public String getName(){
            System.out.println("Person name:"+name);
            return name;
        }

    }
    public static class Student extends Person{
        public Student(){
            super();
        }
        public String getName(){
            System.out.println("Student name:"+name);
            return name;
        }
    }
    public static class Employee extends Person{
        public Employee(){
            super();
        }
        public String getName(){
            System.out.println("Employee name:"+name);
            return name;
        }
    }

    public static void printInformation(Person p){
        p.getName();
    }
    public static void main(String[] args){
        Student studentObject = new Student();
        Employee employeeObject = new Employee();
        Person ref=studentObject;
        ref.getName();
        ref=employeeObject;
        ref.getName();
        printInformation( studentObject );
        printInformation( employeeObject );
    }
}
