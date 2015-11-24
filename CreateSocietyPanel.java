package MunSocMan;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class CreateSocietyPanel extends JPanel {

    private JButton homeButton;
    private JButton submitButton;

    public CreateSocietyPanel(SocietyManager socMan, Student user) {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font fieldFont = new Font(Font.MONOSPACED, Font.PLAIN, 16);

        JLabel title = new JLabel("Create Society");


        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(labelFont);
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        this.add(nameLabel, c);

        JTextField nameField = new JTextField();
        nameField.setFont(fieldFont);
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(nameField, c);

        JLabel descLabel = new JLabel("Description (300 char max): ");
        descLabel.setFont(labelFont);
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.gridwidth = 2;
        this.add(descLabel, c);

        JTextArea descArea = new JTextArea();
        descArea.setFont(fieldFont);
        descArea.setWrapStyleWord(true);
        descArea.setLineWrap(true);
        descArea.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                String text = descArea.getText();
                if (text.length() > 300) submitButton.setEnabled(false);
                else submitButton.setEnabled(true);
            }
        });
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        this.add(descArea, c);

        homeButton = new JButton("Home");
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 0;
        c.weighty = 0;
        c.gridwidth = 1;
        this.add(homeButton, c);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n = socMan.getSocieties().size();
                socMan.addSociety(nameField.getText(), descArea.getText(), user);
                if (socMan.getSocieties().size() > n) JOptionPane.showMessageDialog(null, "You've successfully created your new society, " + nameField.getText());
                else JOptionPane.showMessageDialog(null, "oops");
                nameField.setText("");
                descArea.setText("");
            }
        });
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 3;
        c.weighty = 0;
        c.weighty = 0;
        this.add(submitButton, c);

    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }
}
