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
    public static TreeSet<Admin> admins;
    public static TreeSet<Executor> executors;
    static {
        managers=new TreeSet<Manager>();
        students=new TreeSet<Student>();
        teachers=new TreeSet<Teacher>();
        courses=new TreeSet<Course>();
        courseNames=new TreeSet<String>();
        admins=new TreeSet<Admin>();
        executors=new TreeSet<Executor>();
    }
    public static void save(){
        saveAdmins();
        saveTeachers();
        saveStudents();
        saveManagers();
        saveExecutors();
        saveCourses();
        saveCourseNames();

    }



    public static void get(){
        getAdmins();
        getTeachers();
        getManagers();
        getExecutors();
        getStudents();
        getCourses();
        getCourseNames();

    }

    private static void getCourseNames() {
        try {

            FileInputStream out = new FileInputStream("courseNames.out");
            ObjectInputStream o = new ObjectInputStream(out);
            TreeSet<String> a= (TreeSet<String>) o.readObject();
            courseNames=a;

            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void saveCourseNames() {
        try {

            FileOutputStream out = new FileOutputStream("courseNames.out");
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(courseNames);
            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void saveCourses() {
        try {

            FileOutputStream out = new FileOutputStream("courses.out");
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(courses);
            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void getCourses() {
        try {

            FileInputStream out = new FileInputStream("courses.out");
            ObjectInputStream o = new ObjectInputStream(out);
            TreeSet<Course> a= (TreeSet<Course>) o.readObject();
            courses=a;

            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void getExecutors() {
        try {

            FileInputStream out = new FileInputStream("executors.out");
            ObjectInputStream o = new ObjectInputStream(out);
            TreeSet<Executor> a= (TreeSet<Executor>) o.readObject();
            executors=a;

            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void saveExecutors() {
        try {

            FileOutputStream out = new FileOutputStream("executors.out");
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(executors);


            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getManagers() {
        try {

            FileInputStream out = new FileInputStream("managers.out");
            ObjectInputStream o = new ObjectInputStream(out);
            TreeSet<Manager> a= (TreeSet<Manager>) o.readObject();
            managers=a;

            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void saveManagers() {
        try {

            FileOutputStream out = new FileOutputStream("managers.out");
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(managers);


            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

    public static void saveStudents(){
        try {

            FileOutputStream out = new FileOutputStream("students.out");
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(students);


            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void getStudents() {
        try {

            FileInputStream out = new FileInputStream("students.out");
            ObjectInputStream o = new ObjectInputStream(out);
            TreeSet<Student> a= (TreeSet<Student>) o.readObject();
            students=a;

            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
