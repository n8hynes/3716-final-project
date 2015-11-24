package MunSocMan;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.ScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MunSocManFrame extends JFrame {

    private SocietyManager socMan;
    private Student user;
    private JPanel content;
    private HomePanel home;
    private AllSocietiesPanel allSocieties;
    private CreateSocietyPanel createSociety;
    private ActionListener allSocietiesAction;
    private ActionListener homeAction;
    private ActionListener createAction;

    public MunSocManFrame() {

        allSocietiesAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                allSoc();
            }
        };
        homeAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home();
            }
        };
        createAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                create();
            }
        };

        socMan = initSocMan();
        user = new Student("John Doe", "123", "Computer Science");
        socMan.addStudent(user);

        setTitle("MunSocMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 500, 500);
        content = new JPanel();
        content.setBorder(new EmptyBorder(5, 5, 5, 5));
        content.setLayout(new BorderLayout());
        setContentPane(content);

        home = new HomePanel(socMan);
        home.getAllSocButton().addActionListener(allSocietiesAction);
        home.getCreateSocButton().addActionListener(createAction);
        allSocieties = new AllSocietiesPanel(socMan, user);
        allSocieties.getHomeButton().addActionListener(homeAction);
        createSociety = new CreateSocietyPanel(socMan, user);
        createSociety.getHomeButton().addActionListener(homeAction);
        createSociety.getSubmitButton().addActionListener(homeAction);
        home();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu socMenu = new JMenu("Societies");
        menuBar.add(socMenu);

        JMenuItem allSocItem = new JMenuItem("All Societies");
        allSocItem.addActionListener(allSocietiesAction);
        socMenu.add(allSocItem);

        JMenuItem mySocItem = new JMenuItem("My Societies");
        socMenu.add(mySocItem);

        JMenuItem createSocItem = new JMenuItem("Create Society");
        createSocItem.addActionListener(createAction);
        socMenu.add(createSocItem);

    }

    public SocietyManager initSocMan() {
        // Dummy data for now, will eventually read information from persistent storage.
        SocietyManager socMan = new SocietyManager();
        socMan.addStudent(new Student("Tim", "123", "Computer Science"));
        socMan.addStudent(new Student("Lorem", "321", "English"));
        int i=1;
        for (Student s : socMan.getStudents()) {
            socMan.addSociety("Society " + i, "Test society number " + i, s);
            i++;
        }
        return socMan;
    }

    public void allSoc() {
        content.removeAll();
        allSocieties.update(socMan, user);
        content.add(allSocieties);
        content.revalidate();
        content.repaint();
    }

    public void home() {
        content.removeAll();
        content.add(home);
        content.revalidate();
        content.repaint();
    }

    public void create() {
        content.removeAll();
        content.add(createSociety);
        content.revalidate();
        content.repaint();
    }

}
