package MunSocMan;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {

    private JPanel content;
    private JButton submitButton;
    private JButton newStudentButton;
    private JComboBox<Student> userList;

    public UserPanel(SocietyManager socMan, Student user) {
        this.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(2, 1));
        JLabel title = new JLabel("Choose User");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        top.add(title);

        JLabel current;
        if (user != null) current = new JLabel("Current User: " + user.getName());
        else current = new JLabel("Current User: None");
        current.setHorizontalAlignment(SwingConstants.CENTER);
        top.add(current);

        this.add(top, BorderLayout.NORTH);

        content = new JPanel();
        content.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        userList = new JComboBox<Student>();
        for (Student s : socMan.getStudents()) {
            userList.addItem(s);
        }
        if (user != null) userList.setSelectedItem(user);
        else userList.setSelectedItem(0);
        content.add(userList, c);
        newStudentButton = new JButton("New Student");
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.gridy = 1;
        content.add(newStudentButton, c);
        submitButton = new JButton("Submit");
        c.gridx = 1;
        content.add(submitButton, c);
        this.add(content, BorderLayout.CENTER);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getNewStudentButton() {
        return newStudentButton;
    }

    public JComboBox<Student> getUserList() {
        return userList;
    }
}
