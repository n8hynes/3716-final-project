package MunSocMan;

public class Candidate {

    private Membership membership;
    private int vote;

    public Candidate(Membership m) {
        membership = m;
        vote = 0;
    }

    public void addVote() {
        vote++;
    }

    public int getCount() {
        return vote;
    }

    public Membership getMembership() {
        return membership;
    }

    public String toString() {
        return membership.getStudent().getName();
    }

}
