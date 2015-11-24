package MunSocMan;

import java.util.ArrayList;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Board implements Serializable {

    ArrayList<BoardPosition> positions;
    ArrayList<PositionType> types;

    public Board() {
        positions = new ArrayList<BoardPosition>();
        types = new ArrayList<PositionType>();
    }

    public void addPositionType(PositionType p) {
        types.add(p);
    }

    public void addPositionType(String name, String description) {
        types.add(new PositionType(name, description));
    }

    public void removePositionType(PositionType p){
        types.remove(p);
    }

    public void addPosition(BoardPosition b) {
        positions.add(b);
    }

    public void addPosition(PositionType type, Membership member) {
        positions.add(new BoardPosition(type, member));
    }

    public void removePosition(BoardPosition b) {
        positions.remove(b);
    }

    public void promoteMember(Membership member, BoardPosition position) {
        position.setMember(member);
    }

    public void demoteMember(BoardPosition position) {
        position.setMember(null);
    }

}
