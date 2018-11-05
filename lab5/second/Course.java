package lab5.second;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseTitle;
    private Textbook book;
    private Instructor teacher;
    public Course(){
        courseTitle="---";
        book=new Textbook();
        teacher=new Instructor();
    }
    public Course(String title,Textbook t,Instructor i,Data d){
        courseTitle=title;
        book=t;
        teacher=i;
        d.courses.add(this);
    }

    public void setCourseTitle(String courseTitle) { this.courseTitle = courseTitle; }
    public String getCourseTitle() { return courseTitle;}
    public Instructor getTeacher() { return teacher; }
    public void setTeacher(Instructor teacher) { this.teacher = teacher; }
    public Textbook getBook() { return book; }
    public void setBook(Textbook book) { this.book = book; }

    @Override
    public String toString() {
        return "COURSE TITLE: "+courseTitle+"\n   COURSE TEACHER: "+teacher+"\n   COURSE BOOK"+book;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Course){
            Course s=(Course)obj;
            if(courseTitle.equals(s.courseTitle)&&s.teacher.equals(teacher)&&s.book.equals(book))
                return true;
            return false;
        }
        return false;
    }
}
