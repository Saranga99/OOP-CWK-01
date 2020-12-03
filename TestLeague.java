import java.io.IOException;
import java.util.Scanner;

public class TestLeague {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Scanner gettingInputs = new Scanner(System.in);
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager(4);
        System.out.println("\n                     ||||||______FOOTBALL LEAGUE MANAGEMENT SYSTEM______||||||\n");

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
            System.out.println("Exit from Application              : Press 8");
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
                    mainMenu = false;
                    break;
                default:
                    System.out.println("\nERROR>>>>> Please Enter Valid Input\n");
            }
        }


    }

}
