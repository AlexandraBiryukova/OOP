package week9.third;
import java.util.Date;
import java.util.Vector;

    public class Manager extends Employee implements Comparable,Cloneable {
        private Vector team;
        private double bonus=0;
        public Manager(){
            super();
            team=new Vector();
        }
        public Manager(String n,double d,Date a,String s,double b,Vector vec){
            super(n,d,a,s);
            bonus=b;
            team=vec;
            setSalary(getSalary()+team.size()*bonus);
        }
        public void setTeam(Vector vec){
            team=vec;
            setSalary(getSalary()+team.size()*bonus);

        }
        public String getTeam(){
            return team.toString();
        }
        public void setBonus(double a){
            bonus=a;
            setSalary(getSalary()+team.size()*bonus);
        }
        public double getBonus(){return bonus;}
        public String toString(){
            return super.toString()+"His employees: "+team.toString()+" with "+bonus+" bonus for each.";
        }
        public boolean equals(Object o){
            if(o instanceof Manager){
                Manager m=(Manager) o;
                if(super.equals((Employee)m)){
                    if(team.toString().equals(m.getTeam())){
                        if(bonus==m.getBonus()){
                            return true;
                        }

                    }
                }
                return false;
            }
            return false;
        }

        @Override
        public int compareTo(Object o) {
            if(o instanceof Manager) {
                Manager m = (Manager) o;
                if (super.compareTo((Employee)o) == 0){
                    if(m.bonus>bonus)
                        return -1;
                    if(m.bonus<bonus)
                        return 1;
                    return 0;
                }
                return super.compareTo((Employee)o);
            }
            return 0;
        }

        @Override
        public Manager clone() throws CloneNotSupportedException {
            Manager m=new Manager();
            m.setName(this.getName());
            m.setDate(this.getDate());
            m.setSalary(this.getSalary());
            m.setInsNum(this.getInsNum());
            m.bonus=this.bonus;
            m.team=this.team;
            return m;
            //return super.clone();

        }
    }

