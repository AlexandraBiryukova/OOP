package sis3.Objects;

import java.io.Serializable;

public class Mark implements Serializable {
    private double value;
    private Course course;
    public Mark(){
        value=0;
        course=new Course();
    }
    public Mark(double v,Course s){
        value=v;
        course=s;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value+"";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Mark){
            Mark m=(Mark)obj;
            if(m.value==value)
                return true;
        }
        return false;
    }
}
