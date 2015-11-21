package MunSocMan;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MunSocManFrame extends JFrame {

    private JPanel content;

    public MunSocManFrame() {

        content = new JPanel();
        content.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(content);
        content.setLayout(new BorderLayout(0, 0));
        setTitle("MunSocMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 500, 500);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu socMenu = new JMenu("Societies");
        menuBar.add(socMenu);

        JMenuItem allSocItem = new JMenuItem("All Societies");
        socMenu.add(allSocItem);

        JMenuItem mySocItem = new JMenuItem("My Societies");
        socMenu.add(mySocItem);

    }

}
