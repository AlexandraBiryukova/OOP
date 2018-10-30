package mid.Task2;

public class Customer {
    private String name;
    private boolean member=false;
    private String memberType;
    public Customer(){
        name="";
        memberType="";
    }
    public Customer(String name){
        this.name=name;
    }
    public String getName(){return name;}
    public boolean isMember(){ return member;}
    public void setMember(boolean member){
        this.member=member;
    }
    public String getMemberType(){
        if(member)
            return memberType;
    return "ERROR: Not a member";}
    public void setMemberType(String type){
        if(member)
            memberType=type;
        else
            System.out.println("ERROR: Not a member");
    }
    public String toString(){
        if(member)
            return name+' '+memberType;
        return name+" not a member";
    }
}
