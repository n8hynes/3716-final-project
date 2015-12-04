public class Candidate{
	private Membership membership;
	private int num_vote;
	public Candidate(Membership m){
		this.membership =m;
		this.vote =0;
	}
	public void addVote(){
		vote++;
	}
	public int getCount(){
		return num_vote;
	}
	public Membership getMembership(){
		return membership;
	}
}