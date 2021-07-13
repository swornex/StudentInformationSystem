
package studentinformationsystem;

public class Student {
    int id;
    String fName, lName, address, parentsName, department;
    long phoneNumber, parentsNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getParentsName() {
        return parentsName;
    }

    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
    }

    public long getParentsNumber() {
        return parentsNumber;
    }

    public void setParentsNumber(long parentsNumber) {
        this.parentsNumber = parentsNumber;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public Student(){}

    public Student(String fName, String lName, String address, long phoneNumber, String parentsName, long parentsNumber, String department) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.parentsName = parentsName;
        this.parentsNumber = parentsNumber;
        this.department = department;
    }
    
}
