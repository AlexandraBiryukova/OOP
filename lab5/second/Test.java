package lab5.second;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.omg.PortableInterceptor.INACTIVE;

import javax.xml.soap.Text;
import java.util.Date;

import java.util.Scanner;
import java.io.*;
public class Test {
    static Data d = new Data();

    static void addSavings(String inf) {

        try {
            FileWriter to_file = new FileWriter("admin.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write(" " + inf);

            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }


    }

    static void addCourse() {
        System.out.println("Course:");
        try {
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);

            FileOutputStream out = new FileOutputStream("data.ser");
            ObjectOutputStream os = new ObjectOutputStream(out);
            String s, s1, s2, s3, s4, s5, s6, s7;
            System.out.print("COURSE TITLE: ");
            s = br.readLine();
            System.out.println("BOOK of the course:");
            System.out.print("ISBN: ");
            s1 = br.readLine();
            System.out.print("TITLE: ");
            s2 = br.readLine();
            System.out.print("AUTHOR: ");
            s3 = br.readLine();
            System.out.println("INSTRUCTOR of the course:");
            System.out.print("First name: ");
            s4 = br.readLine();
            System.out.print("Last name: ");
            s5 = br.readLine();
            System.out.print("Department: ");
            s6 = br.readLine();
            System.out.print("E-mail: ");
            s7 = br.readLine();
            Textbook t = new Textbook(s1, s2, s3, d);
            Instructor i = new Instructor(s4, s5, s6, s7, d);
            Course c = new Course(s, t, i, d);
            //System.out.println(d.courses.size());
            //System.out.println(c);
            addSavings("admin added new course “" + c.getCourseTitle() + "”\n");
            addSavings("admin added new book “" + t.getTitle() + "” in course " + c.getCourseTitle() + "\n");
            addSavings("admin added new instructor: " + i.getFirstName() + " " + i.getLastName() + " in course " + c.getCourseTitle() + "\n");


            os.writeObject(d);
            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println("oops");
        }

        System.out.println("SAVED");
    }

    static void addBook() {
        System.out.print("Book:\n");
        try {
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);

            FileOutputStream out = new FileOutputStream("data.ser");
            ObjectOutputStream os = new ObjectOutputStream(out);
            String s1, s2, s3;
            System.out.print("ISBN: ");
            s1 = br.readLine();
            System.out.print("TITLE: ");
            s2 = br.readLine();
            System.out.print("AUTHOR: ");
            s3 = br.readLine();

            Textbook t = new Textbook(s1, s2, s3, d);
            addSavings("admin added new book “" + t.getTitle() + "”\n");
            os.writeObject(d);
            os.flush();
            os.close();
            //br.close();
        } catch (Exception e) {
            System.out.println("oops\n");
        }

