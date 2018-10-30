package week9.third;
import com.sun.javafx.tools.packager.PackagerException;

import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, ParseException {
        Manager e=new Manager("Alex",100,new Date(15,9,2000),"A1",5,new Vector());
        Manager e2=e.clone();
        e.setName("Alexandra");
        e2.setSalary(80);
        System.out.println(e.toString());
        System.out.println(e2.toString());

    }
}
