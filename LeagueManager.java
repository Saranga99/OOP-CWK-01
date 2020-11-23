import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LeagueManager premierLeagueManager = new PremierLeagueManager(4);
    }

    void showMainMenu() throws IOException;

    void addingFootballClubToLeague() throws IOException;

    void removeFootballClubFromLeague();

    void displayFootballClubStatistics();

    void displayPremierLeagueTable();

    void addPlayedMatch();

    void matchesSummary();

    void saveClubsInFile(ArrayList footballClubs) throws IOException;

    void saveMatchesInFile(ArrayList footballMatches) throws IOException;

    void loadingData() throws IOException, ClassNotFoundException;

    void loadingMatchesData() throws IOException, ClassNotFoundException;


}
