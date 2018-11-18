package sis3.Objects;

import sis3.Enum.Departments;
import sis3.People.Student;
import sis3.People.Teacher;
import sis3.Storage.Data;

import java.io.*;
import java.util.TreeSet;

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
        String tres="";
        for(Teacher t:tutors){
            tres+=t+"\n";

        }
        String fres="";
        for(CourseFile c:files){
            fres+=c+"\n";
        }
        return "𝗍𝗂𝗍𝗅𝖾: "+courseTitle +"𝖽𝖾𝗉𝖺𝗋𝗍𝗆𝖾𝗇𝗍:"+department+ "\n𝗍𝖾𝖺𝖼𝗁𝖾𝗋𝗌:\n"+tres+"\n𝖿𝗂𝗅𝖾𝗌:\n"+ fres;
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
            //Data.save();
        }else{
            System.out.println("Course with this name has been already registered in the system");
        }
    }
    public void get(){
        Data r = new Data();
        //Data.get(r);
        for (Course t:Data.courses
        ) {
            System.out.println(t);

        }

    }


}
