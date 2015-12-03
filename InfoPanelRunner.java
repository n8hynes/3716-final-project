package MunSocMan;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InfoPanelRunner {
  public static void main(String[] args){
    SocietyManager socMan = new SocietyManager();
    Student user = new Student("Tim","123","major");
    socMan.addStudent(user);
    socMan.addSociety("Society Name", "Brief Description", user);
    InfoPanel panel = new InfoPanel(socMan, user, user.getSocieties().get(0).getSociety());
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(panel);
    frame.setTitle("Society Info");
    frame.setSize(500,500);
    frame.setVisible(true);
  }
}
