import java.util.Vector;
public class l3_3 {
    public static class Person{
        private String name;
        public Person(){
            name="someone";
        }
        public Person(String s){
            name=s;
        }
        public void setName(String s){name=s;}
        public String getName(){return name;}
        public String toString(){
            return name;
        }
        public boolean equals(Object o){
            if(o instanceof Person) {
                Person p=(Person) o;
                if (p.name == name)
                    return true;
                return false;
            }
            return false;
        }
    }
    public static class Employee extends Person{
        private double salary;
        private int year;
        private String insuranceNumber="";
        public Employee(){
            super();
            salary=0;
            year=0;
        }
        public Employee(String s){
            super(s);
            salary=0;
            year=0;
        }
        public Employee(String s,double d){
            super(s);
            salary=d;
        }
        public Employee(String s,double d,int a){
            super(s);
            salary=d;
            year=a;
        }
        public Employee(String n,double d,int a,String s){
            super(n);
            salary=d;
            year=a;
            insuranceNumber=s;
        }
        public void setSalary(double s){salary=s;}
        public double getSalary(){return salary;}
        public void setYear(int s){year=s;}
        public int getYear(){return year;}
        public void setInsNum(String s){insuranceNumber=s;}
        public String getInsNum(){return insuranceNumber;}
        public String toString(){
            return "Name: "+getName()+", Salary: "+salary+", Year: "+year+", InsNum: "+insuranceNumber+";";}
        public boolean equals(Object o){
            if(o instanceof Employee) {
                Employee e=(Employee) o;
                if (super.equals((Person)e)) {
                    if (e.salary == salary) {
                        if (e.insuranceNumber.equals(insuranceNumber)) {
                            if (e.year == year)
                                return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }

    }
    public static class Manager extends Employee{
        private Vector team;
        private double bonus=0;
        public Manager(){
            super();
            team=new Vector();
        }
        public Manager(String n,double d,int a,String s,double b,Vector vec){
            super(n,d,a,s);
            bonus=b;
            team=vec;
            setSalary(getSalary()+team.size()*bonus);
        }
        public void setTeam(Vector vec){
            team=vec;
            setSalary(getSalary()+team.size()*bonus);

        }
        public String getTeam(){
            return team.toString();
        }
        public void setBonus(double a){
            bonus=a;
            setSalary(getSalary()+team.size()*bonus);
        }
        public double getBonus(){return bonus;}
        public String toString(){
            return super.toString()+"His employees: "+team.toString()+" with "+bonus+" bonus for each.";
        }
        public boolean equals(Object o){
            if(o instanceof Manager){
                Manager m=(Manager) o;
                if(super.equals((Employee)m)){
                    if(team==m.team){
                        if(bonus==m.bonus){
                            return true;
                        }

                    }
                }
                return false;
            }
            return false;
        }

    }
    public static class Test{
        public  void testing(){
            Employee e1=new Employee();
            e1.setName("Alex");
            e1.setSalary(100);
            e1.setInsNum("11A42D");
            e1.setYear(1);
            Employee e2=new Employee();
            e2.setName("Alex");
            e2.setSalary(100);
            e2.setInsNum("11A42D");
            e2.setYear(1);
            if(e1.equals(e2))
                System.out.println(e1.toString()+" EQUALS "+e2.toString());
            else
                System.out.println(e1.toString()+" DOESN'T EQUAL "+e2.toString());

            Person p1=new Person(e1.getName());
            Person p2=new Person(e2.getName());
            if(p1.equals(p2))
                System.out.println(p1.toString()+" EQUALS "+p2.toString());
            else
                System.out.println(p1.toString()+" DOESN'T EQUAL "+p2.toString());

            Vector v=new Vector();
            v.add(e1);
            Manager m1=new Manager("Dan",100,1,"A45",5,v);
            Employee e3=m1;
            Manager m2=(Manager)e3;
            System.out.println(m2.toString());
            v.add(e2);
            Manager m3=new Manager("Dan",100,1,"A45",5,v);
            if(m2.equals(m3))
                System.out.println(m2.toString()+"\nEQUAL\n"+m3.toString());
            else
                System.out.println(m2.toString()+"\nDOESN'T EQUAL\n"+m3.toString());
        }
    }
public static void main(String[] args){
        Test t=new Test();
        t.testing();

    }

}
