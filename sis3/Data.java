package sis3;

import sis3.Objects.Course;
import sis3.People.Manager;
import sis3.People.Student;
import sis3.People.Teacher;
import sis3.People.User;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeSet;

public class Data implements Serializable {
    public static TreeSet<Manager> managers=new TreeSet<>();
    public static TreeSet<Student> students=new TreeSet<>();
    public static TreeSet<Teacher> teachers=new TreeSet<>();
    public static TreeSet<Course> courses=new TreeSet<>();
    public static TreeSet<String> logins=new TreeSet<String>();
    public static TreeSet<String> courseNames=new TreeSet<>();
    public static void save(){
        try {

            FileOutputStream out = new FileOutputStream("data.ser");
            ObjectOutputStream os = new ObjectOutputStream(out);
            Data d=new Data();
            os.writeObject(d);
            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println("oops");
        }
    }
}
