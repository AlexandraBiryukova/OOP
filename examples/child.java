package examples;

public class child extends parent {
    private String gender;
    child(){
        gender="girl";
    }
    public String toString(){
        return getName()+ "'s "+gender;
    }
}
