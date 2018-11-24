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

public class Admin extends Employee{
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
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Teacher's name:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setName(s);
            System.out.print("Teacher's surname:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Teacher's surname:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setSurname(s);
            System.out.print("Teacher's login:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Teacher's login:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setLogin(s);
            System.out.print("Teacher's password:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Teacher's password:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setPassword(s);
            System.out.print("Teacher's phone number:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Teacher's phone number:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setPhoneNumber(s);
            System.out.print("Teacher's year of work:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Teacher's year of work:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setYearOfWorkOrStudy(Integer.parseInt(s));
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
            t.save(" is added to the system ");

        }
        if(o instanceof Student){
            Student t=(Student)o;
            System.out.print("Student's name:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Student's name:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setName(s);
            System.out.print("Student's surname:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Student's surname:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setSurname(s);
            System.out.print("Student's login:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Student's login:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setLogin(s);
            System.out.print("Student's password:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Student's password:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setPassword(s);
            System.out.print("Student's phone number:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Student's phone number:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setPhoneNumber(s);
            System.out.print("Student's year of study:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Student's year of study:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setYearOfWorkOrStudy(Integer.parseInt(s));
            System.out.println("Student's department:");
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
            this.Saving(" added new student "+t.getName()+" "+t.getSurname());
            t.save(" is added to the system ");
        }
        if(o instanceof Manager){
            Manager t=(Manager)o;
            System.out.print("Manager's name:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Manager's name:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setName(s);
            System.out.print("Manager's surname:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Manager's surname:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setSurname(s);
            System.out.print("Manager's login:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Manager's login:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setLogin(s);
            System.out.print("Manager's password:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Manger's password:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setPassword(s);
            System.out.print("Manager's phone number:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Manager's phone number:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setPhoneNumber(s);
            System.out.print("Manager's year of work:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Manager's year of work:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setYearOfWorkOrStudy(Integer.parseInt(s));
            this.Saving(" added new manager "+t.getName()+" "+t.getSurname());
            t.save(" is added to the system ");
        }
        if(o instanceof Executor){
            Executor t=(Executor)o;
            System.out.print("Executor's name:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Executor's name:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setName(s);
            System.out.print("Executor's surname:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Executor's surname:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setSurname(s);
            System.out.print("Executor's login:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Executor's login:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setLogin(s);
            System.out.print("Executor's password:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Executor's password:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setPassword(s);
            System.out.print("Executor's phone number:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Executor's phone number:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setPhoneNumber(s);
            System.out.print("Executor's year of work:");
            s=inp.nextLine();
            while(s.isEmpty()) {
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                System.out.print("Executor's year of work:");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            t.setYearOfWorkOrStudy(Integer.parseInt(s));
            this.Saving(" added new executor "+t.getName()+" "+t.getSurname());
            t.save(" is added to the system ");
        }
        Data.save();
    }
    public void deleteUser(Object o){
        Scanner inp=new Scanner(System.in);
        if(o instanceof Teacher){
            if(Data.teachers.size()>0) {
                for (Teacher t : Data.teachers) {
                    System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname());
                }
                System.out.println("Choose the login of teacher you want to delete:");
                boolean found = false;
                while (!found) {
                    System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                    String s = inp.nextLine();
                    while (s.isEmpty()) {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                        s = inp.nextLine();
                    }
                    if (s.toLowerCase().equals("exit"))
                        return;
                    boolean b = false;
                    for (Teacher t : Data.teachers) {
                        if (t.getLogin().equals(s)) {
                            this.Saving(" deleted teacher " + t.getLogin());
                            t.save(" is deleted from to system ");
                            b = true;
                            break;
                        }
                    }
                    if (b)
                        found = true;
                    else {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    }
                }
            }else{
                System.out.println("There are no registered teachers in the system");
            }
        }
        if(o instanceof Student){
            if(Data.students.size()>0) {
                for (Student t : Data.students) {
                    System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname());
                }
                System.out.println("Choose the login of student you want to delete:");
                boolean found = false;
                while (!found) {
                    System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                    String s = inp.nextLine();
                    while (s.isEmpty()) {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                        s = inp.nextLine();
                    }
                    if (s.toLowerCase().equals("exit"))
                        return;
                    boolean b = false;
                    for (Student t : Data.students) {
                        if (t.getLogin().equals(s)) {
                            this.Saving(" deleted student " + t.getLogin());
                            t.save(" is deleted from to system ");
                            b = true;
                            break;
                        }
                    }
                    if (b)
                        found = true;
                    else {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    }
                }
            }else{
                System.out.println("There are no registered students in the system");
            }
        }
        if(o instanceof Manager){
            if(Data.managers.size()>0) {
                for (Manager t : Data.managers) {
                    System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname());
                }
                System.out.println("Choose the login of manager you want to delete:");
                boolean found = false;
                while (!found) {
                    System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                    String s = inp.nextLine();
                    while (s.isEmpty()) {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                        s = inp.nextLine();
                    }
                    if (s.toLowerCase().equals("exit"))
                        return;
                    boolean b = false;
                    for (Manager t : Data.managers) {
                        if (t.getLogin().equals(s)) {
                            this.Saving(" deleted manager " + t.getLogin());
                            t.save(" is deleted from to system ");
                            b = true;
                            break;
                        }
                    }
                    if (b)
                        found = true;
                    else {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    }
                }
            }else{
                System.out.println("There are no registered managers in the system");
            }
        }
        if(o instanceof Executor){
            if(Data.executors.size()>0) {
                for (Executor t : Data.executors) {
                    System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname());
                }
                System.out.println("Choose the login of executor you want to delete:");
                boolean found = false;
                while (!found) {
                    System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                    String s = inp.nextLine();
                    while (s.isEmpty()) {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                        s = inp.nextLine();
                    }
                    if (s.toLowerCase().equals("exit"))
                        return;
                    boolean b = false;
                    for (Executor t : Data.executors) {
                        if (t.getLogin().equals(s)) {
                            this.Saving(" deleted executor " + t.getLogin());
                            t.save(" is deleted from to system ");
                            b = true;
                            break;
                        }
                    }
                    if (b)
                        found = true;
                    else {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    }
                }
            }else{
                System.out.println("There are no registered executors in the system");
            }
        }
        Data.save();


    }
    public void updateUserInfo(Object o){
        Scanner inp=new Scanner(System.in);
        if(o instanceof Teacher){
            if(Data.teachers.size()>0) {
                for (Teacher t : Data.teachers) {
                    System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname()+" "+t.getPhoneNumber());
                }
                System.out.println("Choose the login of teacher,\nwhose information you want to change:");
                boolean found = false;
                while (!found) {
                    System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                    String ss = inp.nextLine();
                    while (ss.isEmpty() && !ss.toLowerCase().equals("exit")) {
                        ss = inp.nextLine();

                        if (ss.isEmpty()) {
                            System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                            System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                        }
                    }
                    if (ss.toLowerCase().equals("exit"))
                        return;
                    boolean b = false;
                    for (Teacher t : Data.teachers) {
                        if (t.getLogin().equals(ss)) {
                            System.out.println(t);
                            System.out.println("Choose the code of information" +
                                    "\nyou want to change:\n1. NAME\n2. SURNAME\n3. PHONE NUMBER\n4. 𝗘𝗫𝗜𝗧");
                            System.out.print("𝖢𝖮𝖣𝖤:");
                            String s = inp.nextLine();
                            while (s.isEmpty()) {
                                System.out.print("𝖢𝖮𝖣𝖤:");
                                s = inp.nextLine();
                            }
                            int a = Integer.parseInt(s);
                            while (a != 1 && a != 2 && a != 3 && a != 4 && a != 5) {
                                System.out.print("𝖢𝖮𝖣𝖤:");
                                s = inp.nextLine();
                                a = Integer.parseInt(s);
                            }
                            b = false;
                            //Admin i=new Admin();
                            switch (a) {
                                case 1:
                                    System.out.println("𝖭𝖤𝖶 𝖭𝖠𝖬𝖤: ");
                                    String q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖭𝖠𝖬𝖤: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF NAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setName(q);
                                    this.Saving(" changed info about teacher " + t.getLogin());
                                    t.save("name was changed");
                                    updateUserInfo(o);
                                    break;
                                case 2:
                                    System.out.println("𝖭𝖤𝖶 𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
                                    q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF SURNAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setSurname(q);
                                    this.Saving(" changed info about teacher " + t.getLogin());
                                    t.save("surname was changed");

                                    updateUserInfo(o);
                                    break;
                                case 3:
                                    System.out.println("𝖭𝖤𝖶 𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
                                    q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF NUMBER\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setPhoneNumber(q);
                                    this.Saving(" changed info about teacher " + t.getLogin());
                                    t.save("phone number was changed");

                                    ;
                                    updateUserInfo(o);

                                    break;

                                case 4:
                                    return;
                            }
                            b = true;
                            break;
                        }
                    }
                    if (b)
                        found = true;
                    else {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    }
                }
            }else{
                System.out.println("There are no registered teachers in the system");
            }
        }
        if(o instanceof Student){
            if(Data.students.size()>0) {
                for (Student t : Data.students) {
                    System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname()+" "+t.getPhoneNumber());
                }
                System.out.println("Choose the login of student,\nwhose information you want to change:");
                boolean found = false;
                while (!found) {
                    System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                    String ss = inp.nextLine();
                    while (ss.isEmpty() && !ss.toLowerCase().equals("exit")) {
                        ss = inp.nextLine();
                        if (ss.toLowerCase().equals("exit"))
                            return;
                        if (ss.isEmpty()) {
                            System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                            System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                        }
                    }
                    if (ss.toLowerCase().equals("exit"))
                        return;
                    boolean b = false;
                    for (Student t : Data.students) {
                        if (t.getLogin().equals(ss)) {
                            System.out.println(t);
                            System.out.println("Choose the code of information" +
                                    "\nyou want to change:\n1. NAME\n2. SURNAME\n3. PHONE NUMBER\n4. 𝗘𝗫𝗜𝗧");
                            System.out.print("𝖢𝖮𝖣𝖤:");
                            String s = inp.nextLine();
                            while (s.isEmpty()) {
                                System.out.print("𝖢𝖮𝖣𝖤:");
                                s = inp.nextLine();
                            }
                            int a = Integer.parseInt(s);
                            while (a != 1 && a != 2 && a != 3 && a != 4 && a != 5) {
                                System.out.print("𝖢𝖮𝖣𝖤:");
                                s = inp.nextLine();
                                a = Integer.parseInt(s);
                            }
                            b = false;
                            //Admin i=new Admin();
                            switch (a) {
                                case 1:
                                    System.out.println("𝖭𝖤𝖶 𝖭𝖠𝖬𝖤: ");
                                    String q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖭𝖠𝖬𝖤: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF NAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setName(q);
                                    this.Saving(" changed info about student " + t.getLogin());
                                    t.save("name was changed");
                                    updateUserInfo(o);
                                    break;
                                case 2:
                                    System.out.println("𝖭𝖤𝖶 𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
                                    q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF SURNAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setSurname(q);
                                    this.Saving(" changed info about student " + t.getLogin());
                                    t.save("surname was changed");

                                    ;
                                    updateUserInfo(o);
                                    break;
                                case 3:
                                    System.out.println("𝖭𝖤𝖶 𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
                                    q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF NUMBER\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setPhoneNumber(q);
                                    this.Saving(" changed info about student " + t.getLogin());
                                    t.save("phone number was changed");

                                    ;
                                    updateUserInfo(o);

                                    break;

                                case 4:
                                    return;
                            }
                            b = true;
                            break;
                        }
                    }
                    if (b)
                        found = true;
                    else {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    }
                }
            }else{
                System.out.println("There are no registered students in the system");
            }
        }
        if(o instanceof Manager){
            if(Data.managers.size()>0) {
                for (Manager t : Data.managers) {
                    System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname()+" "+t.getPhoneNumber());
                }
                System.out.println("Choose the login of manager,\nwhose information you want to change:");
                boolean found = false;
                while (!found) {
                    System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                    String ss = inp.nextLine();
                    while (ss.isEmpty() && !ss.toLowerCase().equals("exit")) {
                        ss = inp.nextLine();
                        if (ss.toLowerCase().equals("exit"))
                            return;
                        if (ss.isEmpty()) {
                            System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                            System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                        }
                    }
                    if (ss.toLowerCase().equals("exit"))
                        return;
                    boolean b = false;
                    for (Manager t : Data.managers) {
                        if (t.getLogin().equals(ss)) {
                            System.out.println(t);
                            System.out.println("Choose the code of information" +
                                    "\nyou want to change:\n1. NAME\n2. SURNAME\n3. PHONE NUMBER\n4. 𝗘𝗫𝗜𝗧");
                            System.out.print("𝖢𝖮𝖣𝖤:");
                            String s = inp.nextLine();
                            while (s.isEmpty()) {
                                System.out.print("𝖢𝖮𝖣𝖤:");
                                s = inp.nextLine();
                            }
                            int a = Integer.parseInt(s);
                            while (a != 1 && a != 2 && a != 3 && a != 4 && a != 5) {
                                System.out.print("𝖢𝖮𝖣𝖤:");
                                s = inp.nextLine();
                                a = Integer.parseInt(s);
                            }
                            b = false;
                            //Admin i=new Admin();
                            switch (a) {
                                case 1:
                                    System.out.println("𝖭𝖤𝖶 𝖭𝖠𝖬𝖤: ");
                                    String q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖭𝖠𝖬𝖤: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF NAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setName(q);
                                    this.Saving(" changed info about manager " + t.getLogin());
                                    t.save("name was changed");
                                    updateUserInfo(o);
                                    break;
                                case 2:
                                    System.out.println("𝖭𝖤𝖶 𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
                                    q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF SURNAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setSurname(q);
                                    this.Saving(" changed info about manager " + t.getLogin());
                                    t.save("surname was changed");

                                    ;
                                    updateUserInfo(o);
                                    break;
                                case 3:
                                    System.out.println("𝖭𝖤𝖶 𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
                                    q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF NUMBER\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setPhoneNumber(q);
                                    this.Saving(" changed info about manager " + t.getLogin());
                                    t.save("phone number was changed");
                                    ;
                                    updateUserInfo(o);

                                    break;

                                case 4:
                                    return;
                            }
                            b = true;
                            break;
                        }
                    }
                    if (b)
                        found = true;
                    else {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    }
                }
            }else{
                System.out.println("There are no registered managers in the system");
            }
        }
        if(o instanceof Executor){
            if(Data.executors.size()>0) {
                for (Executor t : Data.executors) {
                    System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname());
                }
                System.out.println("Choose the login of executor,\nwhose information you want to change:");
                boolean found = false;
                while (!found) {
                    System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                    String ss = inp.nextLine();
                    while (ss.isEmpty() && !ss.toLowerCase().equals("exit")) {
                        ss = inp.nextLine();
                        if (ss.toLowerCase().equals("exit"))
                            return;
                        if (ss.isEmpty()) {
                            System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                            System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                        }
                    }
                    if (ss.toLowerCase().equals("exit"))
                        return;
                    boolean b = false;
                    for (Executor t : Data.executors) {
                        if (t.getLogin().equals(ss)) {
                            System.out.println(t);
                            System.out.println("Choose the code of information" +
                                    "\nyou want to change:\n1. NAME\n2. SURNAME\n3. PHONE NUMBER\n4. 𝗘𝗫𝗜𝗧");
                            System.out.print("𝖢𝖮𝖣𝖤:");
                            String s = inp.nextLine();
                            while (s.isEmpty()) {
                                System.out.print("𝖢𝖮𝖣𝖤:");
                                s = inp.nextLine();
                            }
                            int a = Integer.parseInt(s);
                            while (a != 1 && a != 2 && a != 3 && a != 4 && a != 5) {
                                System.out.print("𝖢𝖮𝖣𝖤:");
                                s = inp.nextLine();
                                a = Integer.parseInt(s);
                            }
                            b = false;
                            //Admin i=new Admin();
                            switch (a) {
                                case 1:
                                    System.out.println("𝖭𝖤𝖶 𝖭𝖠𝖬𝖤: ");
                                    String q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖭𝖠𝖬𝖤: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF NAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    t.setName(q);
                                    this.Saving(" changed info about executor " + t.getLogin());
                                    t.save(" name was changed");
                                    updateUserInfo(o);
                                    break;
                                case 2:
                                    System.out.println("𝖭𝖤𝖶 𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
                                    q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF SURNAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    this.Saving(" changed info about executor " + t.getLogin());
                                    t.save(" surname was changed");
                                    t.setSurname(q);
                                    ;
                                    updateUserInfo(o);
                                    break;
                                case 3:
                                    System.out.println("𝖭𝖤𝖶 𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
                                    q = inp.nextLine();
                                    while (q.isEmpty()) {
                                        System.out.println("𝖭𝖤𝖶 𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
                                        q = inp.nextLine();
                                        if (q.isEmpty())
                                            System.out.println("INCORRECT TYPE OF NUMBER\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                        if (s.toLowerCase().equals("exit"))
                                            updateUserInfo(o);
                                    }
                                    this.Saving(" changed info about executor " + t.getLogin());
                                    t.save("phone number was changed");
                                    t.setPhoneNumber(q);
                                    ;
                                    updateUserInfo(o);

                                    break;

                                case 4:
                                    return;
                            }
                            b = true;
                            break;
                        }
                    }
                    if (b)
                        found = true;
                    else {
                        System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    }
                }
            }else{
                System.out.println("There are no registered executors in the system");
            }
        }
        Data.save();
    }
    public void viewUser(Object o){
        if(o instanceof Student){
            if(Data.students.size()>0){
                for(Student s:Data.students){
                    System.out.println(s);
                }
            }else
                System.out.println("There are no registered students in the system");
        }
        if(o instanceof Teacher){
            if(Data.teachers.size()>0){
                for(Teacher s:Data.teachers){
                    System.out.println(s);
                }
            }else
                System.out.println("There are no registered teachers in the system");
        }
        if(o instanceof Manager){
            if(Data.managers.size()>0){
                for(Manager s:Data.managers){
                    System.out.println(s);
                }
            }else
                System.out.println("There are no registered managers in the system");
        }
        if(o instanceof Executor){
            if(Data.executors.size()>0){
                for(Executor s:Data.executors){
                    System.out.println(s);
                }
            }else
                System.out.println("There are no registered executors in the system");
        }
        System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
        Scanner input=new Scanner(System.in);
        String s = input.nextLine();
        while(!s.toLowerCase().equals("exit")) {
            System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
            s = input.nextLine();
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
