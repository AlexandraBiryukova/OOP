package lab5.first;
import java.io.*;
public class Problem {
    static void fromFile(){
        try {
            FileReader from_file = new FileReader("scores.txt");
            BufferedReader ois=new BufferedReader(from_file);
            String ss=ois.readLine();
            while(ss!=null){
                String[] list=ss.split(" ");
                Student s=new Student(list[0],list[1],Integer.parseInt(list[2]));
                ss=ois.readLine();
            }
            ois.close();
        }catch(Exception e){
            System.out.println("error");
        }
    }
    static void Grading(){
        try {
            FileWriter to_file = new FileWriter("grades.txt");
            BufferedWriter bw=new BufferedWriter(to_file);
            String grade="";
            for (Student s:
                    Student.students) {
                if(Student.scores.last()-10<=s.score)
                    grade="- “A”\n";
                else if(Student.scores.last()-20<=s.score)
                    grade="- “B”\n";
                else if(Student.scores.last()-30<=s.score)
                    grade="- “C”\n";
                else if(Student.scores.last()-40<=s.score)
                    grade="- “D”\n";
                else
                    grade="- “F”\n";
                bw.write(s+grade);


            }
            bw.close();
        }catch(Exception e){
            System.out.println("error");
        }


    }
    static void Statistics(){
        try {
            FileWriter to_file = new FileWriter("grades.txt",true);
            BufferedWriter bw=new BufferedWriter(to_file);
            int mini=Student.scores.first(),maxi=Student.scores.last(),avg=0;
            for (Student s: Student.students
                 ) {
                avg+=s.score;
            }
            avg/=Student.students.size();
            bw.write("Avarage - "+avg+"\n");
            bw.write("Maximum - "+maxi+"\n");
            bw.write("Minimum - "+mini+"\n");


            bw.close();
        }catch(Exception e){
            System.out.println("error");
        }
    }
    public static void main(String [] args){
        fromFile();
        Grading();
        Statistics();



    }


}
