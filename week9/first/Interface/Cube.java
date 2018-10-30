package week9.first.Interface;

public class Cube implements Shape3D {
    double side;
    public Cube(double s){
        side=s;
    }

    @Override
    public double surfaceArea() {
        return 6*side*side;
    }

    @Override
    public double volume() {
        return side*side*side;
    }
}
