import java.io.IOException;
import java.util.ArrayList;
public interface LeagueManager {

    void addingFootballClubToLeague() throws IOException;

    void removeFootballClubFromLeague() throws IOException;

    void displayFootballClubStatistics();

    void displayPremierLeagueTable();

    void addPlayedMatch() throws IOException;

    void matchesSummary() throws IOException;

    void resetClubStatistics() throws IOException;

    void saveClubsInFile(ArrayList footballClubs) throws IOException;

    void saveMatchesInFile(ArrayList footballMatches) throws IOException;

    void loadingClubsData() throws IOException;

    void loadingMatchesData() throws IOException;


}
