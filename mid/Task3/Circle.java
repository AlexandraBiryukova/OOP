package Task3;

public class Circle extends Shape{
    protected double radius;
    public Circle(){
        super();
        radius=0;
    }
    public Circle(double radius){
        super();
        this.radius=radius;
    }
    public Circle(double radius,String color,boolean filled){
        super(color,filled);
        this.radius=radius;
    }
    public double getRadius(){return radius;}
    public void setRadius(double radius){this.radius=radius;}
    public double getArea(){
        return 3.14*radius*radius;
    }
    public double getPerimeter(){
        return 6.28*radius;
    }
    public String toString(){
        return "Circle with radius "+radius+" "+super.toString();
    }
    public boolean equals(Object o){
        if(o instanceof Circle){
            Circle c=(Circle)o;
            if(c.radius==radius)
                return true;
            return false;
        }
        return false;
    }


}
