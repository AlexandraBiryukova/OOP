package sis3.Storage;

import sis3.Objects.*;
import sis3.People.*;


import java.io.*;
import java.util.TreeSet;

public class Data implements Serializable {
    public static TreeSet<Manager> managers=new TreeSet<>();
    public static TreeSet<Student> students=new TreeSet<>();
    public static TreeSet<Teacher> teachers=new TreeSet<>();
    public static TreeSet<Course> courses=new TreeSet<>();
    public static TreeSet<String> logins=new TreeSet<String>();
    public static TreeSet<String> courseNames=new TreeSet<String>();
    public static TreeSet<Order> orders=new TreeSet<Order>();
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
    public static  Data get(){
        Data d=new Data();
        try {

            FileInputStream out = new FileInputStream("data.ser");
            ObjectInputStream os = new ObjectInputStream(out);
             d=(Data)os.readObject();
            os.close();
        } catch (Exception e) {
            System.out.println("oops");
        }
        return d;

    }
}
