package MunSocMan;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MySocietiesPanel extends JPanel {

    private JPanel list;
    private JButton homeButton;

    public MySocietiesPanel(SocietyManager socMan, Student user) {
        list = new JPanel();
        getList(socMan, user, user.getSocieties().size());
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("My Societies");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);
        JScrollPane scroll = new JScrollPane(list);
        this.add(scroll, BorderLayout.CENTER);
        homeButton = new JButton("Home");
        this.add(homeButton, BorderLayout.SOUTH);

    }

    public void update(SocietyManager socMan, Student user) {
        getList(socMan, user, user.getSocieties().size());
        this.revalidate();
        this.repaint();
    }

    public void getList(SocietyManager socMan, Student user, int n) {
        list.removeAll();
        list.setLayout(new GridLayout(n, 1));
        for (Membership m : user.getSocieties()) {
            SocietyPanel soc = new SocietyPanel(m.getSociety());
            soc.remove(soc.getJoinButton());
            list.add(soc);
        }
    }

    public JButton getHomeButton() {
        return homeButton;
    }

}
