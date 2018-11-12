package sis3.Objects;

import sis3.*;
import sis3.Enum.Departments;
import sis3.People.Student;
import sis3.People.Teacher;

import java.io.*;
import java.util.TreeSet;
import java.util.Vector;

public class Course implements Serializable {
    private String courseTitle;
    private TreeSet<Teacher> tutors;
    private TreeSet<Student> students;
    private TreeSet<CourseFile> files;
    private Departments department;
    public Course(){
        courseTitle="";
        tutors=new TreeSet<>();
        students=new TreeSet<>();
        files=new TreeSet<>();
        department=Departments.NONE;
    }
    public Course(String t,TreeSet<Teacher> teachers,TreeSet<Student> s, Departments d,TreeSet<CourseFile> f){
        courseTitle=t;
        this.tutors=teachers;
        students=s;
        department=d;
        files=f;
    }

    public void setFiles(TreeSet<CourseFile> files) {
        this.files = files;
    }

    public TreeSet<CourseFile> getFiles() {
        return files;
    }
    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        if(!Data.courseNames.contains(courseTitle)) {
            this.courseTitle = courseTitle;
            Data.courseNames.add(courseTitle);
        }
        else{
            System.out.println("Course with this name has been already registered in the system");
        }
    }



    public TreeSet<Student> getStudents() {
        return students;
    }

    public TreeSet<Teacher> getTutors() {
        return tutors;
    }

    public void setStudents(TreeSet<Student> students) {
        if(Data.students.containsAll(students))
            this.students = students;
        else
            System.out.println("Not all students are registered in the system");
    }



    public void setTutors(TreeSet<Teacher> tutors) {
        if(Data.teachers.containsAll(tutors))
            this.tutors = tutors;
        else
            System.out.println("Not all teachers are registered in the system");

    }
    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return courseTitle +" "+department+ " with teachers:"+tutors+", files: "+ files;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Course){
            Course c=(Course) obj;
            if(files.toString().equals(c.files.toString())&&courseTitle.equals(c.courseTitle)&&department==c.department&&students.toString().equals(c.students.toString())&&tutors.toString().equals(c.tutors.toString()))
                return true;
        }
        return false;
    }
    public void save(){
        if(Data.courseNames.contains(this.getCourseTitle())) {
            Data.courses.add(this);
            Data.save();
        }else{
            System.out.println("Course with this name has been already registered in the system");
        }
    }

}
