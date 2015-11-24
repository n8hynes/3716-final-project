package MunSocMan;

import java.util.ArrayList;

public class Society implements Sender, java.io.Serializable {

    private String name;
    private String description;
    private int feeAmount;
    private boolean sanctioned;
    private ArrayList<Event> events;
    private Board board;
    private Membership leader;
    private ArrayList<Membership> members;

    public Society(String name, String description) {
        this.name = name;
        this.description = description;
        feeAmount = 0;
        sanctioned = false;
        events = new ArrayList<Event>();
        board = new Board();
        members = new ArrayList<Membership>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getFeeAmount() {
        return feeAmount;
    }

    public boolean isSanctioned() {
        return sanctioned;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public Board getBoard() {
        return board;
    }

    public Membership getLeader() {
        return leader;
    }

    public ArrayList<Membership> getMembers() {
        return members;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFeeAmount(int feeAmount) {
        this.feeAmount = feeAmount;
    }

    public void setSanctioned(boolean sanctioned) {
        this.sanctioned = sanctioned;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setLeader(Membership leader) {
        this.leader = leader;
    }

    public void setLeader(Student student) {
        for (Membership m : members) {
            if (m.getStudent() == student) {
                this.setLeader(m);
                break;
            }
        }
    }

    public void addEvent(Event e) {
        events.add(e);
    }

    public void removeEvent(Event e) {
        events.remove(e);
    }

    public void addMember(Membership m) {
        members.add(m);
    }

    public void removeMember(Membership m) {
        members.remove(m);
    }

}
