package sis3.People;

import sis3.*;
import sis3.Objects.*;

import java.util.Scanner;

public class Admin extends Employee {
    public Admin(){
        super();
    }



    public void addUser(Object o){
        if(o instanceof Teacher){
            Teacher t=(Teacher)o;
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
        Data.save();
    }
    public void updateUserInfo(User o){
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
        Scanner inp=new Scanner(System.in);
        int a=inp.nextInt();
        switch(a){
            case 1:
                System.out.println("Name:");
                String n=inp.next();
                o.setName(n);
                System.out.println("Surname:");
                 n=inp.next();
                o.setSurname(n);;
                break;
            case 2:
                System.out.println("New password");
                String p=inp.next();
                o.setPassword(p);
                break;
            case 3:
                System.out.println("PhoneNumber");
                Employee e=(Employee)o;
                int ph=inp.nextInt();
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

}
