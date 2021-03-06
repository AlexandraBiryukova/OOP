package sis3.People;

import sis3.Interfaces.ActionSaving;
import sis3.MarkException;
import sis3.Storage.Data;
import sis3.Enum.Departments;
import sis3.Interfaces.MakingOrder;
import sis3.Objects.Course;
import sis3.Objects.CourseFile;
import sis3.Objects.Mark;
import sis3.Enum.TeacherStatuses;
import sis3.Objects.Order;

import java.io.*;
import java.util.*;

public class Teacher extends Employee implements MakingOrder,ActionSaving {
    private TeacherStatuses status;
    private Departments department;
    private TreeSet<Course> courses;
    private Vector<String> messages;

    public Teacher(){
        super();
        status=TeacherStatuses.NONE;
        department=Departments.NONE;
        courses=new TreeSet<>();
        messages=new Vector<>();
    }
    public Teacher(String n,String s,String l,String p, String num,int year,Departments d,TeacherStatuses t,TreeSet<Course> v){
        super(n,s,l,p,num,year);
        status=t;
        department=d;
        courses=v;
    }

    public Vector<String> getMessages() {
        return messages;
    }

    public void setMessages(Vector<String> messages) {
        this.messages = messages;
    }

    public Departments getDepartment() {
        return department;
    }

    public TeacherStatuses getStatus() {
        return status;
    }

    public TreeSet<Course> getCourses() {
        return courses;
    }

