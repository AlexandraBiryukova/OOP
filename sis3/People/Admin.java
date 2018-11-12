package sis3.People;

import sis3.*;
import sis3.Objects.*;

public class Admin extends Employee {
    public Admin(){
        super();
    }

    public void addUser(Object o){
        if(o instanceof Teacher){
            Teacher t=(Teacher)o;
            t.save();
        }
        if(o instanceof Student){
            Student t=(Student)o;
            t.save();
        }
        if(o instanceof Manager){
            Manager t=(Manager)o;
            t.save();
        }
    }
    public void deleteUser(Object o){
        if(o instanceof Teacher){
            Teacher t=(Teacher)o;
            for (Course c:
                 Data.courses) {
                c.getTutors().remove(t);
            }
            Data.teachers.remove(t);
        }
        if(o instanceof Student){
            Student t=(Student)o;
            Data.students.remove(t);
            for(Course c:Data.courses){
                c.getStudents().remove(t);
            }
        }
        if(o instanceof Manager){
            Manager t=(Manager)o;
            Data.managers.remove(t);
        }
        Data.save();

    }

}
