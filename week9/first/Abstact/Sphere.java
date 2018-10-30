package week9.first.Abstact;

public class Sphere extends Shape3D {
    public Sphere(){
        super();
    }
    public Sphere(double a){
        super(a,0);
    }

    @Override
    public double surfaceArea() {
        return 4*PI*side*side;
    }

    @Override
    public double volume() {
        return 4/3*PI*side*side*side;
    }
}
