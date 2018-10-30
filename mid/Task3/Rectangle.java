package mid.Task3;


public class Rectangle extends Shape{
    protected double length;
    protected double width;
    public Rectangle(){
        super();
        width=0;
        length=0;
    }
    public Rectangle(double width,double length){
        super();
        this.width=width;
        this.length=length;
    }
    public Rectangle(double width,double length,String color,boolean filled){
        super(color,filled);
        this.length=length;
        this.width=width;
    }
    public double getWidth(){return width;}
    public void setWidth(double width){this.width=width;}
    public double getLength(){return length;}
    public void setLength(double length){this.length=length;}
    public double getArea(){
        return width*length;
    }
    public double getPerimeter(){
        return 2*(length+width);
    }
    public String toString(){
        return "Rectangle with sides "+length+" and "+ width+" "+super.toString();
    }
    public boolean equals(Object o){
        if(o instanceof Rectangle){
            Rectangle r=(Rectangle)o;
            if(r.width==width&&r.length==length){
                return true;
            }
            return false;
        }
        return false;
    }


}

