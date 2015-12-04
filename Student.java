package MunSocMan;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Student implements Serializable {

    private ArrayList<Membership> societies;
    private String name;
    private String studentID;
    private String major;

    public Student(String name, String studentID, String major) {
        this.name = name;
        this.studentID = studentID;
        this.major = major;
        this.societies = new ArrayList<Membership>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public ArrayList<Membership> getSocieties() {
        return societies;
    }

    public void addSociety(Membership m) {
        societies.add(m);
    }

    public void removeSociety(Membership m) {
        societies.remove(m);
    }

    public boolean isMember(Society society) {
        for (Membership m : this.societies) {
            if (m.getSociety().equals(society)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result = name + " | " + studentID + " | " + major;
        return result;
    }

}
