package week9.forth;
import java.util.Vector;

public class Point implements Paintable {
    String status="WHAT CAN I DO?";
    public int x;
    public int y;
    public static Vector<Point> listOfPoints=new Vector<>();
    public Point(){
        x=0;
        y=0;
    }
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public void move(Point p1) {

        if(!listOfPoints.contains(this))
            listOfPoints.add(this);
        listOfPoints.add(p1);
    }

    @Override
    public void Paint() {
        System.out.println(listOfPoints);
    }
}
