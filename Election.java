package MunSocMan;

import java.util.ArrayList;

public class Election{
	private ArrayList<Candidate> candidates;
	
	//The constructor gets a membership list and creates a new list made of candidate objects.
	public Election(ArrayList<Membership> list){
		for(Membership i : list){
			this.candidates.add(new Candidate(i));
		}
	}
	
	//getter methods
	public ArrayList<Candidate> getCandidateList(){
		return candidates;
	}
	
	//setter methods
	/*
	public void setCandidateList(ArrayList<Candidate> list){
		for(Candidate l:){
			this.candidates.add(new Candidate(i));
		}
	}
	*/
	//remove candidate
	
	public void removeCandidate(Membership member){
		
		for(int i = 0; i < this.candidates.size();  i++){
			if(this.candidates.get(i).getMembership().equals(member)){
				this.candidates.remove(this.candidates.get(i));
				i = this.candidates.size();
			}
		} 
	}
	
	//Count
	public Candidate getHighest(){
		Candidate highestSoFar = this.candidates.get(0);

		for (Candidate c : this.candidates){
			if (c.getCount() > highestSoFar.getCount()){
				highestSoFar = c;
			}
		}
		return highestSoFar;

		
	}
}	