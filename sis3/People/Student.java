package sis3.People;


import sis3.Interfaces.ActionSaving;
import sis3.Storage.Data;
import sis3.Enum.Departments;
import sis3.Objects.Course;
import sis3.Objects.Mark;

import java.io.*;
import java.util.Date;
import java.util.TreeSet;
import java.util.Vector;

public class Student extends Employee implements Serializable,Cloneable,Comparable{
    private Departments department;
    private TreeSet<Course> courses;
    private Vector<Mark> marks;

    public Student(){
        super();
        department=Departments.NONE;
        courses=new TreeSet<>();
        marks=new Vector<>();
    }
    public Student(String n,String s,String l,String p,int num,int year,Departments d,TreeSet<Course> c,Vector<Mark> m){
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
    public void registerToCourse(Course s){
        if(courses.contains(s))
            System.out.println("You have been already registered to this course");
        else{
            if(Data.courses.contains(s)){
                courses.add(s);
                System.out.println("Registration is successful");
            }else{
                System.out.println("This course isn't registered in the system");

            }
        }
    }
    public void viewOwnCourses(){
        for(Course s:courses){
            System.out.println(s.getCourseTitle());
        }
    }

    public void viewAllCourses(){
        for(Course s:Data.courses){
            System.out.println(s.getCourseTitle());
        }
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
        if(courses.contains(s)){
            System.out.println(s.getCourseTitle());
            boolean b=false;
            for (Mark m:marks){
                if(m.getCourse().getCourseTitle().equals(s.getCourseTitle())){
                    System.out.print(m+" ");
                    b=true;
                }
            }
            if(!b){
                System.out.println("NO MARKS");
            }
        }else{
            System.out.println("You are not registered to this course");
        }
    }
    public void viewTranscript(){
        for(Course s:courses){
            System.out.println(s.getCourseTitle());
            for(Mark m:marks){
                if(m.getCourse().getCourseTitle().equals(s.getCourseTitle()))
                    System.out.print(m+" ");
            }
            System.out.println();
        }
    }

    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString()+department;
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
    public void save(){
        Data.students.add(this);
        Data.save();
    }
    public void get(){
        Data r = Data.get();
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
    public void Saving() {
        try {
            FileWriter to_file = new FileWriter("students.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write("student "+this.getLogin()+" do something");

            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}

