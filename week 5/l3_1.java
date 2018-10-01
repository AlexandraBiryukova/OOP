public class l3_1 {
    public static class Animal{
        private String name;
        private boolean isAlive;

        public Animal(){
            name="It";
        }

        public Animal(String s,boolean b){
            name=s;
            isAlive=b;
        }
        public void setLife(boolean b){isAlive=b;}
        public boolean getLife(){return isAlive;}
        public String getName(){ return name;}
        public void setName(String s){name=s;}

        public String toString(){
            if(isAlive)
                return "Alive animal: "+name;
            return "Exinct animal: "+name;
        }
    }
    public static class Dinosaur extends Animal{
        private int age;

        public Dinosaur(){
            super();
            super.setLife(false);
            age=0;
        }
        public Dinosaur(String s,int a,boolean b){
            super(s,b);
            age=a;

        }
        public void setName(String s, int a){
            setName(s);
            age=a;
        }
        public void setName(String s, int a,boolean b){
            setName(s);
            age=a;
            setLife(b);
        }
        public String toString(){
            return "Dinosaur: "+getName()+",age - "+age+".";
        }

    }
    public static void main(String[] args){
        Dinosaur d=new Dinosaur();
        d.setName("Dino",2);
        System.out.println(d.toString());
        Animal a=new Animal("animal",false);
        System.out.println(a.toString());



    }
}
