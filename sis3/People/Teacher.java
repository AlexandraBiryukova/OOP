package sis3.People;

import sis3.Interfaces.ActionSaving;
import sis3.Storage.Data;
import sis3.Enum.Departments;
import sis3.Interfaces.MakingOrder;
import sis3.Objects.Course;
import sis3.Objects.CourseFile;
import sis3.Objects.Mark;
import sis3.Enum.TeacherStatuses;
import sis3.Objects.Order;

import java.io.*;
import java.util.Date;
import java.util.TreeSet;
import java.util.Vector;

public class Teacher extends Employee implements ActionSaving,MakingOrder {
    private TeacherStatuses status;
    private Departments department;
    private TreeSet<Course> courses;
    private Vector<String> messages;

    public Teacher(){
        super();
        status=TeacherStatuses.NONE;
        department=Departments.NONE;
        courses=new TreeSet<>();
        messages=new Vector<>();
    }
    public Teacher(String n,String s,String l,String p, int num,int year,Departments d,TeacherStatuses t,TreeSet<Course> v){
        super(n,s,l,p,num,year);
        status=t;
        department=d;
        courses=v;
    }

    public Vector<String> getMessages() {
        return messages;
    }

    public void setMessages(Vector<String> messages) {
        this.messages = messages;
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
    @Override
    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Teacher){
            Teacher t=(Teacher)o;
            if(super.compareTo((User)t)==0) {
                if (t.department.compareTo(department) == 0) {
                    if(t.status.compareTo(status)==0){
                        if(t.courses.equals(courses))
                            return 0;
                        else{
                            if(t.courses.size()>courses.size())
                                return -1;
                            else
                                return 1;
                        }

                    }else
                        return t.status.compareTo(status);

                }else
                    return t.department.compareTo(department);
            }else
                return super.compareTo((User)t);
        }
        return -1;
    }

    @Override
    public Teacher clone() throws CloneNotSupportedException {
        Teacher t = (Teacher) super.clone();
        t.setLogin(getLogin());
        t.setName(getName());
        t.setPassword(getPassword());
        t.setPhoneNumber(getPhoneNumber());
        t.setYearOfWorkOrStudy(getYearOfWorkOrStudy());
        t.setSurname(getSurname());
        t.courses=this.courses;
        t.department=this.department;
        t.status=this.status;
        return t;
    }

    public void save(){
        Data.teachers.add(this);
        Data.save();
    }
    public void get(){
        Data r = Data.get();
        for (Teacher t:Data.teachers
             ) {
            System.out.println(t);

        }

    }


    public void viewAllStudents(){
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
        if(courses.contains(s)) {
            TreeSet<CourseFile> ss = s.getFiles();
            ss.add(c);
            s.setFiles(ss);
        }
        else
            System.out.println("You can't add files to this course.");

    }
    public void deleteCourseFile(Course s,CourseFile c){
        if(courses.contains(s)&&s.getFiles().contains(c)){
            TreeSet<CourseFile> ss = s.getFiles();
            ss.remove(c);
            s.setFiles(ss);
        }
        else
            System.out.println("You can't delete this file.");
    }
    public void setMark(Student s, Mark m){
        boolean found =false;
        for(Course c:this.getCourses()){
            if(c.getStudents().contains(s)){
                Vector<Mark> ss = s.getMarks();
                ss.add(m);
                s.setMarks(ss);
                found=true;
            }
        }
        if(!found)
            System.out.println("This student is not yours");

    }
    public void sendOrder(Executor ex,Order o){
        Vector<Order> v=ex.getOrders();
        v.add(o);
        ex.setOrders(v);

    }

    @Override
    public void Saving(String inf) {
        try {
            FileWriter to_file = new FileWriter("teachers.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write("teacher "+this.getLogin()+inf);

            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
