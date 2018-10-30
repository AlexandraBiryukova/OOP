package week9.first.Interface;

public class Point implements Shape3D {
    double radius;
    public Point(){
        radius=1;
    }
    public Point(double s){
        radius=s;
    }

    @Override
    public double volume() {
        return 0;
    }

    @Override
    public double surfaceArea() {
        return 0;
    }
}
