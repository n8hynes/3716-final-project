//TODO: disable button when EITHER field is empty.

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
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class CreateSocietyPanel extends JPanel {

    private JButton homeButton;
    private JButton submitButton;

    public CreateSocietyPanel(SocietyManager socMan, Student user) {

        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Create Society");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font fieldFont = new Font(Font.MONOSPACED, Font.PLAIN, 16);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(labelFont);
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        form.add(nameLabel, c);

        JTextField nameField = new JTextField();
        nameField.setFont(fieldFont);
        nameField.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                String text = nameField.getText();
                if (text.length() == 0) submitButton.setEnabled(false);
                else submitButton.setEnabled(true);
            }
        });
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        form.add(nameField, c);

        JLabel descLabel = new JLabel("Description (300 char max): ");
        descLabel.setFont(labelFont);
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.gridwidth = 2;
        form.add(descLabel, c);

        JTextArea descArea = new JTextArea();
        descArea.setFont(fieldFont);
        descArea.setWrapStyleWord(true);
        descArea.setLineWrap(true);
        descArea.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                String text = descArea.getText();
                if ((text.length() > 300) || (text.length() == 0)) submitButton.setEnabled(false);
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
        form.add(descArea, c);

        homeButton = new JButton("Home");
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 0;
        c.weighty = 0;
        c.gridwidth = 1;
        form.add(homeButton, c);

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
        submitButton.setEnabled(false);
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 3;
        c.weighty = 0;
        c.weighty = 0;
        form.add(submitButton, c);

        this.add(form, BorderLayout.CENTER);

    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }
}
