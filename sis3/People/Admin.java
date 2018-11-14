package sis3.People;

import sis3.Driver;
import sis3.Enum.Departments;
import sis3.Enum.TeacherStatuses;
import sis3.Interfaces.ActionSaving;
import sis3.Objects.*;
import sis3.Storage.Data;

import java.awt.dnd.DragGestureEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

public class Admin extends Employee implements ActionSaving {
    public Admin(){
        super();
    }
    public Admin(String n,String s,String l,String p,String num,int year){
        super(n,s,l,p,num,year);
    }



    public void addUser(Object o){
        Scanner inp=new Scanner(System.in);
        String s="";
        if(o instanceof Teacher){
            Teacher t=(Teacher)o;
            System.out.print("Teacher's name:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format");
                System.out.print("Teacher's name:");
                s = inp.nextLine();
            }
            t.setName(s);
            System.out.print("Teacher's surname:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format");
                System.out.print("Teacher's surname:");
                s = inp.nextLine();
            }
            t.setSurname(s);
            System.out.print("Teacher's login:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format");
                System.out.print("Teacher's login:");
                s = inp.nextLine();
            }
            t.setLogin(s);
            System.out.print("Teacher's password:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format");
                System.out.print("Teacher's password:");
                s = inp.nextLine();
            }
            t.setPassword(s);
            System.out.println("Teacher's department:");
            System.out.println("1.FIT\n2.BS\n3.FGE\n4.CMC\n5.KMA\n6.FGOGI\n7.ISE\n8.NONE");
            int a=inp.nextInt();
            while(!(a>=1&&a<=8)){
                System.out.println("1.FIT\n2.BS\n3.FGE\n4.CMC\n5.KMA\n6.FGOGI\n7.ISE\n8.NONE");
                a=inp.nextInt();
            }
            for(Departments d:Departments.values() ){
                if(d.ordinal()==a-1){
                    t.setDepartment(d);
                    break;
                }
            }
            System.out.println("Teacher's status:");
            System.out.println("1.TUTOR\n2.LECTOR\n3.SENIOR_LECTOR\n4.PROFESSOR\n5.NONE");
            a=inp.nextInt();
            while(!(a>=1&&a<=5)){
                System.out.println("1.TUTOR\n2.LECTOR\n3.SENIOR_LECTOR\n4.PROFESSOR\n5.NONE");
                a=inp.nextInt();
            }
            for(TeacherStatuses tt:TeacherStatuses.values()){
                if(tt.ordinal()==a-1){
                    t.setStatus(tt);
                    break;
                }
            }

            this.Saving(" added new teacher "+t.getName()+" "+t.getSurname());
            t.save();



        }
        if(o instanceof Student){
            Student t=(Student)o;
            t.save();
        }
        if(o instanceof Manager){
            Manager t=(Manager)o;
            t.save();
        }
        if(o instanceof Executor){
            Executor t=(Executor)o;
            t.save();
        }
    }
    public void deleteUser(Object o){
        if(o instanceof Teacher){
            Teacher t=(Teacher)o;
            for (Course c:
                 Data.courses) {
                c.getTutors().remove(t);
            }
            Data.teachers.remove(t);
        }
        if(o instanceof Student){
            Student t=(Student)o;
            Data.students.remove(t);
            for(Course c:Data.courses){
                c.getStudents().remove(t);
            }
        }
        if(o instanceof Manager){
            Manager t=(Manager)o;
            Data.managers.remove(t);
        }
        if(o instanceof Executor){
            Executor t=(Executor) o;
            Data.executors.remove(t);
        }


    }
    public void updateUserInfo(User o){
        Scanner inp=new Scanner(System.in);
        String s1="You can:" +
                "1.Change the name\n"+
                "2.Change the password\n"+"3.Change the phone\n" +
                "4.Change the yearOfStudyOrWork\n";
        String s2="5.Change the department\n" +
                "6.Change the status\n";
        String s3="5.Change the department";
        String res="";
        if(o instanceof Teacher)
            res=s1+s2;
        if(o instanceof Student)
            res=s1+s3;
        System.out.println(res);
        System.out.println("Write the number of command");

        int a=inp.nextInt();
        switch(a){
            case 1:
                System.out.println("Name:");
                String n=inp.next();
                o.setName(n);
                System.out.println("Surname:");
                 n=inp.next();
                o.setSurname(n);
                break;
            case 2:
                System.out.println("New password");
                String p=inp.next();
                o.setPassword(p);
                break;
            case 3:
                System.out.println("PhoneNumber");
                Employee e=(Employee)o;
                String ph=inp.nextLine();
                e.setPhoneNumber(ph);
                break;
            case 4:
                System.out.println("YearOfStudyOrWork");
                int q=inp.nextInt();
                Employee ew=(Employee)o;
                ew.setYearOfWorkOrStudy(q);
                break;

        }

    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo(o);
    }

    @Override
    public int hashcode() {
        return super.hashcode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Admin t = (Admin) super.clone();
        t.setLogin(getLogin());
        t.setName(getName());
        t.setPassword(getPassword());
        t.setPhoneNumber(getPhoneNumber());
        t.setYearOfWorkOrStudy(getYearOfWorkOrStudy());
        t.setSurname(getSurname());
        return t;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public void Saving(String inf) {
        try {
            FileWriter to_file = new FileWriter("admins.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write(" admin "+this.getLogin()+inf+"\n");
            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
