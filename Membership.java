package MunSocMan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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

    public void setVoted(Boolean b){
		hasVoted = b;
    }

	public void vote(Candidate c){

		this.setVoted(true);
		ArrayList<Candidate> ac = this.getSociety().getElection().getCandidateList();

		for(Candidate can: ac){
			if(can.equals(c)){
				can.addVote();
				return;
			}
		}
	}

}
