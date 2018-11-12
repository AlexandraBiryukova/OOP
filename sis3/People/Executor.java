package sis3.People;
import sis3.Storage.Data;
import sis3.Objects.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Executor extends Employee {
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
    public void Saving() {
        try {
            FileWriter to_file = new FileWriter("executors.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write("executor"+this.getLogin()+" logged into the system");
            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
