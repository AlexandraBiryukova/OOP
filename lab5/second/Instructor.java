package lab5.second;

import java.io.Serializable;

public class Instructor implements Serializable {
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    public Instructor(){
        firstName="---";
        lastName="---";
        department="---";
        email="---";
    }
    public Instructor(String lastName,String firstName,String department, String email,Data d){
        this.firstName=firstName;
        this.lastName=lastName;
        this.department=department;
        this.email=email;
        d.teachers.add(this);
    }
    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName1){firstName=firstName1;}
    public String getLastName(){return lastName;}
    public void setLastName(String lastName1){lastName=lastName1;}
    public String getDepartment(){return department;}
    public void setDepartment(String department1){department=department1;}
    public String getEmail(){return email;}
    public void setEmail(String email1){email=email1;}

    @Override
    public String toString() {
        return "▶︎ "+firstName+" "+lastName+", "+department+" @"+email;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Instructor){
            Instructor i=(Instructor) obj;
            if(i.firstName.equals(firstName)&&i.lastName.equals(lastName)&&i.department.equals(department)&&i.email.equals(email))
                return true;
            return false;
        }
        return false;
    }
}
