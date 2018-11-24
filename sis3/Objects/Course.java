package sis3.Objects;

import sis3.Enum.Departments;
import sis3.People.Student;
import sis3.People.Teacher;
import sis3.Storage.Data;

import java.io.*;
import java.util.TreeSet;

public class Course implements Serializable,Cloneable,Comparable {
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
        this.courseTitle = courseTitle;

    }



    public TreeSet<Student> getStudents() {
        return students;
    }

    public TreeSet<Teacher> getTutors() {
        return tutors;
    }

    public void setStudents(TreeSet<Student> students) {

            this.students = students;

    }



    public void setTutors(TreeSet<Teacher> tutors) {
            this.tutors = tutors;


    }
    public void addFile(CourseFile c){
        files.add(c);
    }
    public void deleteFile(CourseFile c){
        files.remove(c);
    }
    public void addStudent(Student s){
        students.add(s);
    }
    public void addTeacher(Teacher s){
        tutors.add(s);

    }
    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "𝗍𝗂𝗍𝗅𝖾: "+courseTitle +"\n𝖽𝖾𝗉𝖺𝗋𝗍𝗆𝖾𝗇𝗍: "+department+ "\n𝗍𝖾𝖺𝖼𝗁𝖾𝗋𝗌: "+tutors.toString()+"\n𝖿𝗂𝗅𝖾𝗌: "+ files.toString();
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


    @Override
    public int compareTo(Object o) {
        if(o instanceof Course){
            Course c=(Course)o;
//            if(this.courseTitle.compareTo(c.courseTitle)==0) {
//                if (department == c.department) {
//                    if (tutors.equals(c.getTutors())) {
//                        if (students.equals(c.getStudents())) {
//                            if (files.equals(c.getFiles())) {
//                                return 0;
//                            }
//                            if (files.size() > c.files.size())
//                                return 1;
//                            return -1;
//                        }
//                        if (students.size() > c.students.size())
//                            return 1;
//                        return -1;
//
//                    }
//                    if (tutors.size() > c.tutors.size())
//                        return 1;
//                    return -1;
//                }
//                return department.compareTo(c.department);
//            }
            return this.courseTitle.compareTo(c.courseTitle);
        }
        return -1;
    }

    @Override
    protected Course clone() throws CloneNotSupportedException {
        Course t = (Course)super.clone();
        t.setCourseTitle(getCourseTitle());
        t.department=this.department;
        t.tutors=this.tutors;
        t.students=students;
        t.files=files;
        return t;

    }
}
