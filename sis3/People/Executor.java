package sis3.People;
import sis3.Interfaces.ActionSaving;
import sis3.Storage.Data;
import sis3.Objects.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Executor extends Employee implements ActionSaving {
    private Vector<Order> orders;
    public Executor(){
        super();
        orders=new Vector<>();
    }
    public Executor(String name,String surname,String l,String p,int num,int year,Vector<Order>v){
        super(name,surname,l,p,num,year);
        orders=v;
    }

    public Vector<Order> getOrders() {
        return orders;
    }

    public void setOrders(Vector<Order> orders) {
        if(!Data.orders.containsAll(orders)) {
            this.orders = orders;
            Data.orders.addAll(orders);
        }
    }
    public void viewNewOrders(){
        for (Order o:Data.orders){
            if(!o.isAccepted()){
                System.out.println(o);
                System.out.println("Accept or reject?");
                Scanner s=new Scanner(System.in);
                String res=s.nextLine();
                if(res.toUpperCase()=="ACCEPT")
                    o.setAccepted(true);
            }

        }
    }
    public void doOrder(Order o){
        o.setCompleted(true);
    }
    public void viewDoneOrd(){
        for(Order o:Data.orders){
            if(o.isCompleted())
                System.out.println(o);
        }
    }
    public void viewAcceptedOrd(){
        for(Order o:Data.orders){
            if(o.isAccepted())
                System.out.println(o);
        }
    }
    public void viewAllOrders(){
        for(Order o: Data.orders){
            System.out.println(o);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashcode() {
        return super.hashcode();
    }

    @Override
    public  Executor clone() throws CloneNotSupportedException {
        Executor t = (Executor) super.clone();
        t.setLogin(getLogin());
        t.setName(getName());
        t.setPassword(getPassword());
        t.setPhoneNumber(getPhoneNumber());
        t.setYearOfWorkOrStudy(getYearOfWorkOrStudy());
        t.setSurname(getSurname());
        t.orders=orders;
        return t;

    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Executor) {
            Executor m=(Executor) o;
            if (super.compareTo((Employee)o) == 0) {
                return Integer.compare(m.orders.size(),orders.size());
            }
            return super.compareTo((Employee)o);
        }
        return -1;
    }

    @Override
    public void Saving(String inf) {
        try {
            FileWriter to_file = new FileWriter("executors.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write("executor"+this.getLogin()+inf);
            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
