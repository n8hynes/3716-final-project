package MunSocMan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SocietyManager {

    private ArrayList<Student> students;
    private ArrayList<Society> societies;
    //Declare default storage location for .ser files
    private final String defaultStuLocation = "./Stu.ser";
    private final String defaultSocLocation = "./Soc.ser";

    //Read serialized files of students and societies
    public SocietyManager() {
        File stuFile,socFile;
        FileInputStream stuInputStream = null;
        FileInputStream socInputStream = null;
        ObjectInputStream stuIn = null;
        ObjectInputStream socIn = null;
        try {
            stuFile = new File(defaultStuLocation);
            socFile = new File(defaultSocLocation);
            if (stuFile.isFile()){
                stuInputStream = new FileInputStream(stuFile);
                stuIn = new ObjectInputStream(stuInputStream);
                @SuppressWarnings("unchecked")
                ArrayList<Student> deserializedStu = (ArrayList<Student>) stuIn.readObject();
                students = deserializedStu;
            }
            if (socFile.isFile()){
                socInputStream = new FileInputStream(socFile);
                socIn = new ObjectInputStream(socInputStream);
                @SuppressWarnings("unchecked")
                ArrayList<Society> deserializedSoc = (ArrayList<Society>) socIn.readObject();
                societies = deserializedSoc;
            }
        }
        //IOException, ClassNotFoundException
        catch (Exception e){
            e.printStackTrace();
            if (students == null){
                students = new ArrayList<Student>();
            }
            if (societies == null){
                societies = new ArrayList<Society>();
            }
        }
        //Close all streams and initialize empty students and
        //societies ArrayLists if serialization fails
        finally {
            if (students == null){
                students = new ArrayList<Student>();
            }
            if (societies == null){
                societies = new ArrayList<Society>();
            }
            try {
                if (stuInputStream != null){
                    stuInputStream.close();
                }
                if (socInputStream != null){
                    socInputStream.close();
                }
                if (stuIn != null){
                    stuIn.close();
                }
                if (socIn != null){
                    socIn.close();
                }
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    //Write current students and societies ArrayLists to default .ser file locations
    public void save(){
        FileOutputStream stuOutputStream = null;
        FileOutputStream socOutputStream = null;
        ObjectOutputStream stuOut = null;
        ObjectOutputStream socOut = null;
        try {
            stuOutputStream = new FileOutputStream(defaultStuLocation);
            socOutputStream = new FileOutputStream(defaultSocLocation);
            stuOut = new ObjectOutputStream(stuOutputStream);
            socOut = new ObjectOutputStream(socOutputStream);
            stuOut.writeObject(students);
            socOut.writeObject(societies);
        }
        //IOException, FileNotFoundException
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (stuOutputStream != null){
                    stuOutputStream.close();
                }
                if (socOutputStream != null){
                    socOutputStream.close();
                }
                if (stuOut != null){
                    stuOut.close();
                }
                if (socOut != null){
                    socOut.close();
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Society> getSocieties() {
        return societies;
    }

    public ArrayList<Student> getStudents() {
        return students;
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

    public void removeMembership(Membership m) {
        m.getSociety().removeMember(m);
        m.getStudent().removeSociety(m);
        if (m.getSociety().getMembers().size() < 20) m.getSociety().setSanctioned(false);
        if (m.getSociety().getMembers().size() == 0){
          removeSociety(m.getSociety());
        }
    }

    public void removeMembership(Society society, Student student) {
        for(Membership m : student.getSocieties()) {
            if (m.getSociety() == society) {
                student.removeSociety(m);
                society.removeMember(m);
                break;
            }
        }
        if (society.getMembers().size() < 20) society.setSanctioned(false);
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

}
