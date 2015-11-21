package MunSocMan;

public class BoardPosition {

    private PositionType type;
    private Membership member;

    public BoardPosition(PositionType type, Membership member) {
        this.type = type;
        this.member = member;
    }

    public PositionType getType() {
        return type;
    }

    public Membership getMember() {
        return member;
    }

    public void setType(PositionType type) {
        this.type = type;
    }

    public void setMember(Membership member) {
        this.member = member;
    }

}
