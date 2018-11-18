package sis3.People;
import sis3.Enum.Departments;
import sis3.Interfaces.ActionSaving;
import sis3.Storage.Data;
import sis3.Objects.Course;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;
public class Manager extends Employee implements ActionSaving {
    private Vector<Employee> subordinates;

    public Manager(){
        super();
        subordinates=new Vector<>();
    }
    public Manager(String name,String surname, String l, String p, String num,int year,Vector<Employee> emp){
        super(name,surname,l,p,num,year);
        subordinates=emp;
    }

    public Vector<Employee> getSubordinates() {
        return subordinates;
    }


    public void setSubordinates(Vector<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString()+" Subordinates: "+subordinates;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Manager){
            Manager m=(Manager)obj;
            if(super.equals((Employee)m)){
                if(m.subordinates.toString().equals(subordinates.toString())){
                    return true;

                }
            }

        }
        return false;
    }
    public void addCourse(){
        Course c=new Course();
        Scanner inp=new Scanner(System.in);
            System.out.print("𝖢𝖮𝖴𝖱𝖲𝖤 𝖳𝖨𝖳𝖫𝖤:");
            String s=inp.nextLine();
        while(s.isEmpty()) {
            System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            System.out.print("𝖢𝖮𝖴𝖱𝖲𝖤 𝖳𝖨𝖳𝖫𝖤:");
            s = inp.nextLine();
        }
        if (s.toLowerCase().equals("exit"))
            return;
        c.setCourseTitle(s);
        System.out.println("𝖣𝖤𝖯𝖠𝖱𝖳𝖬𝖤𝖭𝖳:");
        System.out.println("1.FIT\n2.BS\n3.FGE\n4.CMC\n5.KMA\n6.FGOGI\n7.ISE\n8.NONE");
        int a=inp.nextInt();
        while(!(a>=1&&a<=8)){
            System.out.println("1.FIT\n2.BS\n3.FGE\n4.CMC\n5.KMA\n6.FGOGI\n7.ISE\n8.NONE");
            a=inp.nextInt();
        }
        inp.nextLine();
        for(Departments d:Departments.values() ){
            if(d.ordinal()==a-1){
                c.setDepartment(d);
                break;
            }
        }
        System.out.println("𝖳𝖤𝖠𝖢𝖧𝖤𝖱𝖲:");
        if(Data.teachers.size()>0) {
            for (Teacher t : Data.teachers) {
                System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname());
            }
            System.out.println("Choose the login of teacher you want to add to the course:");
            boolean found = false;
            while (!found) {
                System.out.print("𝖫𝖮𝖦𝖨𝖭:");
                s = inp.nextLine();
                while (s.isEmpty()) {
                    System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    s = inp.nextLine();
                }
                if (s.toLowerCase().equals("exit"))
                    return;
                boolean b = false;
                for (Teacher t : Data.teachers) {
                    if (t.getLogin().equals(s)) {
                        c.addTeacher(t);
                        t.addCourse(c);
                        Data.courses.add(c);
                        this.Saving(" added course " + c.getCourseTitle());
                        this.Saving(" added teacher " + t.getLogin()+" to the course "+c.getCourseTitle());
                        t.save(" is added to the course "+c.getCourseTitle());
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
            System.out.println("There are no registered teachers in the system, so you can't add new course without tutor.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            s = inp.nextLine();
            while(!s.toLowerCase().equals("exit")) {
                System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
                s = inp.nextLine();
            }
        }



    }
    public void viewStudents(){
        Scanner input=new Scanner(System.in);
        System.out.println("𝖲𝖳𝖴𝖣𝖤𝖭𝖳𝖲:");
        for (Student s:
                Data.students) {
            System.out.println(s);

        }
        System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
        String s = input.nextLine();
        while(!s.toLowerCase().equals("exit")) {
            System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
            s = input.nextLine();
        }
    }
    public void viewTeachers(){
        Scanner input=new Scanner(System.in);
        System.out.println("𝖳𝖤𝖠𝖢𝖧𝖤𝖱𝖲:");
        for(Teacher t:Data.teachers){
            System.out.println(t);
        }
        System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
        String s = input.nextLine();
        while(!s.toLowerCase().equals("exit")) {
            System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
            s = input.nextLine();
        }
    }
    public void save(String inf){
        Data.save();
        if(inf.equals(" is added to the system ")) {
            System.out.println("SAVED");
            Data.managers.add(this);
            this.Saving(inf);
        }else{
            if(inf.contains("changed")){
                System.out.println("CHANGED");
                Data.save();
                this.Saving(inf);
            }else {
                System.out.println("DELETED");
                Data.managers.remove(this);
                this.Saving(inf);
            }
        }
    }
    public void get(){
        Data r =new Data();
        //Data.get(r);
        for (Manager t:Data.managers
        ) {
            System.out.println(t);

        }

    }
    public void sendMessage(){
        Scanner inp=new Scanner(System.in);
        System.out.println("𝖳𝖤𝖠𝖢𝖧𝖤𝖱𝖲:");
        if(Data.teachers.size()>0) {
            for (Teacher t : Data.teachers) {
                System.out.println("𝗅𝗈𝗀𝗂𝗇: " + t.getLogin() + " 𝗂𝗇𝖿𝗈:" + t.getName() + " " + t.getSurname());
            }
            System.out.println("Choose the login of teacher you want to send the message:");
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
                        System.out.println("𝖬𝖤𝖲𝖲𝖠𝖦𝖤 𝖳𝖤𝖷𝖳:\n( '.' - 𝖾𝗇𝖽 𝗈𝖿 𝗍𝗁𝖾 𝗆𝖾𝗌𝗌𝖺𝗀𝖾");
                        String text="";
                        s=inp.nextLine();
                        if(s.contains("."))
                            text+=s;
                        while(!s.contains(".")){
                            s=inp.nextLine();
                            text+=s;
                        }
                        t.addMess(text);
                        this.Saving(" sended message to  " + t.getName()+" "+t.getSurname());
                        t.save(" received new message");
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
            System.out.println("There are no registered teachers in the system, so you can't add new course without tutor.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            String s = inp.nextLine();
            while(!s.toLowerCase().equals("exit")) {
                System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
                s = inp.nextLine();
            }
        }

    }

    @Override
    public Manager clone() throws CloneNotSupportedException {
        Manager t = (Manager) super.clone();
        t.setLogin(getLogin());
        t.setName(getName());
        t.setPassword(getPassword());
        t.setPhoneNumber(getPhoneNumber());
        t.setYearOfWorkOrStudy(getYearOfWorkOrStudy());
        t.setSurname(getSurname());
        t.subordinates=subordinates;
        return t;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Manager) {
            Manager m=(Manager)o;
            if (super.compareTo((Employee)o) == 0) {
                return Integer.compare(m.subordinates.size(),subordinates.size());
            }
            return super.compareTo((Employee)o);
        }
        return -1;
    }
    @Override
    public void Saving(String inf) {
        try {
            FileWriter to_file = new FileWriter("managers.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write(" manager "+this.getLogin()+inf+"\n");
            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
