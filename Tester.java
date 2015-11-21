package MunSocMan;

import java.util.Scanner;
import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {

        SocietyManager socMan = new SocietyManager();
        Scanner in = new Scanner(System.in);
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("HELP - displays this list");
        commands.add("CREATE - start creating a society");
        commands.add("LIST - list all current societies");
        commands.add("JOIN - join a current society");
        commands.add("LEAVE - leave a society");
        commands.add("QUIT - exit this program");

        System.out.println("Welcome to the MUN Society Manager");
        boolean correctinfo = false;
        String name = "";
        String studentID = "";
        String major = "";
        while(!correctinfo){
            System.out.println("What's your name?");
            name = in.nextLine();
            System.out.println("What's your Student ID?");
            studentID = in.nextLine();
            System.out.println("What's your major?");
            major = in.nextLine();
            System.out.println("Is this info correct? (Y/N)");
            System.out.println("Name: " + name);
            System.out.println("Student ID: " + studentID);
            System.out.println("Major: " + major);
            if (in.nextLine().toUpperCase().equals("Y")) correctinfo = true;
        }

        Student student = new Student(name, studentID, major);

        socMan.addSociety("MUN CS Society", "Society for MUN CS Students", new Student("Tim", "123", "Computer Science"));

        System.out.println("Welcome, " + student.getName());
        System.out.println("Feel free to create/join societies");
        System.out.println("Type 'HELP' for a list of commands");

        String command = in.nextLine().toUpperCase();
        while(!command.equals("QUIT")) {
            switch(command){
                case "HELP":
                    System.out.println("List of accepted commands:");
                    for (String c : commands) {
                        System.out.println(c);
                    }
                    break;
                case "CREATE":
                    createSociety(socMan, student);
                    break;
                case "JOIN":
                    joinSociety(socMan, student);
                    break;
                case "LIST":
                    if (socMan.getSocieties().size() == 0) {
                        System.out.println("There are currently no societies.");
                        break;
                    }
                    System.out.println("(* indicates you are a member of that society)");
                    ArrayList<Society> mySocieties = new ArrayList<Society>();
                    for (Membership m : student.getSocieties()) {
                        mySocieties.add(m.getSociety());
                    }
                    for (Society s : socMan.getSocieties()) {
                        if (mySocieties.contains(s)) System.out.print("* ");
                        System.out.println(s.getName() + ": " + s.getDescription());
                    }
                    break;
                case "LEAVE":
                    leaveSociety(socMan, student);
                    break;
                default:
                    System.out.println("I'm not sure what you mean to do. Type 'HELP' for a list of commands.");
            }
            command = in.nextLine().toUpperCase();
        }

    }

    public static void createSociety(SocietyManager socMan, Student student) {
        Scanner in = new Scanner(System.in);
        boolean validInfo = false;
        String name = "";
        String description = "";
        while (!validInfo) {
            System.out.println("New Society Name?");
            name = in.nextLine();
            System.out.println("New Society Description?");
            description = in.nextLine();
            System.out.println("Is this info correct? (Y/N)");
            System.out.println("Name: " + name);
            System.out.println("Description: " + description);
            if (in.nextLine().toUpperCase().equals("Y")) validInfo = true;
        }
        socMan.addSociety(name, description, student);
        System.out.println("Society successfully created!");
    }

    public static void joinSociety(SocietyManager socMan, Student student) {
        Scanner in = new Scanner(System.in);
        if (socMan.getSocieties().size() == 0) {
            System.out.println("There are currently no societies to join.");
        }
        else {
            System.out.println("Which society would you like to join?");
            String name = in.nextLine();
            for (Society s : socMan.getSocieties()) {
                if (s.getName().equals(name)) {
                    System.out.println(s.getName() + ": " + s.getDescription());
                    System.out.println("Are you sure you want to join " + name + "? (Y/N)");
                    if (in.nextLine().toUpperCase().equals("Y")) socMan.addMembership(s, student);
                    break;
                }
            }
        }
    }

    public static void leaveSociety(SocietyManager socMan, Student student) {
        Scanner in = new Scanner(System.in);
        System.out.println("Which society would you like to leave?");
        String name = in.nextLine();
        for (Membership m : student.getSocieties()) {
            if (m.getSociety().getName().equals(name)) {
                if (m.getSociety().getLeader() == m) {
                    System.out.println("You cannot leave " + name + ", you are the leader of the society.");
                }
                else {
                    System.out.println(m.getSociety().getName() + ": " + m.getSociety().getDescription());
                    System.out.println("Are you sure you want to leave " + name + "? (Y/N)");
                    if (in.nextLine().toUpperCase().equals("Y")) socMan.removeMembership(m);
                }
                break;
            }
        }
    }

}
