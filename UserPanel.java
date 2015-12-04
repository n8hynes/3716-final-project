package MunSocMan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {

    private JButton newStudentButton;
    private JButton submitButton;
    private JComboBox<Student> userList;
    private JPanel content;

    public UserPanel(SocietyManager socMan, Student user) {

        this.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(4, 1));
        top.setBorder(new EmptyBorder(50, 0, 0, 0));

        JLabel welcome = new JLabel("Welcome to MUN SOC MAN");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        welcome.setForeground(Color.BLUE);
        top.add(welcome);

        top.add(new JLabel(""));

        JLabel title = new JLabel("Choose User");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        title.setForeground(Color.GRAY);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        top.add(title);

        JLabel current;
        if (user != null) current = new JLabel("Current User: " + user.getName());
        else current = new JLabel("Current User: None");
        current.setHorizontalAlignment(SwingConstants.CENTER);
        current.setForeground(Color.GRAY);
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

    public JButton getNewStudentButton() {
        return newStudentButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JComboBox<Student> getUserList() {
        return userList;
    }
}
