package MunSocMan;

import java.util.ArrayList;

public class SocietyManager {

    private ArrayList<Student> students;
    private ArrayList<Society> societies;

    public SocietyManager() {
        students = new ArrayList<Student>();
        societies = new ArrayList<Society>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Society> getSocieties() {
        return societies;
    }

    public void addSociety(String name, String description, Student student) {
        Society soc = new Society(name, description);
        societies.add(soc);
        this.addMembership(soc, student);
        soc.setLeader(student);
    }

    public void removeSociety(Society s) {
        societies.remove(s);
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void addMembership(Society society, Student student) {
        boolean found = false;
        for (Membership m : society.getMembers()) {
            if (m.getStudent() == student) found = true;
        }
        if (!found) {
            Membership m = new Membership(society, student);
            m.getSociety().addMember(m);
            m.getStudent().addSociety(m);
            if (society.getMembers().size() == 20 && !society.isSanctioned()) society.setSanctioned(true);
        }
    }

    public void removeMembership(Membership m) {
        m.getSociety().removeMember(m);
        m.getStudent().removeSociety(m);
    }

    public void removeMembership(Society society, Student student) {
        for(Membership m : student.getSocieties()) {
            if (m.getSociety() == society) {
                student.removeSociety(m);
                society.removeMember(m);
                break;
            }
        }
        if (society.getMembers().size() < 20 && society.isSanctioned()) society.setSanctioned(false);
    }

}
