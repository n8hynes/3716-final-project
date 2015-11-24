package MunSocMan;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Student extends Person implements java.io.Serializable {

    private String studentID;
    private String major;
    private ArrayList<Membership> societies;

    public Student(String name, String studentID, String major) {
        super(name);
        this.studentID = studentID;
        this.major = major;
        this.societies = new ArrayList<Membership>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<Membership> getSocieties() {
        return societies;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addSociety(Membership m) {
        societies.add(m);
    }

    public void removeSociety(Membership m) {
        societies.remove(m);
    }

    public Student(){
        this.studentID = "123";
        this.major = "456";
        this.societies = new ArrayList<Membership>();
    }
}
