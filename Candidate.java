package MunSocMan;

public class Candidate{
	private Membership membership;
	private int vote;
	public Candidate(Membership m){
		this.membership =m;
		this.vote =0;
	}
	public void addVote(){
		vote++;
	}
	public int getCount(){
		return vote;
	}
	public Membership getMembership(){
		return membership;
	}
	
	public String toString(){
		return this.membership.getStudent().getName();
	}
}