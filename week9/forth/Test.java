package week9.forth;

public class Test {
    public static void main(String[] args){
        Point p=new Point(1,1);
        Point p2=new Point(2,2);
        p.move(p2);
        p2.move(new Point(3,3));
        //System.out.println("Here");
        System.out.println(p.status);
        System.out.println(((Paintable)p).status);
        System.out.println(((Moveable)p).status);
        for(int i=0;i<Point.listOfPoints.size();i++){
            System.out.println("Point "+(i+1)+": x:"+Point.listOfPoints.elementAt(i).x +" y:"+Point.listOfPoints.elementAt(i).x);
        }


    }
}
