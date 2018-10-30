package week9.first.Interface;

public class Sphere implements Shape3D {
    double radius;
    public Sphere(){};
    public Sphere(double r){
        radius=r;
    }

    @Override
    public double volume() {
        return 4/3*PI*radius*radius*radius;
    }

    @Override
    public double surfaceArea() {
        return 4*PI*radius*radius;
    }
}
