package week9.first.Abstact;

public class Point extends Shape3D {
    public Point(){
        super();
    }
    public Point(double s){
        super(s,0);
    }

    @Override
    public double surfaceArea() {
        return 0;
    }

    @Override
    public double volume() {
        return 0;
    }
}
