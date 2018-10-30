package week9.third;
import java.util.Date;

public class Employee extends Person implements Comparable,Cloneable {
    private double salary;
    private Date hireDate;
    private String insuranceNumber="";
    public Employee(){
        super();
        salary=0;
        hireDate=new Date(0,0,0);
    }
    public Employee(String s){
        super(s);
        salary=0;
        hireDate=new Date(0,0,0);
    }
    public Employee(String s,double d){
        super(s);
        salary=d;
    }
    public Employee(String s,double d,Date a){
        super(s);
        salary=d;
        hireDate=a;
    }
    public Employee(String n,double d,Date a,String s){
        super(n);
        salary=d;
        hireDate=a;
        insuranceNumber=s;
    }
    public void setSalary(double s){salary=s;}
    public double getSalary(){return salary;}
    public void setDate(Date s){hireDate=s;}
    public Date getDate(){return hireDate;}
    public void setInsNum(String s){insuranceNumber=s;}
    public String getInsNum(){return insuranceNumber;}
    public String toString(){
        return "Name: "+getName()+", Salary: "+salary+", Date: "+hireDate+", InsNum: "+insuranceNumber+";";}
    public boolean equals(Object o){
        if(o instanceof Employee) {
            Employee e=(Employee) o;
            if (super.equals((Person)e)) {
                if (e.getSalary() == salary) {
                    if (e.getInsNum().equals(insuranceNumber)) {
                        if (e.getDate() == hireDate)
                            return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e=(Employee)o;
            if(e.salary>salary)
                return -1;
            if(e.salary<salary)
                return 1;
            return 0;
        }
        return 0;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee e=new Employee();
//
        String s=new String(this.getName());
        e.setName(s);
        double d=new Double(this.salary);
        e.salary=d;
        String i=new String(this.insuranceNumber);
        e.insuranceNumber=i;
        Date da=this.hireDate;
        e.hireDate=da;
        return e;
//        return super.clone();

    }
}

