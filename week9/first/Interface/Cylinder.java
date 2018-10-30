package week9.first.Interface;


public class Cylinder implements Shape3D {
    double height;
    double radius;
    public Cylinder(double h,double r){
        radius=r;
        height=h;
    }
    @Override
    public double surfaceArea() {
        return 2*PI*radius*radius+2*PI*radius*height;
    }

    @Override
    public double volume() {
        return PI*radius*radius*height;
    }
}
