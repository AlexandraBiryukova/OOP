package sis3.People;

import sis3.Data;
import sis3.Enum.Departments;
import sis3.Objects.Course;
import sis3.Objects.CourseFile;
import sis3.Objects.Mark;
import sis3.Enum.TeacherStatuses;

import java.io.*;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.TransferQueue;

public class Teacher extends Employee implements Serializable {
    private TeacherStatuses status;
    private Departments department;
    private TreeSet<Course> courses;

    public Teacher(){
        super();
        status=TeacherStatuses.NONE;
        department=Departments.NONE;
        courses=new TreeSet<>();
    }
    public Teacher(String n,String s,String l,String p, int num,int year,Departments d,TeacherStatuses t,TreeSet<Course> v){
        super(n,s,l,p,num,year);
        status=t;
        department=d;
        courses=v;
    }

    public Departments getDepartment() {
        return department;
    }

    public TeacherStatuses getStatus() {
        return status;
    }

    public TreeSet<Course> getCourses() {
        return courses;
    }

    public void setCourses(TreeSet<Course> courses) {
        if(Data.courses.containsAll(courses))
            this.courses = courses;
        else
            System.out.println("Not all courses are registered in the system");
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public void setStatus(TeacherStatuses status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString()+" "+department+" "+ status+" "+courses.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Teacher){
            Teacher t=(Teacher)obj;
            if(super.equals((Employee)t)){
                if(t.courses.toString().equals(courses.toString())&&t.department==department&&t.status==status)
                    return true;
            }
        }
        return false;
    }
    public int hashcode() {
        return super.hashCode();
    }

    public void save(){
        Data.teachers.add(this);
        Data.save();
    }


    public static void viewAllStudents(){
        try {

            FileInputStream out = new FileInputStream("data.ser");
            ObjectInputStream os = new ObjectInputStream(out);
            Data b=(Data) os.readObject();
            for (Student s:b.students
            ) {
                System.out.println(s.toString());

            }

            os.close();
        } catch (Exception e) {
            System.out.println("oops");
        }

    }
    public void viewStudentsofCourse(Course c){
        if(Data.courses.contains(c))
            System.out.println(c);
        else
            System.out.println("This course doesn't exist");

    }

    public void viewOwnCourses(){
        for (Course s:courses) {
            System.out.println(s.toString());

        }
    }
    public void addCourse(Course s){
        if(!Data.courseNames.contains(s.getCourseTitle())) {
            courses.add(s);
            s.save();
        }else{
            System.out.println("Course with this name has been already registered in the system");
        }
    }
    public void addCourseFile(Course s, CourseFile c){
        if(courses.contains(s))
            s.getFiles().add(c);
        else
            System.out.println("You can't add files to this course.");

    }
    public void deleteCourseFile(Course s,CourseFile c){
        if(courses.contains(s)&&s.getFiles().contains(c))
            s.getFiles().remove(c);
        else
            System.out.println("You can't delete this file.");
    }
    public void setMark(Student s, Mark m){
        boolean found =false;
        for(Course c:this.getCourses()){
            if(c.getStudents().contains(s)){
                s.getMarks().add(m);
                found=true;
            }
        }
        if(!found)
            System.out.println("This student is not yours");

    }
}
