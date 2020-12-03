import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {
    //void showMainMenu() throws IOException;

    void addingFootballClubToLeague() throws IOException;

    void removeFootballClubFromLeague() throws IOException;

    void displayFootballClubStatistics();

    void displayPremierLeagueTable();

    void addPlayedMatch() throws IOException;

    void matchesSummary() throws IOException;

    void resetClubStatistics();

    void saveClubsInFile(ArrayList footballClubs) throws IOException;

    void saveMatchesInFile(ArrayList footballMatches) throws IOException;

    void loadingData() throws IOException, ClassNotFoundException;

    void loadingMatchesData() throws IOException, ClassNotFoundException;


}
