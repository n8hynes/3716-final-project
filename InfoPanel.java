package MunSocMan;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

    private JPanel basicInfo;
    private JPanel events;
    private JTextArea basicInfoArea;
    private JTextArea eventsArea;
    private Society society;
    private boolean userIsMember;

    public InfoPanel(Student user, Society society) {

        basicInfo = new JPanel();
        events = new JPanel();
        this.society = society;
        if (user != null) userIsMember = user.isMember(society);
        else userIsMember = false;
        basicInfoArea = new JTextArea();
        eventsArea = new JTextArea();

        getInfo(user, society);
        getEvents(society);
        basicInfo.add(basicInfoArea);
        events.add(eventsArea);

        basicInfoArea.setBackground(this.getBackground());
        basicInfoArea.setEditable(false);
        eventsArea.setBackground(this.getBackground());
        eventsArea.setEditable(false);

        this.setLayout(new GridLayout(0,1));
        this.add(basicInfo);
        this.add(events);

    }

    private void getInfo(Student user, Society society){

        String infoString = "Name: " + society.getName() + "\nDescription " + society.getDescription() + "\n\n";

        if (userIsMember) infoString += "You are a member of this society.\n";
        else infoString += "You are not currently a member of this society.\n";

        if (society.isSanctioned()) infoString += society.getName() + " is a sanctioned society.\n";
        else infoString += society.getName() + " is an unsanctioned society.\n";

        infoString += "Society Leader: " + society.getLeader().getStudent().getName() +"\n";

        infoString += "Monthly fees: $" + society.getFeeAmount();

        basicInfoArea.setText(infoString);

    }

    private void getEvents(Society society){
        if (society.getEvents().size() == 0){
            eventsArea.setText("This society has no upcoming events.");
        }
        else {
            String eventText = "";
            for (Event e : society.getEvents()){
                eventText += e.toString() + "\n";
            }
            eventsArea.setText(eventText);
        }
    }
}
