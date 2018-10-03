public class l3_2 {
    public static abstract class VolumeShapes{
         double height;
         double length;
        public abstract String getName();
        public abstract double getVolume();
        public abstract double getSecArea();
        public abstract double getArea();

    }


    public static class Cube extends VolumeShapes{
        public Cube(double a){
            length=a;
        }

        @Override
        public String getName() {
            return "cube";
        }

        public double getArea(){
            return 6*length*length;
        }

        @Override
        public double getSecArea() {
            return length*length;
        }

        @Override
        public double getVolume() {
            return length*length*length;
        }
    }
    public static class Sphere extends VolumeShapes{
        final static double PI=3.14159;
        public Sphere(double a){ length=a;
        }
        public String getName() {
            return "sphere";
        }

        public double getArea(){
            return 4*PI*length*length;
        }

        @Override
        public double getSecArea() {
            return PI*length*length;
        }

        @Override
        public double getVolume() {
            return 4*PI*length*length*length/3;
        }
    }
    public static class Cylinder extends VolumeShapes{
        final static double PI=3.14159;
        public Cylinder(double a,double h){
            length=a;
            height=h;
        }
        public String getName() {
            return "cylinder";
        }

        public double getArea(){
            return 2*PI*length*length+2*PI*height*length;
        }

        @Override
        public double getSecArea() {
            return PI*length*length;
        }

        @Override
        public double getVolume() {
            return PI*length*length*height;
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
