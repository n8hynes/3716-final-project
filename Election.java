package MunSocMan;

import java.util.ArrayList;
import java.util.Random;

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
        ArrayList<Candidate> winners = new ArrayList<Candidate>();
        int highest = 0;
        for (Candidate c : this.candidates){
            if (c.getCount() > highest){
                winners.clear();
                highest = c.getCount();
                winners.add(c);
            }
            else if (c.getCount() == highest){
                winners.add(c);
            }
        }
        Candidate winner;
        if (winners.size() > 1){
            winner = (Candidate) winners.toArray()[new Random().nextInt(winners.size())];
        }
        else winner = winners.get(0);
        return winner;
    }
}
