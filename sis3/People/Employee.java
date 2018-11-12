package sis3.People;

import sis3.Interfaces.ActionSaving;

import java.io.Serializable;

public abstract class Employee extends User implements Serializable,Comparable, ActionSaving {
    private int phoneNumber;
    private int yearOfWorkOrStudy;
    public Employee(){
        super();
        phoneNumber=0;
        yearOfWorkOrStudy=0;
    }
    public Employee(String name,String surname,String l,String p, int num,int year){
        super(name,surname,l,p);
        phoneNumber=num;
        yearOfWorkOrStudy=year;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getYearOfWorkOrStudy() {
        return yearOfWorkOrStudy;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setYearOfWorkOrStudy(int yearOfWork) {
        this.yearOfWorkOrStudy = yearOfWork;
    }
    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString()+" "+phoneNumber+" Year : "+yearOfWorkOrStudy;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee){
            Employee e=(Employee)obj;
            if(super.equals((User)e)){
                if(e.yearOfWorkOrStudy==yearOfWorkOrStudy&&e.phoneNumber==phoneNumber)
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
                if(phoneNumber==e.phoneNumber){
                    if(yearOfWorkOrStudy>e.yearOfWorkOrStudy)
                        return 1;
                    else if(yearOfWorkOrStudy<e.yearOfWorkOrStudy)
                        return -1;
                    return 0;

                }else if(phoneNumber>e.phoneNumber)
                    return 1;
                else return -1;
            }
            return super.compareTo((User)o);
        }
        return -1;
    }
}
