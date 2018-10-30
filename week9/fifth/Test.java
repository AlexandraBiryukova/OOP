package week9.fifth;

public class Test {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 100, 5, 2, 8, 9, 25, -5};
        MinMax m = new MinMax();
        m.res=MinMax.minmax(a);
        System.out.println(m.res.maximum +" "+m.res.minimum);
    }


}
