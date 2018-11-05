package lab5.second;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
    public ArrayList<Textbook> books=new ArrayList<>();
    public ArrayList<Instructor> teachers=new ArrayList<>();
    public ArrayList<Course> courses=new ArrayList<>();
}
