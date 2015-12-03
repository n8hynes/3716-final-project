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

@SuppressWarnings("serial")
public class MySocietiesPanel extends JPanel {

    private JPanel list;
    private JButton homeButton;

    public MySocietiesPanel(SocietyManager socMan, Student user) {
        list = new JPanel();
        if (user != null) {
            getList(socMan, user, user.getSocieties().size());
        }
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
        if (user != null) {
            getList(socMan, user, user.getSocieties().size());
        }
        this.revalidate();
        this.repaint();
    }

    public void getList(SocietyManager socMan, Student user, int n) {
        list.removeAll();
        list.setLayout(new GridLayout(n, 1));
        for (Membership m : user.getSocieties()) {
            SocietyPanel soc = new SocietyPanel(m.getSociety(), m.getStudent());
            soc.getButton().setText("Leave");
            soc.getButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int n = m.getSociety().getMembers().size();
                    socMan.removeMembership(m);
                    if (m.getSociety().getMembers().size() < n) JOptionPane.showMessageDialog(null, "You have successfully left " + m.getSociety().getName() + "!");
                    else JOptionPane.showMessageDialog(null, "Error leaving " + m.getSociety().getName());
                    update(socMan, user);
                }
            });
            list.add(soc);
        }
    }

    public JButton getHomeButton() {
        return homeButton;
    }

}
