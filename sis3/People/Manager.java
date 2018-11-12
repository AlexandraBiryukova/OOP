package sis3.People;
import sis3.Data;
import sis3.Objects.Course;

import java.io.*;
import java.util.Date;
import java.util.Vector;
public class Manager extends Employee implements Serializable,Cloneable,Comparable {
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
    public void read(){
        Data r = Data.read();
        for (Manager t:Data.managers
        ) {
            System.out.println(t);

        }

    }
    public void sendMessage(Teacher t,String s){
        if(Data.teachers.contains(t)) {
            Vector<String> l=t.getMessages();
            l.add(s);
            t.setMessages(l);
        }
    }

    @Override
    public Manager clone() throws CloneNotSupportedException {
        Manager t = (Manager) super.clone();
        t.setLogin(getLogin());
        t.setName(getName());
        t.setPassword(getPassword());
        t.setPhoneNumber(getPhoneNumber());
        t.setYearOfWorkOrStudy(getYearOfWorkOrStudy());
        t.setSurname(getSurname());
        t.subordinates=subordinates;
        return t;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Manager) {
            Manager m=(Manager)o;
            if (super.compareTo((Employee)o) == 0) {
                return Integer.compare(m.subordinates.size(),subordinates.size());
            }
            return super.compareTo((Employee)o);
        }
        return -1;
    }
}
