import java.lang.Math.*;
public class l3_5 {
    static char[] list={'a','b','c','d','e','f','g','h'};
    public static int toInt(char c){
        for(int i=0;i<8;i++){
            if(list[i]==c)
                return i+1;
        }
        return 0;
    }
    public static abstract class Piece{
        private int x;
        private int y;
        private boolean empty=true;
        public Piece(){
            x=0;
            y=0;
        }
        public Piece(char X, int Y) {
            x = toInt(X);
            if(Y>0&&Y<9)
                y = Y;
            else
                y=0;
            empty=false;
        }
        public char getX(){return list[x-1];}
        public void setX(char s){ x=toInt(s);}
        public int getY(){return y;}
        public void setY(int c){
            if(c>0&&c<9)
                y = c;
            else
                y=0;
        }

    }
    public static class Rook extends Piece{
        public Rook(){
            super();
        }
        public Rook(char s,int a){
            super(s,a);
        }
        public String isLegalMove(Piece p) {
            if (toInt(getX())!=0&&getY()!=0&&p.x != 0 && p.y != 0) {
                if (p.x == toInt(getX()) || p.y == getY())
                    return "yes";
                return "no";
            }
            return "no";
        }
    }
    public static class Bishop extends Piece{
        public Bishop(){
            super();
        }
        public Bishop(char s,int a){
            super(s,a);
        }
        public String isLegalMove(Piece p){
            if (toInt(getX())!=0&&getY()!=0&&p.x != 0 && p.y != 0) {
                if (Math.abs(p.x - toInt(getX())) == Math.abs(p.y - getY()))
                    return "yes";
                return "no";
            }
            return "no";
        }
    }
    public static class Pawn extends Piece{
        public Pawn(){
            super();
        }
        public Pawn(char s,int a){
            super(s,a);
        }
        public String isLegalMove(Piece p){
            if (toInt(getX())!=0&&getY()!=0&&p.x != 0 && p.y != 0) {
                if (p.x == toInt(getX()) && p.y - getY() == 1)
                    return "yes";
                return "no";
            }
            return "no";
        }
    }
    public static class Queen extends Piece {
        public Queen() {
            super();
        }

        public Queen(char s, int a) {
            super(s, a);
        }

        public String isLegalMove(Piece p) {
            if (toInt(getX()) != 0 && getY() != 0 && p.x != 0 && p.y != 0) {
                if ((Math.abs(p.x - toInt(getX())) == Math.abs(p.y - getY())) || (p.x == toInt(getX()) || p.y == getY()))
                    return "yes";
                return "no";
            }
            return "no";
        }
    }
    public static class King extends Piece{
        public King(){
            super();
        }
        public King(char s,int a){
            super(s,a);
        }
        public String isLegalMove(Piece p) {
            if (toInt(getX()) != 0 && getY() != 0 && p.x != 0 && p.y != 0) {
                if ((Math.abs(p.x - toInt(getX())) == 1 && p.y == getY()) || (Math.abs(p.y - getY()) == 1) && p.x == toInt(getX()) || (Math.abs(p.x - toInt(getX())) == 1 && Math.abs(p.y - getY()) == 1))
                    return "yes";
                return "no";
            }
            return "no";
        }
    }
    public static class Knight extends Piece{
        public Knight(){
            super();
        }
        public Knight(char s,int a){
            super(s,a);
        }
        public String isLegalMove(Piece p){
            if (toInt(getX())!=0&&getY()!=0&&p.x != 0 && p.y != 0) {
                if ((Math.abs(p.x - toInt(getX())) == 1 && Math.abs(p.y - getY())==2) || (Math.abs(p.y - getY()) == 1 && Math.abs(p.x-toInt(getX()))==2 ))
                    return "yes";
                return "no";
            }
            return "no";
        }
    }


    public static void main(String[] args){
        Rook r=new Rook('a',6);
        Rook r2=new Rook('a',3);
        System.out.println(r.isLegalMove(r2));
        Bishop k=new Bishop('e',3);
        Bishop k2=new Bishop('h',6);
        System.out.println(k.isLegalMove(k2));
        Pawn p=new Pawn('a',3);
        Pawn p2=new Pawn('a',3);
        System.out.println(p.isLegalMove(p2));
        Queen q=new Queen('d',4);
        Queen q2=new Queen('h',8);
        System.out.println(q.isLegalMove(q2));
        King ki=new King('c',3);
        King ki2=new King('c',2);
        System.out.println(ki.isLegalMove(ki2));
        Knight kn=new Knight('c',3);
        Knight kn2=new Knight('e',2);
        System.out.println(kn.isLegalMove(kn2));
        Piece t=new Pawn('a',3);
        System.out.println(((Pawn) t).isLegalMove(new Pawn('a',4)));








    }

}