        System.out.print("SAVED\n");
    }

    static void addInstructor() {
        System.out.println("Instructor:");
        try {
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);

            FileOutputStream out = new FileOutputStream("data.ser");
            ObjectOutputStream os = new ObjectOutputStream(out);
            String s1, s2, s3, s4;
            System.out.print("First name: ");
            s1 = br.readLine();
            System.out.print("Last name: ");
            s2 = br.readLine();
            System.out.print("Department: ");
            s3 = br.readLine();
            System.out.print("E-mail: ");
            s4 = br.readLine();


            Instructor t = new Instructor(s1, s2, s3, s4, d);
            addSavings("admin added new instructor: " + t.getFirstName() + " " + t.getLastName() + "\n");
            os.writeObject(d);
            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println("oops");
        }
        System.out.println("SAVED");
    }

    static void showCourse(Boolean b,Boolean user,String s) {
        try {
            FileInputStream f = new FileInputStream("data.ser");
            ObjectInputStream o = new ObjectInputStream(f);
            d = (Data) o.readObject();
            //System.out.println(d.courses.size());
            if (b == true) {
                for (Course t : d.courses
                ) {
                    if(user==false) {
                        System.out.println("➢ " + t.getCourseTitle().toUpperCase());

                    }
                    if(user==true){
                        if(t.getCourseTitle().equals(s)) {
                            System.out.println("Course book: " + t.getBook());
                            System.out.println("Course instructor: " + t.getTeacher());
                        }

                    }
                }

            }


            o.close();


        } catch (Exception e) {
            System.out.println("oops");
        }
    }

    static String knowPas(String password) {
        String res = null;

        try {
            FileWriter pas_file = new FileWriter("password.txt", true);
            BufferedWriter pw = new BufferedWriter(pas_file);
            FileReader pas_r = new FileReader("password.txt");
            BufferedReader pr = new BufferedReader(pas_r);


            String s = pr.readLine();
            //System.out.println(s);
            if (s == null) {
                res = password;
                pw.write(password);
            } else {
                res = s;
            }
            pr.close();
            pw.close();


        } catch (Exception e) {
            System.out.println("I don't know the password");
        }
        return res;

    }

    static boolean adminFile(String name, String password, String pas, Scanner input) {
        boolean success = false;
        // while (success != true) {
        try {
            FileWriter to_file = new FileWriter("admin.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            FileReader from_file = new FileReader("admin.txt");
            BufferedReader br = new BufferedReader(from_file);
            String passw = knowPas(password);

            String s = br.readLine();

            if (s == null) {
                bw.write("Username: " + name + "\n" + "Password: " + pas + "\n");
                Date d = new Date();
                bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3) + " admin logged into a system\n");
                success = true;
            } else {
                if (!s.split(": ")[1].equals(name)) {
                    System.out.println("WRONG NAME");
                    hiAdmin(input, false);
                } else {
                    if (!passw.equals(password)) {
                        System.out.println("WRONG PASSWORD");
                        hiAdmin(input, false);
                    } else {
                        Date d = new Date();
                        bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3) + " admin logged into a system\n");
                        System.out.println("ACCESS IS ALLOWED");
                        success = true;
                    }
                }
            }
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println("error");
        }
        return success;

        //}
        //return success;


    }

    static boolean hiAdmin(Scanner input, boolean b) {
        while (b != true) {
            System.out.print("Username: ");
            String admin = input.nextLine();
            if (!admin.isEmpty()) {
                System.out.print("Password: ");
                String pass = input.nextLine();
                if (!pass.isEmpty()) {
                    String password = String.valueOf(pass.hashCode());
                    b = adminFile(admin, pass, password, input);
                    return b;
                }
            }

        }
        return b;

    }

    public static void main(String[] args) {
        showCourse(false,false,"");
        System.out.print("Choose the mode: User or Admin."+"\nMode: ");
        Scanner input = new Scanner(System.in);
        String mode = input.nextLine();
        if (mode.toLowerCase().equals("user")) {
            while (!mode.equals("EXIT")) {
                System.out.println("PRINT V : View the list of available course\n" +
                        "PRINT D::courseTitle : Display information about the course\n" +
                        "PRINT EXIT: Return to choosing the mode");
                mode = input.nextLine();
                if (mode.equals("V")) {
                    System.out.println("Courses:");
                    showCourse(true,false,"");


                } else if (mode.split("::")[0].equals("D")){
                    System.out.println("Course title: ➢ "+mode.split("::")[1]);
                    showCourse(true,true,mode.split("::")[1]);
                }

            }
            Test.main(args);
        } else if (mode.toLowerCase().equals("admin")) {
            hiAdmin(input, false);
            System.out.print("WELCOME!\n");
            while (!mode.equals("EXIT")) {
                if (mode.equals("BOOK")) {
                    addBook();
                }
                else if (mode.equals("COURSE")) {
                    addCourse();
                }
                else if (mode.equals("INSTRUCTOR")) {
                    addInstructor();

                }
                System.out.println("You can add:\nBook by command: BOOK\nInstructor by command: INSTRUCTOR\nCourse by command: COURSE\nEXIT - Save and Return to choosing mode\nYour command:");

                mode=input.nextLine();


            }
                Test.main(args);
            }
        }
    }