    public void setCourses(TreeSet<Course> courses) {
        if(Data.courses.containsAll(courses))
            this.courses = courses;
        else
            System.out.println("Not all courses are registered in the system");
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public void setStatus(TeacherStatuses status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString()+" "+department+" "+ status;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Teacher){
            Teacher t=(Teacher)obj;
            if(super.equals((Employee)t)){
                if(t.courses.toString().equals(courses.toString())&&t.department==department&&t.status==status)
                    return true;
            }
        }
        return false;
    }
    @Override
    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Teacher){
            Teacher t=(Teacher)o;
            if(super.compareTo((User)t)==0) {
                if (t.department.compareTo(department) == 0) {
                    if(t.status.compareTo(status)==0){
                        return t.courses.toString().compareTo(courses.toString());

                    }else
                        return t.status.compareTo(status);

                }else
                    return t.department.compareTo(department);
            }else
                return super.compareTo((User)t);
        }
        return -1;
    }

    @Override
    public Teacher clone() throws CloneNotSupportedException {
        Teacher t = (Teacher) super.clone();
        t.setLogin(getLogin());
        t.setName(getName());
        t.setPassword(getPassword());
        t.setPhoneNumber(getPhoneNumber());
        t.setYearOfWorkOrStudy(getYearOfWorkOrStudy());
        t.setSurname(getSurname());
        t.courses=this.courses;
        t.department=this.department;
        t.status=this.status;
        return t;
    }

    public void save(String inf){
        Data.save();
        if(inf.equals(" is added to the system ")) {
            System.out.println("SAVED");
            Data.teachers.add(this);
            this.Saving(inf);
        }else{
            if(inf.contains("changed")){
                System.out.println("CHANGED");
                Data.save();
                this.Saving(inf);
            }else if(inf.contains(" is added to the course")||inf.contains("own")){
                System.out.println("ADDED");
                Data.save();
                this.Saving(inf);
            } else if(inf.contains("received")){
                System.out.println("SENT");
                Data.save();
                this.Saving(inf);
            }else if(inf.contains("deleted file")){
                System.out.println("DELETED");
                Data.save();
                this.Saving(inf);
            }
            else if(inf.contains("file")){
                System.out.println("ADDED");
                Data.save();
                this.Saving(inf);
            }
            else if(inf.contains("order")){
                System.out.println("SENT");
                Data.save();
                this.Saving(inf);
            }
            else if(inf.contains("mark")){
                System.out.println("NEW MARK HAS BEEN ADDED");
                Data.save();
                this.Saving(inf);
            }
            else{
                System.out.println("DELETED");
                Data.teachers.remove(this);
                Data.save();
                this.Saving(inf);
            }
        }

    }
    public void get(){
        Data r =new Data();
        //r=Data.get(r);
        for (Teacher t:Data.teachers
             ) {
            System.out.println(t);

        }

    }
    public void showMessages(){
        if(messages.size()>0) {
            for (String s : messages) {
                System.out.println("𝗆𝖾𝗌𝗌𝖺𝗀𝖾:");
                System.out.println(s);
            }
        }else
            System.out.println("No messages");

    }



    public void viewStudentsofCourse(){
        System.out.println("𝖢𝖮𝖴𝖱𝖲𝖤𝖲:");
        String s;
        Scanner inp=new Scanner(System.in);
        if(Data.courses.size()>0) {
            for (Course t : Data.courses) {
                System.out.println(t);
            }
            System.out.println("Choose the title (CASE SENSITIVE) of course from which you want to view students:");
            boolean found = false;
            while (!found) {
                System.out.print("𝖳𝖨𝖳𝖫𝖤: ");
                s = inp.nextLine();
                while (s.isEmpty()) {
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    s = inp.nextLine();
                }
                if (s.toLowerCase().equals("exit"))
                    return;
                boolean b = false;
                for (Course t : Data.courses) {
                    if (t.getCourseTitle().equals(s)) {
                        if(t.getStudents().size()>0) {
                            for (Student ss : t.getStudents())
                                System.out.println(ss);
                        }else
                            System.out.println("No registered students");
                        b = true;
                        break;
                    }
                }
                if (b)
                    found = true;
                else {
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                }
            }
        }else{
            System.out.println("You haven't got any courses.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            s = inp.nextLine();
            while(!s.toLowerCase().equals("exit")) {
                System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
                s = inp.nextLine();
            }
        }




    }

    public void viewOwnCourses(){
        System.out.println("My courses:");
        if(courses.size()>0) {
            for (Course s : courses) {
                System.out.println(s.toString());

            }
        }else{
            System.out.println("You haven't got any courses");
        }
    }
    public void addCourse(Course s){
        courses.add(s);
    }
    public void addOwnCourse(){
        Course c=new Course();
        Scanner inp=new Scanner(System.in);
        System.out.print("𝖢𝖮𝖴𝖱𝖲𝖤 𝖳𝖨𝖳𝖫𝖤:");
        String s=inp.nextLine();
        while(Data.courseNames.contains(s)||s.isEmpty()){
            if(s.isEmpty())
                System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            else
                System.out.println("Course with that title already exists in the system.\nChoose another title:");
            System.out.print("𝖢𝖮𝖴𝖱𝖲𝖤 𝖳𝖨𝖳𝖫𝖤:");
            s=inp.nextLine();
        }
        if (s.toLowerCase().equals("exit"))
            return;
        c.setCourseTitle(s);
        System.out.println("𝖣𝖤𝖯𝖠𝖱𝖳𝖬𝖤𝖭𝖳:");
        System.out.println("1.FIT\n2.BS\n3.FGE\n4.CMC\n5.KMA\n6.FGOGI\n7.ISE\n8.NONE");
        int a=inp.nextInt();
        while(!(a>=1&&a<=8)){
            System.out.println("1.FIT\n2.BS\n3.FGE\n4.CMC\n5.KMA\n6.FGOGI\n7.ISE\n8.NONE");
            a=inp.nextInt();
            inp.nextLine();
        }

        for(Departments d:Departments.values() ){
            if(d.ordinal()==a-1){
                c.setDepartment(d);
                break;
            }
        }
        c.addTeacher(this);
        this.courses.add(c);
        Data.courses.add(c);
        Data.courseNames.add(c.getCourseTitle());
        this.save(" added own course " + c.getCourseTitle());


        }
    public void addCourseFile(){
        System.out.println("𝖸𝖮𝖴𝖱 𝖢𝖮𝖴𝖱𝖲𝖤𝖲:");
        String s;
        Scanner inp=new Scanner(System.in);
        if(courses.size()>0) {
            for (Course t : courses) {
                System.out.println(t);
            }
            System.out.println("Choose the title (CASE SENSITIVE) of course you want to add file in:");
            boolean found = false;
            while (!found) {
                System.out.print("𝖳𝖨𝖳𝖫𝖤: ");
                s = inp.nextLine();
                while (s.isEmpty()) {
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    s = inp.nextLine();
                }
                if (s.toLowerCase().equals("exit"))
                    return;
                boolean b = false;
                for (Course t : courses) {
                    if (t.getCourseTitle().equals(s)) {
                        System.out.println("FILE NAME:");
                        s=inp.nextLine();
                        while(s.isEmpty()){
                            System.out.println("Wrong text format\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                            System.out.print("𝖢𝖮𝖴𝖱𝖲𝖤 𝖳𝖨𝖳𝖫𝖤:");
                            s=inp.nextLine();
                        }
                        if (s.toLowerCase().equals("exit"))
                            return;
                        CourseFile f=new CourseFile(new File(s));
                        Data.courses.remove(t);
                        t.addFile(f);
                        Data.courses.add(t);
                        this.save("added new file to the course "+t.getCourseTitle());
                        b = true;
                        break;
                    }
                }
                if (b)
                    found = true;
                else {
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                }
            }
        }else{
            System.out.println("You haven't got any courses.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            s = inp.nextLine();
            while(!s.toLowerCase().equals("exit")) {
                System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
                s = inp.nextLine();
            }
        }

    }
    public void deleteCourseFile(){
        System.out.println("𝖸𝖮𝖴𝖱 𝖢𝖮𝖴𝖱𝖲𝖤𝖲:");
        String s;
        Scanner inp=new Scanner(System.in);
        if(courses.size()>0) {
            for (Course t : courses) {
                System.out.println(t);
            }
            System.out.println("Choose the title of course you want to delete file from:");
            boolean found = false;
            while (!found) {
                System.out.print("𝖳𝖨𝖳𝖫𝖤: ");
                s = inp.nextLine();
                while (s.isEmpty()) {
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    s = inp.nextLine();
                }
                if (s.toLowerCase().equals("exit"))
                    return;
                boolean b = false;
                for (Course t : courses) {
                    if (t.getCourseTitle().equals(s)) {
                        System.out.println(t.getFiles().size());
                        if (t.getFiles().size() > 0) {
                            System.out.println("Choose the title of courseFile you want to delete :");
                            boolean found2 = false;
                            while (!found2) {
                                System.out.print("𝖳𝖨𝖳𝖫𝖤: ");
                                s = inp.nextLine();
                                while (s.isEmpty()) {
                                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                    s = inp.nextLine();
                                }
                                if (s.toLowerCase().equals("exit"))
                                    return;
                                boolean b2 = false;
                                for (CourseFile cc : t.getFiles()) {
                                    if (cc.getFile().toString().equals(s)) {
                                        Data.courses.remove(t);
                                        t.deleteFile(cc);
                                        Data.courses.add(t);
                                        this.save("deleted file from the course " + t.getCourseTitle());
                                        b2 = true;
                                        break;
                                    }
                                }
                                if (b2) {
                                    found2 = true;
                                    b=true;
                                }
                            }
                        } else {
                            System.out.println("There are no files in this course");
                            b = true;
                            break;
                        }
                    }
                }
                if (b)
                    found = true;
                else
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");

            }
        }else{
            System.out.println("You haven't got any courses.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            s = inp.nextLine();
            while(!s.toLowerCase().equals("exit")) {
                System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
                s = inp.nextLine();
            }
        }


    }
    public void setMark(Course c,Student s)throws MarkException {
        Scanner inp=new Scanner(System.in);
        System.out.println("Mark:");
        double d=inp.nextDouble();
        inp.nextLine();
        if(d<0||d>100)
            throw new MarkException();
        else{
            Data.students.remove(s);
            Mark m=new Mark(d,c);
            Vector<Mark> v=s.getMarks();
            v.add(m);
            s.setMarks(v);
            Data.students.add(s);


        }


    }
    public void joinCourse(){
        System.out.println("𝖢𝖮𝖴𝖱𝖲𝖤𝖲:");
        String s;
        Scanner inp=new Scanner(System.in);
        if(Data.courses.size()>0) {
            for (Course t : Data.courses) {
                System.out.println(t);
            }
            System.out.println("Choose the title (CASE SENSITIVE) of course:");
            boolean found = false;
            while (!found) {
                System.out.print("𝖳𝖨𝖳𝖫𝖤: ");
                s = inp.nextLine();
                while (s.isEmpty()) {
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    s = inp.nextLine();
                }
                if (s.toLowerCase().equals("exit"))
                    return;
                boolean b = false;
                for (Course t : Data.courses) {
                    if (t.getCourseTitle().equals(s)) {
                        if(t.getTutors().contains(this)) {
                            System.out.println("You had already joined this course");
                            b=true;
                            break;
                        }
                        this.addCourse(t);
                        t.addTeacher(this);
                        b=true;
                        break;
                    }
                }
                if (b)
                    found = true;
                else {
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                }
            }
        }else{
            System.out.println("There are no courses in the system.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            s = inp.nextLine();
            while(!s.toLowerCase().equals("exit")) {
                System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
                s = inp.nextLine();
            }
        }




    }
    public void putMarks() {
        System.out.println("𝖸𝖮𝖴𝖱 𝖢𝖮𝖴𝖱𝖲𝖤𝖲:");
        String s;
        Scanner inp=new Scanner(System.in);
        if(courses.size()>0) {
            for (Course t : courses) {
                System.out.println(t);
            }
            System.out.println("Choose the title (CASE SENSITIVE) of course:");
            boolean found = false;
            while (!found) {
                System.out.print("𝖳𝖨𝖳𝖫𝖤: ");
                s = inp.nextLine();
                while (s.isEmpty()) {
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                    s = inp.nextLine();
                }
                if (s.toLowerCase().equals("exit"))
                    return;
                boolean b = false;
                for (Course t : courses) {
                    if (t.getCourseTitle().equals(s)) {
                        System.out.println("𝖲𝖳𝖴𝖣𝖤𝖭𝖳𝖲:");
                        System.out.println(t.getStudents().size());
                        if(t.getStudents().size()>0) {
                            for (Student st : t.getStudents()) {
                                System.out.println("𝗅𝗈𝗀𝗂𝗇:" + st.getLogin() + " " + st);
                            }
                            System.out.println("Choose the login (CASE SENSITIVE) of student:");
                            boolean found2 = false;
                            while (!found2) {
                                System.out.print("𝖫𝖮𝖦𝖨𝖭: ");
                                s = inp.nextLine();
                                while (s.isEmpty()) {
                                    System.out.println("UNKNOWN LOGIN\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                                    s = inp.nextLine();
                                }
                                if (s.toLowerCase().equals("exit"))
                                    return;
                                boolean b2 = false;
                                for (Student ts : t.getStudents()) {
                                    if (ts.getLogin().equals(s)) {
                                        b2=true;
                                        boolean b3=false;
                                        while(!b3) {
                                            b3=true;
                                            try {
                                                this.setMark(t, ts);
                                            } catch (MarkException m) {
                                                b3 = false;
                                                System.out.println(m.getMessage());
                                                System.out.println("PRESS ANY KEY TO TRY AGAIN");
                                                s = inp.nextLine();
                                            }
                                        }
                                        this.save("added new mark to student "+ts.getName()+" "+ts.getSurname());
                                        ts.save(" received new mark in course "+t.getCourseTitle());
                                        b2=true;
                                        b=true;
                                        break;
                                    }
                                }
                                if(b2)
                                    found2=true;
                            }

                        }else {
                            System.out.println("There are no students in this course");
                            while(!s.toLowerCase().equals("exit")) {
                                System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
                                s = inp.nextLine();
                            }
                            return;
                        }

                    }
                }
                if (b)
                    found = true;
                else {
                    System.out.println("UNKNOWN TITLE\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
                }
            }
        }else{
            System.out.println("You haven't got any courses.\n(𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳)");
            s = inp.nextLine();
            while(!s.toLowerCase().equals("exit")) {
                System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
                s = inp.nextLine();
            }
        }



    }
    public void sendOrder(){
        if(Data.executors.size()>0) {
            Scanner inp = new Scanner(System.in);
            Order o = new Order();
            System.out.println("𝖯𝖱𝖨𝖭𝖳 𝗘𝗫𝗜𝗧 𝖳𝖮 𝖤𝖷𝖨𝖳");
            System.out.print("ORDER TITLE:");
            String s = inp.nextLine();
            if (s.toLowerCase().equals("exit"))
                return;
            if (s.isEmpty())
                s = "none";
            o.setOrderTitle(s);
            o.setSender(this);
            System.out.println("ORDER TEXT:\n('.'- end of text)");
            String res = "";
            s = inp.nextLine();
            res+=s;
            while (!s.contains(".")) {
                res = res + s + " ";
                s = inp.nextLine();
            }
            if (res.isEmpty())
                res = "none";
            o.setOrderTextBody(res);
            Executor e=Data.executors.first();
            o.setExecutor(e);
            e.save(" received an order from "+this.getLogin());
            e.addOrder(o);
            this.save("sent order to executor");


        }else
            System.out.println("There are no executors in our system. Sorry.");


    }

    @Override
    public void Saving(String inf) {
        try {
            FileWriter to_file = new FileWriter("teachers.txt", true);
            BufferedWriter bw = new BufferedWriter(to_file);
            Date d = new Date();
            bw.write(d.toLocaleString().substring(0, d.toLocaleString().length() - 3));
            bw.write(" teacher "+this.getName()+" "+this.getSurname()+": "+inf+"\n");

            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
    public void addMess(String s){
        messages.add(s);
    }
}
