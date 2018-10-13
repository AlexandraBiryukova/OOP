package Task2;
public class Test2 {
    public static void main(String[] args){
        Customer c1 =new Customer("Alex");
        Visit v1=new Visit(c1, "October 12");
        c1.setMember(true);
        c1.setMemberType("Gold");
        v1.setProductExpense(100);
        v1.setServiceExpense(100);
        System.out.println(v1.toString());
        Customer c2 =new Customer("Sam");
        Visit v2=new Visit(c2, "October 13");
        c2.setMember(true);
        c2.setMemberType("Premium");
        v2.setProductExpense(100);
        v2.setServiceExpense(100);
        System.out.println(v2.toString());
        Customer c3 =new Customer("Dan");
        Visit v3=new Visit(c3, "October 16");
        c3.setMember(false);
        c3.setMemberType("Silver");
        v3.setProductExpense(100);
        v3.setServiceExpense(100);
        System.out.println(v3.toString());








    }
}
