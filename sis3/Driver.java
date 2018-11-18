package sis3;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;
import sis3.Objects.Order;
import sis3.People.*;
import sis3.Storage.Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class Driver {
    static Data d=new Data();
    static Scanner input=new Scanner(System.in);

    public static void starting() {
        System.out.print("𝕎𝔼𝕃ℂ𝕆𝕄𝔼 𝕋𝕆 𝕆𝕌ℝ 𝕀ℕ𝕋ℝ𝔸ℕ𝔼𝕋 𝕊𝕐𝕊𝕋𝔼𝕄!\n 𝖯𝖫𝖤𝖠𝖲𝖤, 𝖲𝖤𝖫𝖤𝖢𝖳 𝖸𝖮𝖴𝖱 𝖴𝖲𝖤𝖱 𝖳𝖸𝖯𝖤:\n" +
                "1. ADMIN\n2. STUDENT\n3. TEACHER\n4. MANAGER\n5. EXECUTOR\n𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳\n𝖸𝖮𝖴 𝖢𝖧𝖮𝖮𝖲𝖤:");
        String user = input.nextLine().toLowerCase();
        switch (user) {
            case "admin":
                System.out.println("Hello, Admin!");
                userMode(new Admin());
                break;
            case "student":
                System.out.println("Hello, Student!");
                userMode(new Student());
                break;
            case "teacher":
                System.out.println("Hello, Teacher!");
                break;
            case "executor":
                System.out.println("Hello, Executor!");
                userMode(new Executor());
                break;
            case "manager":
                System.out.println("Hello, Manager!");
                userMode(new Manager());
                break;
            case "exit":
                Data.save();
                return;
            default: {
                starting();
            }

        }

    }

    private static void userMode(User aaa) {
        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        System.out.print("𝖫𝖮𝖦𝖨𝖭: ");
        String alog = input.nextLine();
        if(alog.isEmpty()) {
            while (alog.isEmpty() && !alog.toLowerCase().equals("exit")) {
                System.out.print("𝖫𝖮𝖦𝖨𝖭: ");
                alog = input.nextLine();
            }
        }
        if (alog.toLowerCase().equals("exit")) {
            starting();
            return;
        }
        System.out.print("𝖯𝖠𝖲𝖲𝖶𝖮𝖱𝖣: ");
        String apas=input.nextLine();
        while(apas.isEmpty()&& !apas.toLowerCase().equals("exit")) {
            System.out.print("𝖯𝖠𝖲𝖲𝖶𝖮𝖱𝖣: ");
            apas = input.nextLine();
        }
        if (apas.toLowerCase().equals("exit")) {
            starting();
            return;
        }
        aaa.setPassword(apas);
        aaa.setLogin(alog);
        if(aaa instanceof Admin) {
            Admin h=(Admin)aaa;
            viewAdmins(h);
        }
        if(aaa instanceof Executor){
            Executor h=(Executor)aaa;
            viewExecutors(h);
        }
        if( aaa instanceof Student){
            Student s=(Student)aaa;
            viewStudents(s);
        }
        if(aaa instanceof Manager){
            Manager m=(Manager)aaa;
            viewManagers(m);
        }



    }

    private static void viewManagers(Manager a) {
        boolean foundL=false,foundP=false;
        for(Manager ad:d.managers) {
            if (ad.getLogin().equals(a.getLogin())) {
                foundL=true;
                if(ad.getPassword().equals(a.getPassword())) {
                    a=ad;
                    System.out.println("Hello, " + ad.getName() + "!");
                    ad.Saving(" logged into the system");
                    foundP= true;
                    break;
                }

            }
        }
        if(foundP)
            mActions(a);
        if(!foundP&&!foundL){
            System.out.println("You haven't been registered yet.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            String choise=input.nextLine();
            while(!choise.toLowerCase().equals("exit")) {
                choise=input.nextLine();
                System.out.println("𝖤𝖷𝖨𝖳");
            }
            starting();


        }
    }
    private static void mActions(Manager i) {
        System.out.println("SELECT COMMAND CODE:\n1. Add course\n2. View teachers\n3. View students\n4. Send message to the teacher\n5. 𝗘𝗫𝗜𝗧");
        System.out.print("𝖢𝖮𝖣𝖤:");
        int a=input.nextInt();
        input.nextLine();
        while (a!=1&&a!=2&&a!=3&&a!=4&&a!=5) {
            mActions(i);
        }
        switch (a) {
            case 1:
                i.addCourse();
                mActions(i);
                break;
            case 2:
                i.viewTeachers();
                mActions(i);
                break;
            case 3:
                i.viewStudents();
                mActions(i);
                break;
            case 4:
                i.sendMessage();
                mActions(i);
                break;
            case 5:
                userMode(i);

        }

    }

    private static void viewStudents(Student a) {
        boolean foundL=false,foundP=false;
        for(Student ad:d.students) {
            if (ad.getLogin().equals(a.getLogin())) {
                foundL=true;
                if(ad.getPassword().equals(a.getPassword())) {
                    a=ad;
                    System.out.println("Hello, " + ad.getName() + "!");
                    ad.Saving(" logged into the system");
                    foundP= true;
                    break;
                }

            }
        }
        if(foundP)
            stActions(a);
        if(!foundP&&!foundL){
            System.out.println("You haven't been registered yet.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            String choise=input.nextLine();
            while(!choise.toLowerCase().equals("exit")) {
                choise=input.nextLine();
                System.out.println("𝖤𝖷𝖨𝖳");
            }
            starting();


        }

    }
    private static void stActions(Student i) {
        System.out.println("SELECT COMMAND CODE:\n1. Register to the course\n2. View courses\n3. View transcript\n4. 𝗘𝗫𝗜𝗧");
        System.out.print("𝖢𝖮𝖣𝖤:");
        int a=input.nextInt();
        input.nextLine();
        while (a!=1&&a!=2&&a!=3&&a!=4) {
            stActions(i);
        }
        switch (a) {
            case 1:
                i.registerToCourse();
                stActions(i);
                break;
            case 2:
                i.viewAllCourses();
                stActions(i);
                break;
            case 3:
                i.viewTranscript();
                stActions(i);
                break;
            case 4:
                userMode(i);

        }

    }

    private static void adminRegist(Admin a){
        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        System.out.println("Please fill next fields:");
        System.out.println("𝖭𝖠𝖬𝖤: ");
        String s=input.nextLine();
        while (s.isEmpty()) {
            System.out.println("𝖭𝖠𝖬𝖤: ");
            s = input.nextLine();
            if (s.isEmpty())
                System.out.println("INCORRECT TYPE OF NAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            if(s.toLowerCase().equals("exit"))
                return;
        }
        a.setName(s);
        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        System.out.println("𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
        s=input.nextLine();
        while (s.isEmpty()) {
            System.out.println("𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
            s = input.nextLine();
            if (s.isEmpty())
                System.out.println("INCORRECT TYPE OF SURNAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            if(s.toLowerCase().equals("exit"))
                return;
        }
        a.setSurname(s);
        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        System.out.println("𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
        s=input.nextLine();
        while (s.isEmpty()) {
            System.out.println("𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
            s= input.nextLine();
            if (s.isEmpty())
                System.out.println("INCORRECT TYPE OF PHONE NUMBER\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            if(s.toLowerCase().equals("exit"))
                return;
        }
        a.setPhoneNumber(s);

        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        System.out.println("𝖸𝖤𝖠𝖱 𝖮𝖥 𝖶𝖮𝖱𝖪 𝖮𝖱 𝖲𝖳𝖴𝖣𝖸: ");
        s=input.nextLine();
        while (s.isEmpty()||Integer.parseInt(s)==0) {
            System.out.println("𝖸𝖤𝖠𝖱 𝖮𝖥 𝖶𝖮𝖱𝖪 𝖮𝖱 𝖲𝖳𝖴𝖣𝖸: ");
            s= input.nextLine();
            if (Integer.parseInt(s)==0)
                System.out.println("INCORRECT TYPE OF YEAR\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            if(s.toLowerCase().equals("exit"))
                return;
        }
        a.setYearOfWorkOrStudy(Integer.parseInt(s));
        Data.admins.add(a);
        a.Saving(" is added to the sistem");
        a.Saving(" logged into the system");
        //System.out.println(Data.admins.size());
        Data.save();
        adminActions(a);

    }
    private static void viewAdmins(Admin a){
        boolean foundL=false,foundP=false;
        for(Admin ad:d.admins) {
            if (ad.getLogin().equals(a.getLogin())) {
                foundL=true;
                if(ad.getPassword().equals(a.getPassword())) {
                    a=ad;
                    System.out.println("Hello, " + ad.getName() + "!");
                    ad.Saving(" logged into the system");
                    foundP= true;
                    break;
                }

            }
        }
        if(foundP)
            adminActions(a);
        if(!foundP&&!foundL){
            System.out.println("You haven't been registered yet. If you want to register print 𝖱𝖤𝖦.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            String choise=input.nextLine();
            while(!choise.toLowerCase().equals("exit")&&!choise.toLowerCase().equals("reg")) {
                choise=input.nextLine();
                System.out.println("𝖱𝖤𝖦 or 𝖤𝖷𝖨𝖳");
            }
            if (choise.toLowerCase().equals("exit"))
                starting();
            else if (choise.toLowerCase().equals("reg"))
                adminRegist(a);

        }
        if(!foundP&&foundL) {
            System.out.println("𝚆𝚁𝙾𝙽𝙶 𝙻𝙾𝙶𝙸𝙽 𝙾𝚁 𝙿𝙰𝚂𝚂𝚆𝙾𝚁𝙳");
            userMode(a);
        }


    }
    private static void adminActions(Admin i) {
        System.out.println("SELECT COMMAND CODE:\n1. Add user\n2. Delete user\n3. Change user information\n4. 𝗘𝗫𝗜𝗧");
        System.out.print("𝖢𝖮𝖣𝖤:");
        int a=input.nextInt();
        input.nextLine();
        while (a!=1&&a!=2&&a!=3&&a!=4) {
            adminActions(i);
        }
        switch (a){
            case 1:
                adminAdd(i);
                adminActions(i);
                break;
            case 2:
                adminDel(i);
                adminActions(i);
                break;
            case 3:
                adminChangeInfo(i);
                adminActions(i);
                break;
            case 4:
                userMode(i);
                break;
        }

    }
    private static void adminChangeInfo(Admin i) {
        System.out.println("Choose the code of user whose information" +
                "\nyou want to change:\n1. STUDENT\n2. TEACHER\n3. MANAGER\n4. EXECUTOR\n5. 𝗘𝗫𝗜𝗧");
        System.out.print("𝖢𝖮𝖣𝖤:");
        String s=input.nextLine();
        while(s.isEmpty()) {
            s=input.nextLine();

        }
        int a= Integer.parseInt(s);
        while (a!=1&&a!=2&&a!=3&&a!=4&&a!=5) {
            s=input.nextLine();
            a=Integer.parseInt(s);
        }
        switch (a){
            case 1:
                i.updateUserInfo(new Student());
                break;
            case 2:
                i.updateUserInfo(new Teacher());
                break;
            case 3:
                i.updateUserInfo(new Manager());
                break;
            case 4:
                i.updateUserInfo(new Executor());
                break;
            case 5:
                adminActions(i);
        }

    }
    private static void adminAdd(Admin i) {
        System.out.println("Choose the code of user you want to add:\n1. STUDENT\n2. TEACHER\n3. MANAGER\n4. EXECUTOR\n5. 𝗘𝗫𝗜𝗧");
        System.out.print("𝖢𝖮𝖣𝖤:");
        int a=input.nextInt();

        while (a!=1&&a!=2&&a!=3&&a!=4&&a!=5) {
            a=input.nextInt();
        }
        input.nextLine();
        //Admin i=new Admin();
        switch (a){
            case 1:
                i.addUser(new Student());
                break;
            case 2:
                i.addUser(new Teacher());
                break;
            case 3:
                i.addUser(new Manager());
                break;
            case 4:
                i.addUser(new Executor());
                break;
            case 5:
                adminActions(i);
        }
    }
    private static void adminDel(Admin i) {
        System.out.println("Choose the code of user you want to delete:\n1. STUDENT\n2. TEACHER\n3. MANAGER\n4. EXECUTOR\n5. 𝗘𝗫𝗜𝗧");
        System.out.print("𝖢𝖮𝖣𝖤:");
        int a=input.nextInt();
        while (a!=1&&a!=2&&a!=3&&a!=4&&a!=5) {
            a=input.nextInt();
        }
        input.nextLine();
        //Admin i=new Admin();
        switch (a){
            case 1:
                i.deleteUser(new Student());
                break;
            case 2:
                i.deleteUser(new Teacher());
                break;
            case 3:
                i.deleteUser(new Manager());
                break;
            case 4:
                i.deleteUser(new Executor());
                break;
            case 5:
                adminActions(i);
        }
    }
    
    

    private static void viewExecutors(Executor a) {
        boolean foundL=false,foundP=false;
        for(Executor ad:d.executors) {
            if (ad.getLogin().equals(a.getLogin())) {
                foundL=true;
                if(ad.getPassword().equals(a.getPassword())) {
                    a=ad;
                    System.out.println("Hello, " + ad.getName() + "!");
                    ad.Saving(" logged into the system");
                    foundP= true;
                    break;
                }

            }
        }
        if(foundP)
            exActions(a);
        if(!foundP&&!foundL){
            System.out.println("You haven't been registered yet.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            String choise=input.nextLine();
            while(!choise.toLowerCase().equals("exit")) {
                choise=input.nextLine();
                System.out.println("𝖤𝖷𝖨𝖳");
            }
            starting();


        }
        if(!foundP&&foundL) {
            System.out.println("𝚆𝚁𝙾𝙽𝙶 𝙻𝙾𝙶𝙸𝙽 𝙾𝚁 𝙿𝙰𝚂𝚂𝚆𝙾𝚁𝙳");
            userMode(a);
        }
    }
    private static void exActions(Executor i) {
        System.out.println("SELECT COMMAND CODE:\n1. View new orders\n2. View done orders\n3. View accepted orders\n4. View all orders\n5. 𝗘𝗫𝗜𝗧");
        System.out.print("𝖢𝖮𝖣𝖤:");
        int a=input.nextInt();
        input.nextLine();
        while (a!=1&&a!=2&&a!=3&&a!=4&&a!=5) {
            exActions(i);
        }
        switch (a){
            case 1:
                i.viewNewOrders();
                    exActions(i);
                break;
            case 2:
                i.viewDoneOrd();
                exActions(i);
                break;
            case 3:
               i.viewAcceptedOrd();
                exActions(i);
                break;
            case 4:
                i.viewAcceptedOrd();
                exActions(i);
                break;
            case 5:
                userMode(i);
                break;
        }

    }
    


    public static void main(String[] args){
        Data.get();
        System.out.println(Data.courses.size());
        starting();



    }
}
