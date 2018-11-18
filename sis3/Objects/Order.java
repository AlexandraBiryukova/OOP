package sis3.Objects;
import sis3.People.Employee;
import sis3.People.Executor;
import java.util.Date;
import java.io.Serializable;

public class Order implements Serializable {

        private String orderTitle;
        private Employee sender;
        private Executor executor;
        private Date executionDate;
        private boolean completed = false;
        private boolean accepted=false;
        private String orderTextBody;
        public Order(){

        }
        public Order(String title , Employee e, Executor ex, Date d,String text){
            orderTitle=title;
            sender=e;
            executor=ex;
            executionDate=d;
            orderTextBody=text;
        }

        public Executor getExecutor() {return executor;}
        public void setOrderTextBody(String textBody){ this.orderTextBody = textBody;}
        public String getOrderTextBody() { return this.orderTextBody;}
        public void setOrderTitle(String orderTitle){ this.orderTitle = orderTitle;}
        public String getOrderTitle(){return orderTitle;}
        public Boolean isCompleted(){return completed;}
        public Date getExecutionDate() { return executionDate; }

    public Employee getSender() {
        return sender;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public boolean equals(Object obj) {
            if(obj instanceof Order) {
                Order o = (Order) obj;
                if(o.orderTextBody.equals(orderTextBody)&&o.executionDate.equals(executionDate)
                &&o.executor.equals(executor)&&o.sender.equals(sender)&&o.orderTitle.equals(orderTitle)&&
                o.completed==completed)
                    return true;
            }
            return false;
        }
        public int hashcode(){
            return super.hashCode();
        }
        public String confirmation() {
            if(accepted)
                return "ACCEPTED";
            if(completed)
                return "COMPLETED";
            return "NEW";


        }
        public String toString(){
            return "Order: " + orderTitle + "\nActivity: " + orderTextBody + "\nCommander: " + sender.getLogin()+
                    "\nConfirmation state: " + confirmation() + "\nExecution Date: " + executionDate;
        }

}
