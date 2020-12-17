import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class TestLeague extends Application {
    final Scanner gettingInputs = new Scanner(System.in);
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager(4);

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println("\n                     ||||||______FOOTBALL LEAGUE MANAGEMENT SYSTEM______||||||\n");
        TestLeague testLeague = new TestLeague();
        testLeague.mainMenu();
    }

    public void mainMenu() throws IOException {
        boolean mainMenu = true;
        while (mainMenu) {
            System.out.println("\n__Premier League Main Menu__\n");
            System.out.println("Adding a New Football Club         : Press 1");
            System.out.println("Remove Football Club from League   : Press 2");
            System.out.println("Display Football Club Statistics   : Press 3");
            System.out.println("Display Premier League Table       : Press 4");
            System.out.println("Add Played Match                   : Press 5");
            System.out.println("Display Matches Summary            : Press 6");
            System.out.println("Reset Club Statistics              : Press 7");
            System.out.println("Show GUI with League Table         : Press 8");
            System.out.println("Exit from Application              : Press 9");
            String input = gettingInputs.nextLine();
            int action = 0;
            try {
                action = Integer.parseInt(input);
            } catch (Exception e) {
            }
            switch (action) {
                case 1:
                    premierLeagueManager.addingFootballClubToLeague();
                    break;
                case 2:
                    premierLeagueManager.removeFootballClubFromLeague();
                    break;
                case 3:
                    premierLeagueManager.displayFootballClubStatistics();
                    break;
                case 4:
                    premierLeagueManager.displayPremierLeagueTable();
                    break;
                case 5:
                    premierLeagueManager.addPlayedMatch();
                    break;
                case 6:
                    premierLeagueManager.matchesSummary();
                    break;
                case 7:
                    premierLeagueManager.resetClubStatistics();
                    break;
                case 8:
                    GUI showPrimaryStage = new GUI();
                    showPrimaryStage.guiWindow();
                    mainMenu = false;
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("\nERROR>>>>> Please Enter Valid Input\n");
            }
        }
    }
}
