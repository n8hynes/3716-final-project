package MunSocMan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewStudentActionListener implements ActionListener {

    private SocietyManager socMan;
    private Student user;
    private NewStudentPanel panel;
    private MunSocManFrame frame;

    public NewStudentActionListener(SocietyManager socMan, Student user, NewStudentPanel panel, MunSocManFrame frame) {
        this.socMan = socMan;
        this.user = user;
        this.panel = panel;
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        Student newStudent = new Student(panel.getNameField().getText(), panel.getStudentIDField().getText(), panel.getMajorField().getText());
        socMan.addStudent(newStudent);
        user = newStudent;
        frame.newUser();
        frame.chooseUser();
    }

}
