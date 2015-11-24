package MunSocMan;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class HomePanel extends JPanel {

    private JButton allSocButton;
    private JButton mySocButton;
    private JButton createSocButton;

    public HomePanel(SocietyManager socMan) {
        this.setLayout(new GridLayout(4, 1));
        JLabel title = new JLabel("Home");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);
        allSocButton = new JButton("All Societies");
        this.add(allSocButton);
        mySocButton = new JButton("My Societies");
        this.add(mySocButton);
        createSocButton = new JButton("Create New Society");
        this.add(createSocButton);
    }

    public JButton getAllSocButton() {
        return allSocButton;
    }

    public JButton getMySocButton() {
        return mySocButton;
    }

    public JButton createSocButton() {
        return createSocButton;
    }

}
