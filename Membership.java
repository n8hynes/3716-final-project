package MunSocMan;

import java.util.Date;

public class Membership {

    private boolean feesPaid;
    private Date dateJoined;
    private Society society;
    private Student student;

    // potential for change - can pay fees while joining?
    public Membership(Society society, Student student) {
        feesPaid = false;
        dateJoined = new Date();
        this.society = society;
        this.student = student;
    }

    public boolean isFeesPaid() {
        return feesPaid;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public Society getSociety() {
        return society;
    }

    public Student getStudent() {
        return student;
    }

    public void setFeesPaid(boolean feesPaid) {
        this.feesPaid = feesPaid;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setSociety(Society society) {
        this.society = society;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
