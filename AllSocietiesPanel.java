package MunSocMan;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class AllSocietiesPanel extends JPanel {

    private JPanel list;
    private JButton homeButton;

    public AllSocietiesPanel(SocietyManager socMan, Student user) {
        list = new JPanel();
        getList(socMan, user, socMan.getSocieties().size());
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("All Societies");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);
        JScrollPane scroll = new JScrollPane(list);
        this.add(scroll, BorderLayout.CENTER);
        homeButton = new JButton("Home");
        this.add(homeButton, BorderLayout.SOUTH);
    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public void update(SocietyManager socMan, Student user) {
        getList(socMan, user, socMan.getSocieties().size());
        this.revalidate();
        this.repaint();
    }

    public void getList(SocietyManager socMan, Student user, int n) {
        list.removeAll();
        list.setLayout(new GridLayout(n, 1));
        for (Society s : socMan.getSocieties()) {
            SocietyPanel soc = new SocietyPanel(s);
            soc.getJoinButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int n = s.getMembers().size();
                    socMan.addMembership(s, user);
                    if (s.getMembers().size() > n) JOptionPane.showMessageDialog(null, "You have successfully joined " + s.getName() + "!");
                    else JOptionPane.showMessageDialog(null, "You're already a member of " + s.getName() + "!");
                    update(socMan, user);
                }
            });
            list.add(soc);
        }
    }

}
