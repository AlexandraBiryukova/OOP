package sis3.People;

import sis3.Interfaces.ActionSaving;

import java.io.Serializable;

public abstract class Employee extends User implements Serializable,Comparable, ActionSaving {
    private String phoneNumber;
    private int yearOfWorkOrStudy;
    public Employee(){
        super();
        phoneNumber="";
        yearOfWorkOrStudy=0;
    }
    public Employee(String name,String surname,String l,String p, String num,int year){
        super(name,surname,l,p);
        phoneNumber=num;
        yearOfWorkOrStudy=year;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getYearOfWorkOrStudy() {
        return yearOfWorkOrStudy;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setYearOfWorkOrStudy(int yearOfWork) {
        this.yearOfWorkOrStudy = yearOfWork;
    }
    @Override
    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString()+" "+phoneNumber+" Year: "+yearOfWorkOrStudy;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee){
            Employee e=(Employee)obj;
            if(super.equals((User)e)){
                if(e.yearOfWorkOrStudy==yearOfWorkOrStudy&&e.phoneNumber.equals(phoneNumber))
                    return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e=(Employee)o;
            if(super.compareTo((User)o)==0){
                if(phoneNumber.equals(e.phoneNumber)){
                    if(yearOfWorkOrStudy>e.yearOfWorkOrStudy)
                        return 1;
                    else if(yearOfWorkOrStudy<e.yearOfWorkOrStudy)
                        return -1;
                    return 0;

                }else
                    return(phoneNumber.compareTo(e.phoneNumber));

            }
            return super.compareTo((User)o);
        }
        return -1;
    }
}
