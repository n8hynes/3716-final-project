package MunSocMan;

import java.util.Date;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Membership implements Serializable {

    private boolean feesPaid,hasVoted;
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

    public boolean hasVoted(){
	return hasVoted;
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

    public void setVoted(){
	hasV	oted = true;
    }

}
