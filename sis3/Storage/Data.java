package sis3.Storage;

import sis3.Objects.*;
import sis3.People.*;


import java.io.*;
import java.util.Date;
import java.util.TreeSet;

public class Data implements Serializable {
    public static TreeSet<Manager> managers;
    public static TreeSet<Student> students;
    public static TreeSet<Teacher> teachers;
    public static TreeSet<Course> courses;
    public static TreeSet<String> courseNames;
    public static TreeSet<Order> orders;
    public static TreeSet<Admin> admins;
    public static TreeSet<Executor> executors;
    {
        managers=new TreeSet<>();
        students=new TreeSet<>();
        teachers=new TreeSet<>();
        courses=new TreeSet<>();
        courseNames=new TreeSet<>();
        orders=new TreeSet<>();
        admins=new TreeSet<>();
        executors=new TreeSet<>();
    }
    public static void save(){
        saveAdmins();
        saveTeachers();

    }
    public static void get(){
        getAdmins();
        getTeachers();

    }

    public static void getAdmins() {
        try {

            FileInputStream out = new FileInputStream("admins.out");
            ObjectInputStream o = new ObjectInputStream(out);
            TreeSet<Admin> a= (TreeSet<Admin>) o.readObject();
            admins=a;

            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void saveAdmins(){
        try {

            FileOutputStream out = new FileOutputStream("admins.out");
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(admins);


            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void saveTeachers(){
        try {

            FileOutputStream out = new FileOutputStream("teachers.out");
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(teachers);


            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void getTeachers() {
        try {

            FileInputStream out = new FileInputStream("teachers.out");
            ObjectInputStream o = new ObjectInputStream(out);
            TreeSet<Teacher> a= (TreeSet<Teacher>) o.readObject();
            teachers=a;

            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
