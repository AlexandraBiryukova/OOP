package week9.first.Abstact;

public class Cube extends Shape3D {
    public Cube(){
        super();
    }
    public Cube(double s){
        super(s,1);
    }

    @Override
    public double volume() {
        return side*side*side;
    }

    @Override
    public double surfaceArea() {
        return 6*side*side;
    }
}
