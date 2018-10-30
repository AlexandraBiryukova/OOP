package week9.first.Abstact;

public class Cylinder extends Shape3D {
    public Cylinder(){
        super();
    }
    public Cylinder(double s,double h){
        super(s,h);
    }

    @Override
    public double surfaceArea() {
        return PI*2*side*side*2*PI*side*height;
    }

    @Override
    public double volume() {
        return PI*side*side*height;
    }
}
