package week9.third;

public  class Person{
    private String name;
    public Person(){
        name="someone";
    }
    public Person(String s){
        name=s;
    }
    public void setName(String s){name=s;}
    public String getName(){return name;}
    public String toString(){
        return name;
    }
    public boolean equals(Object o){
        if(o instanceof Person) {
            Person p=(Person) o;
            if (p.name == name)
                return true;
            return false;
        }
        return false;
    }
}