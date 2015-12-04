package MunSocMan;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class NewStudentPanel extends JPanel {

    private JButton submitButton;
    private Student newStudent;
    private JTextField nameField;
    private JTextField studentIDField;
    private JTextField majorField;

    public NewStudentPanel(SocietyManager socMan, Student user) {

        this.setLayout(new BorderLayout());

        JLabel title = new JLabel("New Student");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel nameLabel = new JLabel("Name: ");
        nameField = new JTextField();
        JLabel studentIDLabel = new JLabel("Student ID: ");
        studentIDField = new JTextField();
        JLabel majorLabel = new JLabel("Major: ");
        majorField = new JTextField();
        submitButton = new JButton("Submit");
        submitButton.setEnabled(false);

        CaretListener cl = new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                if ((nameField.getText().length() == 0) || (studentIDField.getText().length() == 0) || (majorField.getText().length() == 0)) submitButton.setEnabled(false);
                else submitButton.setEnabled(true);
            }
        };
        nameField.addCaretListener(cl);
        studentIDField.addCaretListener(cl);
        majorField.addCaretListener(cl);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        content.add(nameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        content.add(nameField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        content.add(studentIDLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        content.add(studentIDField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0;
        content.add(majorLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1;
        content.add(majorField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1;
        c.gridwidth = 2;
        content.add(submitButton, c);

        this.add(content, BorderLayout.CENTER);

    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public Student getNewStudent() {
        return newStudent;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getStudentIDField() {
        return studentIDField;
    }

    public JTextField getMajorField() {
        return majorField;
    }
}
