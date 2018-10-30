package week9.first.Abstact;

public abstract class Shape3D {
    double side;
    double height;
    final static double PI=3.14;
    public Shape3D(){
        side=0;
        height=0;
    }
    public Shape3D(double s,double h){
        side=s;
        height=h;
    }
    public abstract double volume();
    public abstract double surfaceArea();

}
