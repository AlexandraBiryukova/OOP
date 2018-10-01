public class l3_2 {
    public static abstract class VolumeShapes{
        double height;
        double width;
        double length;
        String name;
        public VolumeShapes(String n, double l,double w,double h){
            length=l;
            width=w;
            height=h;
            name=n;
        }
        public String getName(){
            return name;
        }
        public double getVolume() {
            return length * width * height;
        }
        public double getSecArea() {
            return length * width;
        }
        public double getArea() {
            return length * width * height;
        }

    }


    public static class Cube extends VolumeShapes{
        public Cube(double a){
            super("CUBE",a,a,a);
        }
        public double getArea(){
            return 6*super.getSecArea();
        }


    }
    public static class Sphere extends VolumeShapes{
        final static double PI=3.14159;
        public Sphere(double a){
            super("SPHERE",a,a,a);
        }
        public double getVolume(){
            return 4/3*PI*super.getVolume();
        }
        public double getArea(){
            return 4*PI*super.getSecArea();
        }
        public double getSecArea(){
            return PI*super.getSecArea();
        }


    }
    public static class Cylinder extends VolumeShapes{
        final static double PI=3.14159;
        public Cylinder(double a,double h){
            super("CYLINDER",a,a,h);
        }
        public double getVolume(){
            return PI*super.getVolume();
        }
        public double getArea(){
            return 2*PI*super.getSecArea()+2*PI*super.getVolume()/width;
        }
        public double getSecArea(){
            return PI*super.getSecArea();
        }


    }

public static void main(String[] args){

    Cube c=new Cube(2);
    System.out.println(c.getName());
        System.out.println("SURFACE AREA: "+c.getArea());
        System.out.println("VOLUME: "+c.getVolume());
        System.out.println("MAIN SECTION AREA: "+c.getSecArea());
        Sphere s=new Sphere(3);
    System.out.println(s.getName());
    System.out.println("SURFACE AREA: "+s.getArea());
    System.out.println("VOLUME: "+s.getVolume());
    System.out.println("MAIN SECTION AREA: "+s.getSecArea());
        Cylinder s1=new Cylinder(1,2);
    System.out.println(s1.getName());
    System.out.println("SURFACE AREA: "+s1.getArea());
    System.out.println("VOLUME: "+s1.getVolume());
    System.out.println("MAIN SECTION AREA: "+s1.getSecArea());




}
}
