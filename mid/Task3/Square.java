package mid.Task3;

public class Square extends Rectangle{
    public Square(){
        width=0;
        length=0;
    }
    public Square(double side){
        super(side,side);
    }
    public Square(double side,String color, boolean filled){
        super(side,side,color,filled);
    }
    public double getSide(){return width;}
    public void setSide(double side){
        width=side;
        length=side;
    }
    public void setWidth(double side){
        super.setWidth(side);
    }
    public void setLength(double side){
        super.setLength(side);
    }
    public String toString(){
        return "Square with side "+ length;
    }
    public boolean equals(Object o){
        if(o instanceof Square){
            Square s=(Square)o;
            if(s.getLength()==getLength())
                return true;
            return false;
        }
        return false;
    }
}
