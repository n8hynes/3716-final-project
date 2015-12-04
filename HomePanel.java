package MunSocMan;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class HomePanel extends JPanel {

    public HomePanel(SocietyManager socMan, Student user) {
        this.setLayout(new GridLayout(2, 1));
        JLabel title = new JLabel("Welcome to MUN SOC MAN");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        title.setForeground(Color.BLUE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);
        JLabel userLabel;
        if (user != null) userLabel = new JLabel("Hello, " + user.getName() + "!");
        else userLabel = new JLabel("Please log in.");
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        this.add(userLabel);
    }

}
