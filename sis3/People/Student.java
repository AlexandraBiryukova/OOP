package sis3.People;


import sis3.Interfaces.ActionSaving;
import sis3.SizeException;
import sis3.Storage.Data;
import sis3.Enum.Departments;
import sis3.Objects.Course;
import sis3.Objects.Mark;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class Student extends Employee{
    private Departments department;
    private TreeSet<Course> courses;
    private Vector<Mark> marks;

    public Student(){
        super();
        department=Departments.NONE;
        courses=new TreeSet<>();
        marks=new Vector<>();
    }
    public Student(String n,String s,String l,String p,String num,int year,Departments d,TreeSet<Course> c,Vector<Mark> m){
        super(n,s,l,p,num,year);
        department=d;
        courses=c;
        marks=m;
    }

    public Vector<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Vector<Mark> marks) {
        this.marks = marks;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public void setCourses(TreeSet<Course> courses) {
        if(Data.courses.containsAll(courses))
            this.courses = courses;
        else{
            System.out.println("Not all courses are registered in the system");
        }
    }

    public TreeSet<Course> getCourses() {
        return courses;
    }

    public Departments getDepartment() {
        return department;
    }
    public void registerToCourse() throws SizeException {
        Scanner inp=new Scanner(System.in);
        if(Data.courses.size()>0) {
        for (Course t : Data.courses) {
            System.out.println("𝗍𝗂𝗍𝗅𝖾: " + t.getCourseTitle());
        }
        System.out.println("Choose the title of course you want to register in:");
        boolean found = false;
        while (!found) {
            System.out.print("𝖳𝖨𝖳𝖫𝖤:");
            String s = inp.nextLine();
            while (s.isEmpty()) {
                System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                s = inp.nextLine();
            }
            if (s.toLowerCase().equals("exit"))
                return;
            boolean b = false;
            for (Course t : Data.courses) {
                if (t.getCourseTitle().equals(s)) {
                    if(this.courses.contains(t)) {
                        System.out.println("You have been already registered to this course");
                        b=true;
                    }else {

                        t.addStudent(this);
                        this.courses.add(t);
                        for(Teacher te:Data.teachers){
                            for(Course ce:te.getCourses()){
                                if(ce.getCourseTitle().equals(t.getCourseTitle()))
                                    te.getCourses().remove(ce);
                                te.addCourse(t);
                            }
                        }
                        String inf = " has been registered to the " + t.getCourseTitle() + " course";
                        this.Saving(inf);
                        Data.save();
                        System.out.println("REGISTRATION IS SUCCESSFUL");
                        b = true;
                        break;
                    }
                }
            }
            if (b)
                found = true;
            else {
                System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            }
        }
    }else{
        throw new SizeException();
    }
    }
    public void viewAllCourses(){
        if(Data.courses.size()>0) {
            for (Course s : Data.courses) {
                System.out.println(s);
                System.out.println();
            }

        }else
            System.out.println("There are no registered courses in the system");
    }
    public void viewCourseFiles(Course s){
        if(Data.courses.contains(s)){
            System.out.println(s.getFiles());
        }else{
            System.out.println("This course doesn't exist");
        }

    }
    public void viewTeacherFromCourse(Course s,String name){
        boolean found=false;
        for(Teacher t:s.getTutors()){
            if((t.getName()+" "+t.getSurname()).equals(name)){
                System.out.println(t);
                found =true;
                break;
            }
        }
        if(!found)
            System.out.println("This teacher isn't from this course");
    }
    public void viewMarkForCourse(Course s){
            System.out.println(s.getCourseTitle());
            System.out.println("𝗆𝖺𝗋𝗄𝗌: ");
            boolean b=false;
            for (Mark m:marks){
                if(m.getCourse().getCourseTitle().equals(s.getCourseTitle())){
                    System.out.print("⊢"+m+"⊣ ");
                    b=true;
                }
            }
            if(!b){
                System.out.println("NO MARKS");
            }

    }
    public void viewTranscript(){
        if(courses.size()>0) {
            for (Course s :courses) {
                viewMarkForCourse(s);
                System.out.println();
            }
        }else
            System.out.println("You are not registered to any courses");
    }

    @Override
    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString()+" "+department;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            Student s=(Student)obj;
            if(super.equals((Employee)s)){
                if(marks.toString().equals(s.marks.toString())&&department==s.department&&courses.toString().equals(s.courses.toString()))
                    return true;
            }
        }
        return false;
    }
    public void save(String inf){
        Data.save();
        if(inf.equals(" is added to the system ")) {
            System.out.println("SAVED");
            Data.students.add(this);
            this.Saving(inf);
        }else{
            if(inf.contains("changed")){
                System.out.println("CHANGED");
                Data.save();
                this.Saving(inf);
            }if(inf.contains("mark")){
                Data.save();
                this.Saving(inf);
            }
            else {
                System.out.println("DELETED");
                Data.students.remove(this);
                this.Saving(inf);
            }
        }

    }
    public void get(){
        for (Student t:Data.students
        ) {
            System.out.println(t);

        }

    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            Student s=(Student)o;
            if(super.compareTo((Employee)o)==0){
                if(department.compareTo(s.department)==0){
                    if(courses.size()==s.courses.size()){
                        return Integer.compare(marks.size(), s.marks.size());
                    }else return Integer.compare(courses.size(),s.courses.size());

                }else
                    return department.compareTo(s.department);
            }else
                return super.compareTo((Employee)o);
        }
        return -1;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student t=(Student)super.clone();
        t.setLogin(getLogin());
        t.setName(getName());
        t.setPassword(getPassword());
        t.setPhoneNumber(getPhoneNumber());
        t.setYearOfWorkOrStudy(getYearOfWorkOrStudy());
        t.setSurname(getSurname());
        t.courses=this.courses;
        t.department=this.department;
        t.marks=this.marks;
        return t;
    }
    @Override
    public void Saving(String inf) {
        try {
            FileWriter to_file = new FileWriter("students.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write(" student "+this.getLogin()+inf+"\n");
            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}

