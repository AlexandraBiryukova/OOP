package sis3.People;
import sis3.Interfaces.ActionSaving;
import sis3.Storage.Data;
import sis3.Objects.Course;

import java.io.*;
import java.util.Date;
import java.util.Vector;
public class Manager extends Employee {
    private Vector<Employee> subordinates;

    public Manager(){
        super();
        subordinates=new Vector<>();
    }
    public Manager(String name,String surname, String l, String p, String num,int year,Vector<Employee> emp){
        super(name,surname,l,p,num,year);
        subordinates=emp;
    }

    public Vector<Employee> getSubordinates() {
        return subordinates;
    }


    public void setSubordinates(Vector<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
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
        //Data.save();
    }
    public void get(){
        Data r =new Data();
        //Data.get(r);
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
    @Override
    public void Saving(String inf) {
        try {
            FileWriter to_file = new FileWriter("managers.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write("manager"+this.getLogin()+inf);
            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
