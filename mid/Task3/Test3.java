package Task3;

public class Test3 {
    public static void main(String[] args){
        Shape s=new Circle(5);
        System.out.println(s.toString());
        System.out.println(s.getArea());
        s=new Rectangle(6,2);
        System.out.println(s.toString());
        System.out.println(s.getArea());
        s=new Square(5);
        System.out.println(s.toString());
        System.out.println(s.getArea());
        Rectangle r=new Rectangle(5,5);
        System.out.println(r.toString());
        System.out.println(r.getArea());
        Shape s1=new Square(6);
        Rectangle r1=new Square(6);
        System.out.println(s1.toString());
        System.out.println(s1.getArea());
        if(s1.equals(r1))
            System.out.println("equal");
        else
            System.out.println("not equal");



    }
}
