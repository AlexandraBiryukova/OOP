package sis3.People;

import sis3.Interfaces.ActionSaving;
import sis3.Interfaces.MakingOrder;
import sis3.Storage.Data;

import java.io.Serializable;

public abstract class User implements Serializable,Comparable,Cloneable,ActionSaving {
    private String name;
    private String surname;
    private String login;
    private String password;
    public User(){
        name="";
        login="";
        password="";
        surname="";
    }
    public User(String s,String s2,String l,String p){
        name=s;
        surname=s2;
        login=l;
        password=p;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login=login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String toString(){
        return name+" "+surname;
    }
    public int hashcode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User p=(User)obj;
            if(p.name.equals(name)&&p.surname.equals(surname)&&login.equals(p.login)&&p.password.equals(password))
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User) {
            User u = (User) o;
            if (this.name.compareTo(u.name) == 0)
                return this.surname.compareTo(u.surname);
            else return this.name.compareTo(u.name);
        }
        return -1;
    }


}
