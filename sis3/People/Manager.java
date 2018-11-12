package sis3.People;
import sis3.Data;
import sis3.Objects.Course;

import java.io.*;
import java.util.Date;
import java.util.Vector;
public class Manager extends Employee implements Serializable {
    private Vector<Employee> subordinates;

    public Manager(){
        super();
        subordinates=new Vector<>();
    }
    public Manager(String name,String surname, String l, String p, int num,int year,Vector<Employee> emp){
        super(name,surname,l,p,num,year);
        subordinates=emp;
    }

    public Vector<Employee> getSubordinates() {
        return subordinates;
    }


    public void setSubordinates(Vector<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString()+" Subordinates: "+subordinates;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Manager){
            Manager m=(Manager)obj;
            if(super.equals((Employee)m)){
                if(m.subordinates.toString().equals(subordinates.toString())){
                    return true;

                }
            }

        }
        return false;
    }
    public void addCourse(Course c){
            c.save();
    }
    public void viewStudents(){
        for (Student s:
                Data.students) {
            System.out.println(s);

        }
    }
    public void viewTeachers(){
        for(Teacher t:Data.teachers){
            System.out.println(t);
        }
    }
    public void save(){
        Data.managers.add(this);
        Data.save();
    }



}
