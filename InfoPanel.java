package MunSocMan;

import java.awt.*;
//import java.awt.Color;
//import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

   private JPanel basicInfo, events;
   private JTextArea basicInfoArea, eventsArea;
   private Society society;
   private boolean userIsMember,nullUser;

   public InfoPanel(Student user, Society society){
     this.nullUser = false;
     if (user == null){
       nullUser = true;
     }
     this.basicInfo = new JPanel();
     this.events = new JPanel();
     this.society = society;
     if (!nullUser){
       this.userIsMember = user.isMember(society);
     }
     else {
       userIsMember = false;
     }
     this.basicInfoArea = new JTextArea();
     this.eventsArea = new JTextArea();

     getInfo(user, society);
     getEvents(society);
     basicInfo.add(basicInfoArea);
     events.add(eventsArea);

     basicInfo.setBackground(this.getBackground());
     events.setBackground(this.getBackground());

     this.setLayout(new GridLayout(0,1));
     this.add(basicInfo);
     this.add(events);
   }

   private void getInfo(Student user, Society society){
     String infoString = "Name: " + society.getName() + "\nDescription " + society.getDescription() + "\n\n";
     if (userIsMember){
       infoString += "You are a member of this society.\n";
     }
     else {
       infoString += "You are not currently a member of this society.\n";
     }
     if (society.isSanctioned()){
       infoString += society.getName() + " is a sanctioned society.\n";
     }
     else {
       infoString += society.getName() + " is an unsanctioned society.\n";
     }
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
