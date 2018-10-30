package week9.fifth;

public class MinMax {
    Pair res;
    static class Pair{
        int minimum;
        int maximum;
    }

    static Pair minmax(int values[]){
        Pair res=new Pair();
        int mi=values[0],ma=values[0];
        for(int i=1;i<values.length;i++){
            if(values[i]>ma)
                ma=values[i];
            if(values[i]<mi)
                mi=values[i];
        }
        res.maximum=ma;
        res.minimum=mi;
        return res;

    }

}
