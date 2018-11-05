package lab5.first;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Student implements Serializable {
    public String name;
    public String surname;
    public int score;
    public static ArrayList<Student> students=new ArrayList<Student>();
    public static TreeSet<Integer> scores=new TreeSet<>();
    public Student(){
        name="";
        surname="";
    }
    public Student(String s,String s2, int score){
        name=s;
        surname=s2;
        this.score=score;
        scores.add(score);
        students.add(this);
    }
    public String toString(){
        return surname +" "+name;
    }
}
