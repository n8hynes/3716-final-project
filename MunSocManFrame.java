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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class MunSocManFrame extends JFrame {

    private SocietyManager socMan;
    private Student user;
    private JPanel content;
    private HomePanel home;
    private AllSocietiesPanel allSocieties;
    private MySocietiesPanel mySocieties;
    private CreateSocietyPanel createSociety;
    private UserPanel chooseUser;
    private ActionListener homeAction;
    private ActionListener allSocietiesAction;
    private ActionListener mySocietiesAction;
    private ActionListener createAction;
    private ActionListener chooseUserAction;

    public MunSocManFrame() {

        homeAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home();
            }
        };
        allSocietiesAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                allSoc();
            }
        };
        mySocietiesAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mySoc();
            }
        };
        createAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                create();
            }
        };
        chooseUserAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseUser();
            }
        };

        socMan = new SocietyManager();

        setTitle("MunSocMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 500, 500);
        content = new JPanel();
        content.setBorder(new EmptyBorder(5, 5, 5, 5));
        content.setLayout(new BorderLayout());
        setContentPane(content);

        chooseUser = new UserPanel(socMan, user);
        chooseUser.getSubmitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user = (Student) chooseUser.getUserList().getSelectedItem();
                newUser();
                home();
            }
        });
        chooseUser.getNewStudentButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newStudent();
            }
        });
        chooseUser();

        initPanels();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu socMenu = new JMenu("Societies");
        socMenu.setMnemonic(KeyEvent.VK_S);
        menuBar.add(socMenu);

        JMenuItem allSocItem = new JMenuItem("All Societies");
        allSocItem.setMnemonic(KeyEvent.VK_A);
        allSocItem.addActionListener(allSocietiesAction);
        socMenu.add(allSocItem);

        JMenuItem mySocItem = new JMenuItem("My Societies");
        mySocItem.setMnemonic(KeyEvent.VK_M);
        mySocItem.addActionListener(mySocietiesAction);
        socMenu.add(mySocItem);

        JMenuItem createSocItem = new JMenuItem("Create Society");
        createSocItem.setMnemonic(KeyEvent.VK_C);
        createSocItem.addActionListener(createAction);
        socMenu.add(createSocItem);

        JMenu userMenu = new JMenu("Users");
        userMenu.setMnemonic(KeyEvent.VK_U);
        menuBar.add(userMenu);

        JMenuItem chooseUserItem = new JMenuItem("Choose User");
        chooseUserItem.setMnemonic(KeyEvent.VK_L);
        chooseUserItem.addActionListener(chooseUserAction);
        userMenu.add(chooseUserItem);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                socMan.save();
            }
        });

    }

    public void home() {
        content.removeAll();
        content.add(home);
        content.revalidate();
        content.repaint();
    }

    public void allSoc() {
        content.removeAll();
        allSocieties.update(socMan, user);
        content.add(allSocieties);
        content.revalidate();
        content.repaint();
    }

    public void mySoc() {
        content.removeAll();
        mySocieties.update(socMan, user);
        content.add(mySocieties);
        content.revalidate();
        content.repaint();
    }

    public void create() {
        content.removeAll();
        content.add(createSociety);
        content.revalidate();
        content.repaint();
    }

    public void chooseUser() {
        content.removeAll();
        content.add(chooseUser);
        content.revalidate();
        content.repaint();
    }

    public void newStudent() {
        NewStudentPanel p = new NewStudentPanel(socMan, user);
        p.getSubmitButton().addActionListener(new NewStudentActionListener(socMan, user, p, this));
        content.removeAll();
        content.add(p);
        content.revalidate();
        content.repaint();
    }

    public void initPanels() {
        home = new HomePanel(socMan);
        home.getAllSocButton().addActionListener(allSocietiesAction);
        home.getMySocButton().addActionListener(mySocietiesAction);
        home.getCreateSocButton().addActionListener(createAction);

        allSocieties = new AllSocietiesPanel(socMan, user);
        allSocieties.getHomeButton().addActionListener(homeAction);

        mySocieties = new MySocietiesPanel(socMan, user);
        mySocieties.getHomeButton().addActionListener(homeAction);

        createSociety = new CreateSocietyPanel(socMan, user);
        createSociety.getHomeButton().addActionListener(homeAction);
        createSociety.getSubmitButton().addActionListener(homeAction);
    }

    public void newUser() {
        chooseUser = new UserPanel(socMan, user);
        chooseUser.getSubmitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user = (Student) chooseUser.getUserList().getSelectedItem();
                newUser();
                home();
            }
        });
        chooseUser.getNewStudentButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newStudent();
            }
        });

        allSocieties = new AllSocietiesPanel(socMan, user);
        allSocieties.getHomeButton().addActionListener(homeAction);

        mySocieties = new MySocietiesPanel(socMan, user);
        mySocieties.getHomeButton().addActionListener(homeAction);

        createSociety = new CreateSocietyPanel(socMan, user);
        createSociety.getHomeButton().addActionListener(homeAction);
        createSociety.getSubmitButton().addActionListener(homeAction);
    }

}
