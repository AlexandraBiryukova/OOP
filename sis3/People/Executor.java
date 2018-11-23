package sis3.People;
import sis3.Interfaces.ActionSaving;
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
    public Executor(String name,String surname,String l,String p,String num,int year,Vector<Order>v){
        super(name,surname,l,p,num,year);
        orders=v;
    }

    public Vector<Order> getOrders() {
        return orders;
    }

    public void setOrders(Vector<Order> orders) {
            this.orders = orders;

    }
    public void addOrder(Order o){
        orders.add(o);
    }
    public void save(String inf){
        Data.save();
        if(inf.equals(" is added to the system ")) {
            System.out.println("SAVED");
            Data.executors.add(this);
            this.Saving(inf);
        }else{
            if(inf.contains("changed")){
                System.out.println("CHANGED");
                Data.save();
                this.Saving(inf);
            }
            else if(inf.contains("order")){
                Data.save();
                this.Saving(inf);
            }
            else{
                System.out.println("DELETED");
                Data.executors.remove(this);
                this.Saving(inf);
            }
        }
    }
    public void get(){
        for(Executor e:Data.executors){
            System.out.println(e);
        }
    }
    public void viewNewOrders(){
        Scanner input=new Scanner(System.in);
        System.out.println("𝖭𝖤𝖶 𝖮𝖱𝖣𝖤𝖱𝖲:");
        boolean b=false;
            for (Order o : getOrders()) {
                if (!o.isAccepted()) {
                    b=true;
                    System.out.println(o);
                    System.out.println("𝗔𝗖𝗖𝗘𝗣𝗧 𝗢𝗥 𝗥𝗘𝗝𝗘𝗖𝗧?(A or R)\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    String s = input.nextLine();
                    while (s.isEmpty() && !s.toLowerCase().equals("a") && !s.toLowerCase().equals("r") && !s.toLowerCase().equals("exit")) {
                        System.out.println("𝗔𝗖𝗖𝗘𝗣𝗧 𝗢𝗥 𝗥𝗘𝗝𝗘𝗖𝗧?(A or R)\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                        s = input.nextLine();

                    }
                    if (s.toLowerCase().equals("exit"))
                        return;
                    if (s.toLowerCase().equals("a")) {
                        o.setAccepted(true);
                        Data.save();
                        System.out.println("𝖠𝖢𝖢𝖤𝖯𝖳𝖤𝖣");
                    } else
                        System.out.println("𝖱𝖤𝖩𝖤𝖢𝖳𝖤𝖣");
                }

        }
        if(!b){
            System.out.println("You haven't got any new orders.");
        }
        System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
        String s = input.nextLine();
        while(!s.toLowerCase().equals("exit")) {
            System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
            s = input.nextLine();
        }for(Order o: orders){
            System.out.println(o);
        }
    }
    public void doOrder(Order o){
        o.setCompleted(true);
    }
    public void viewDoneOrd(){
        Scanner input=new Scanner(System.in);
        System.out.println("𝖣𝖮𝖭𝖤 𝖮𝖱𝖣𝖤𝖱𝖲:");
        if(getOrders().size()==0)
            System.out.println("You haven't got any orders.");
        else {
            for (Order o : getOrders()) {
                if (o.isCompleted())
                    System.out.println(o);

            }
        }System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
        String s = input.nextLine();
        while(!s.toLowerCase().equals("exit")) {
            System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
            s = input.nextLine();
        }
    }
    public void viewAcceptedOrd(){
        Scanner input=new Scanner(System.in);
        System.out.println("𝖠𝖢𝖢𝖤𝖯𝖳𝖤𝖣 𝖮𝖱𝖣𝖤𝖱𝖲:");
        if(getOrders().size()==0)
            System.out.println("You haven't got any orders.");
        else {
            for (Order o : getOrders()) {
                if (o.isAccepted())
                    System.out.println(o);

            }
        }
        System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
        String s = input.nextLine();
        while(!s.toLowerCase().equals("exit")) {
            System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
            s = input.nextLine();
        }
    }
    public void viewAllOrders(){
        Scanner input=new Scanner(System.in);
        System.out.println("𝖠𝖫𝖫 𝖮𝖱𝖣𝖤𝖱𝖲:");
        if(getOrders().size()==0)
            System.out.println("You haven't got any orders.");
        else {
            for (Order o : orders) {
                System.out.println(o);
            }
        }
        System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
        String s = input.nextLine();
        while(!s.toLowerCase().equals("exit")) {
            System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
            s = input.nextLine();
        }for(Order o: orders){
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
            bw.write(" executor "+this.getLogin()+inf+"\n");
            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
