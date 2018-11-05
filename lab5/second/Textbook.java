package lab5.second;

import java.io.*;
import java.util.ArrayList;

public class Textbook implements Serializable {
    private String isbn;
    private String title;
    private String author;
    //public static ArrayList<Textbook> list=new ArrayList<>();
    public Textbook(){
        isbn="---";
        title="---";
        author="---";
    }
    public Textbook(String isbn,String title,String author, Data d){
        this.author=author;
        this.isbn=isbn;
        this.title=title;
        //list.add(this);
        d.books.add(this);
    }
    public void setIsbn(String isbn){this.isbn=isbn;}
    public String getIsbn(){return isbn;}
    public void setTitle(String title){this.title=title;}
    public String getTitle(){return title;}
    public void setAuthor(String author){this.author=author;}
    public String getAuthor(){return author;}

    @Override
    public String toString() {
        return "¶ "+isbn+" “"+title+"” :::"+author;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Textbook){
            Textbook t=(Textbook)obj;
            if(t.author.equals(author)&&t.title.equals(title)&&t.isbn.equals(isbn))
                return true;
            return false;
        }
        return false;
    }

}
