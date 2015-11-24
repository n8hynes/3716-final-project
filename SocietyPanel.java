package MunSocMan;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SocietyPanel extends JPanel {

    private JButton button;

    public SocietyPanel(Society s) {
        GridBagLayout societyLayout = new GridBagLayout();
        GridBagConstraints nameConstraints = new GridBagConstraints();
        nameConstraints.anchor = GridBagConstraints.LINE_START;
        nameConstraints.gridwidth = 1;
        nameConstraints.weightx = 0;
        nameConstraints.gridx = 0;
        nameConstraints.gridy = 0;
        GridBagConstraints membersConstraints = new GridBagConstraints();
        membersConstraints.anchor = GridBagConstraints.LINE_START;
        membersConstraints.gridwidth = 1;
        membersConstraints.weightx = 1;
        membersConstraints.gridx = 1;
        membersConstraints.gridy = 0;
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.anchor = GridBagConstraints.LINE_END;
        buttonConstraints.gridwidth = 1;
        buttonConstraints.weightx = 0;
        buttonConstraints.gridx = 2;
        buttonConstraints.gridy = 0;
        GridBagConstraints descConstraints = new GridBagConstraints();
        descConstraints.anchor = GridBagConstraints.LINE_START;
        descConstraints.gridwidth = 2;
        descConstraints.weightx = 1;
        descConstraints.gridx = 0;
        descConstraints.gridy = 1;

        this.setLayout(societyLayout);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel name = new JLabel(s.getName() + ": ");
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        this.add(name, nameConstraints);
        JLabel members = new JLabel(s.getMembers().size() + " member(s)");
        members.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));
        this.add(members, membersConstraints);
        button = new JButton();
        this.add(button, buttonConstraints);
        JLabel desc = new JLabel(s.getDescription());
        desc.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        this.add(desc, descConstraints);
    }

    public JButton getButton() {
        return button;
    }
}
