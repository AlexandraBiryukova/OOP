package sis3;

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
                adminMode();
                break;
            case "student":
                System.out.println("Hello, Student!");
                break;
            case "teacher":
                System.out.println("Hello, Teacher!");
                break;
            case "executor":
                System.out.println("Hello, Executor!");
                break;
            case "exit":
                Data.save();
                break;
            default:
                starting();

        }

    }
    private static void adminRegist(Admin a){
        String s = "";
        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        System.out.println("Please fill next fields:");
        while (s.isEmpty()) {
            System.out.println("𝖭𝖠𝖬𝖤: ");
            s = input.nextLine();
            if (s.isEmpty())
                System.out.println("INCORRECT TYPE OF NAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            if(s.toLowerCase().equals("exit"))
                return;
        }
        a.setName(s);
        s="";
        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        while (s.isEmpty()) {
            System.out.println("𝖲𝖴𝖱𝖭𝖠𝖬𝖤: ");
            s = input.nextLine();
            if (s.isEmpty())
                System.out.println("INCORRECT TYPE OF SURNAME\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            if(s.toLowerCase().equals("exit"))
                return;
        }
        a.setSurname(s);
        s="";
        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        while (s.isEmpty()) {
            System.out.println("𝖯𝖧𝖮𝖭𝖤 𝖭𝖴𝖬𝖡𝖤𝖱: ");
            s= input.nextLine();
            if (s.isEmpty())
                System.out.println("INCORRECT TYPE OF PHONE NUMBER\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            if(s.toLowerCase().equals("exit"))
                return;
        }
        a.setPhoneNumber(s);
        s="";
        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        while (s.isEmpty()||Integer.parseInt(s)==0) {
            System.out.println("𝖸𝖤𝖠𝖱 𝖮𝖥 𝖶𝖮𝖱𝖪 𝖮𝖱 𝖲𝖳𝖴𝖣𝖸: ");
            s= input.nextLine();
            if (Integer.parseInt(s)==0)
                System.out.println("INCORRECT TYPE OF YEAR\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            if(s.toLowerCase().equals("exit"))
                return;
        }
        a.setYearOfWorkOrStudy(Integer.parseInt(s));
        d.admins.add(a);
        a.Saving(" logged into the system");
        //System.out.println(Data.admins.size());
        Data.save();

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
            System.out.println("You haven't been registered yet. If you want to register print 𝖱𝖤𝖲.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            String choise="";
            while(!choise.equals("exit")&&!choise.equals("res")) {
                choise=input.nextLine();
                if (choise.toLowerCase().equals("exit"))
                    starting();
                else if (choise.toLowerCase().equals("res"))
                    adminRegist(a);
                else
                    System.out.println("𝖱𝖤𝖲 or 𝖤𝖷𝖨𝖳");
            }

        }
        if(!foundP&&foundL) {
            System.out.println("𝚆𝚁𝙾𝙽𝙶 𝙻𝙾𝙶𝙸𝙽 𝙾𝚁 𝙿𝙰𝚂𝚂𝚆𝙾𝚁𝙳");
            adminMode();
        }


    }

    private static void adminActions(Admin i) {
        System.out.println("SELECT COMMAND CODE:\n1. Add user\n2. Delete user\n3. Change user information\n4. 𝗘𝗫𝗜𝗧");
        System.out.print("𝖢𝖮𝖣𝖤:");
        int a=input.nextInt();
        while (a!=1&&a!=2&&a!=3&&a!=4) {
            adminActions(i);
        }
        switch (a){
            case 1:
                adminAdd(i);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                starting();
        }

    }

    private static void adminAdd(Admin i) {
        System.out.println("Choose the code of user you want to add:\n1. STUDENT\n2. TEACHER\n3. MANAGER\n4. EXECUTOR\n5. 𝗘𝗫𝗜𝗧");
        System.out.print("𝖢𝖮𝖣𝖤:");
        int a=input.nextInt();
        while (a!=1&&a!=2&&a!=3&&a!=4&&a!=5) {
            a=input.nextInt();
        }
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
                return;
        }
    }

    private static void adminMode() {
        System.out.println("(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
        System.out.print("𝖫𝖮𝖦𝖨𝖭: ");
        String alog=input.nextLine();
        if(alog.toLowerCase().equals("exit"))
            starting();
        System.out.print("𝖯𝖠𝖲𝖲𝖶𝖮𝖱𝖣: ");
        String apas=input.nextLine();
        if(apas.toLowerCase().equals("exit"))
            starting();
        Admin user=new Admin();
        user.setLogin(alog);
        user.setPassword(apas);
        viewAdmins(user);

    }


    public static void main(String[] args){
        Data.get();
        starting();



    }
}
