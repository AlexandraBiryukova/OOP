package mid.Task2;
import java.util.Date;
public class Visit {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;
    public Visit(Customer c, String date){
        customer=c;
        this.date=date;
    }
    public String getName(){
        return customer.getName();
    }
    public void setServiceExpense(double ex){serviceExpense=ex;}
    public double getServiceExpense(){return serviceExpense;}
    public void setProductExpense(double ex){productExpense=ex;}
    public double getProductExpense(){return productExpense;}
    public double getTotalExpence(){
        serviceExpense-=serviceExpense*DiscountRate.getServiceDiscountRate(customer.getMemberType());
        productExpense-=productExpense*DiscountRate.getProductDiscountRate(customer.getMemberType());
        return serviceExpense+productExpense;
    }
    public String toString(){
        return customer.toString()+" "+date+" services:"+serviceExpense+"; products:"+productExpense+"\nTOTAL: "+getTotalExpence();
    }
}
