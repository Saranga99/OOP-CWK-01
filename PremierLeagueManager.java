import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {
    private final int numberOfFootballClubs;
    private List<FootballClub> footballClubsList = new ArrayList<>();
    private List<FootballMatch> footballMatchList = new ArrayList<>();
    private final Scanner gettingInputs = new Scanner(System.in);
    private File txtFootballClubs = new File("FootballClubs.txt");
    private File txtFootballMatches = new File("FootballMatches.txt");

    public PremierLeagueManager(int numberOfFootballClubs) {
        loadingData();
        loadingMatchesData();
        this.numberOfFootballClubs = numberOfFootballClubs;
    }

    @Override
    public void addingFootballClubToLeague() throws IOException {
        if (footballClubsList.size() != numberOfFootballClubs) {

            System.out.println("\n__Adding a Football Club to Premier League__\n");
            boolean subMenu = true;
            while (subMenu) {
                System.out.println("Enter Football Club Name     : ");
                String footballClubName = gettingInputs.nextLine();
                footballClubName = footballClubName.toUpperCase();
                for (FootballClub footballClub : footballClubsList) {
                    if (footballClub.getClubName().equals(footballClubName)) {
                        System.out.println("\nINFORMATION>>>>>> " + footballClub.getClubName() + " Already in League\n");
                        subMenu = false;
                    }
                }
                if (subMenu) {
                    System.out.println("\n__Type of Football Clubs__\n");
                    System.out.println("Adding a Football Club             : Press 1");
                    System.out.println("Adding an University Football Club : Press 2");
                    System.out.println("Adding a School Football Club      : Press 3");
                    String input = gettingInputs.nextLine();
                    int action = 0;
                    try {
                        action = Integer.parseInt(input);
                    } catch (Exception e) {
                    }
                    switch (action) {
                        case 1:
                            System.out.println("Enter Football Club Location : ");
                            String footballClubLocation = gettingInputs.nextLine();
                            FootballClub footballClub = new FootballClub(footballClubName, footballClubLocation);
                            footballClubsList.add(footballClub);
                            System.out.println("\nINFORMATION>>>>>> " + footballClub.getClubName() + " Club is Added to the League\n");
                            saveClubsInFile((ArrayList) footballClubsList);
                            subMenu = false;
                            break;
                        case 2:
                            System.out.println("Enter University FootballClub Club Location : ");
                            String universityFootballCluLocation = gettingInputs.nextLine();
                            System.out.println("Enter University Name                       : ");
                            String universityName = gettingInputs.nextLine();
                            FootballClub universityFootballClub = new UniversityFootballClub(footballClubName, universityFootballCluLocation, universityName);
                            footballClubsList.add(universityFootballClub);
                            System.out.println("\nINFORMATION>>>>>> " + universityFootballClub.getClubName() + " Club is Added to the League\n");
                            saveClubsInFile((ArrayList) footballClubsList);
                            subMenu = false;
                            break;
                        case 3:
                            System.out.println("Enter School FootballClub Club Location : ");
                            String schoolFootballCluLocation = gettingInputs.nextLine();
                            System.out.println("Enter School Name                       : ");
                            String schoolName = gettingInputs.nextLine();
                            FootballClub schoolFootballClub = new SchoolFootballClub(footballClubName, schoolFootballCluLocation, schoolName);
                            footballClubsList.add(schoolFootballClub);
                            System.out.println("\nINFORMATION>>>>>> " + schoolFootballClub.getClubName() + " Club is Added to the League\n");
                            saveClubsInFile((ArrayList) footballClubsList);
                            subMenu = false;
                            break;
                        default:
                            System.out.println("\nERROR>>>>> Please Enter Valid Input\n");
                    }

                }
            }
        } else {
            System.out.println("\nERROR>>>>> League Clubs list is Full\n");
        }

    }

    @Override
    public void removeFootballClubFromLeague() throws IOException {
        if (footballClubsList.size() == 0) {
            System.out.println("\nInvalid Operation>>>>> No Football Clubs in League\n ");
        } else {
            System.out.println("\n__Remove Club from Premier League__\n");
            boolean footballClubNotHere = true;
            while (footballClubNotHere) {
                System.out.println("Enter Club Name here : ");
                String footballClubName = gettingInputs.nextLine();
                footballClubName = footballClubName.toUpperCase();
                for (FootballClub footballClub : footballClubsList) {
                    if (footballClub.getClubName().equals(footballClubName)) {
                        footballClubsList.remove(footballClub);
                        System.out.println("\nINFORMATION>>>>>> " + footballClub.getClubName() + " Club is Removed from League\n");
                        saveClubsInFile((ArrayList) footballClubsList);
                        footballClubNotHere = false;
                        break;
                    }
                }
                if (footballClubNotHere) {
                    System.out.println("\nERROR>>>>> Please Enter Valid Club Name\n");
                }
            }
        }


    }

    @Override
    public void displayFootballClubStatistics() {
        if (footballClubsList.size() == 0) {
            System.out.println("\nInvalid Operation>>>>> No Football Clubs in League\n ");
        } else {
            System.out.println("\n__Club Statistics in Premier League__\n");
            boolean footballClubNotHere = true;
            while (footballClubNotHere) {
                System.out.println("Enter Club Name here : ");
                String footballClubName = gettingInputs.nextLine();
                footballClubName = footballClubName.toUpperCase();
                for (FootballClub footballClub : footballClubsList) {
                    if (footballClub.getClubName().equals(footballClubName)) {
                        System.out.println("\nClub Name        : " + footballClub.getClubName());
                        System.out.println("Club Location    : " + footballClub.getClubLocation());
                        if (footballClub.getSchoolName() != null) {
                            System.out.println("School Name      : " + footballClub.getSchoolName());
                        }
                        if (footballClub.getUniversityName() != null) {
                            System.out.println("University Name  : " + footballClub.getUniversityName());
                        }
                        System.out.println("Win Count        : " + footballClub.getWinCount());
                        System.out.println("Defeat Count     : " + footballClub.getDefeatCount());
                        System.out.println("Draw Count       : " + footballClub.getDrawCount());
                        System.out.println("Club Points      : " + footballClub.getPoints());
                        System.out.println("Goal Difference  : " + footballClub.getGoalDifferenceCount());
                        System.out.println("Matches Played   : " + footballClub.getMatchesPlayed());
                        System.out.println("win Percentage   : " + footballClub.getWiningPercentage() + "%");

                        footballClubNotHere = false;
                        break;
                    }
                }
                if (footballClubNotHere) {
                    System.out.println("\nERROR>>>>> Please Enter Valid Club Name\n");
                }
            }
        }
    }

    @Override
    public void displayPremierLeagueTable() {
        if (footballClubsList.size() == 0) {
            System.out.println("\nInvalid Operation>>>>> No Football Clubs in League\n ");
        } else {
            Collections.sort(footballClubsList);
            System.out.printf("%-50s%10s%10s%10s%10s%20s%10s%10s%10s%10s\n", "Club Name", "Played", "Won", "Lost", "Drawn", "Wining Percentage", "GF", "GA", "GD", "Points");
            for (FootballClub footballClub : footballClubsList) {
                System.out.printf("%-50s%5s%10s%10s%10s%20s%10s%10s%10s%10s\n", footballClub.getClubName(), footballClub.getMatchesPlayed(), footballClub.getWinCount()
                        , footballClub.getDefeatCount(), footballClub.getDrawCount(), footballClub.getWiningPercentage(), footballClub.getScoredGoalsCount(),
                        footballClub.getReceivedGoalsCount(), footballClub.getGoalDifferenceCount(), footballClub.getPoints());
            }
            System.out.println("\nGF : Goals for");
            System.out.println("GA : Goals Against");
            System.out.println("GD : Goal Difference");
        }


    }

    @Override
    public void addPlayedMatch() throws IOException {
        if (footballClubsList.size() > 1) {
            System.out.println("\n__Add Played Match in Premier League__\n");
            Date date = null;
            boolean validDate = true;
            while (validDate) {
                System.out.println("Enter Date (format DD-MM-YYYY) : ");
                String input = gettingInputs.nextLine();
                try {
                    date = new SimpleDateFormat("DD-MM-YYYY").parse(input);
                    validDate = false;
                } catch (Exception e) {
                    System.out.println("\nERROR>>>>> Please Enter Valid Date with Valid Format\n");

                }
            }
            FootballClub home = null;
            boolean teamInLeague = true;
            while (teamInLeague) {
                System.out.println("Enter Home Team : ");
                String input = gettingInputs.nextLine();
                input = input.toUpperCase();
                for (FootballClub footballClub : footballClubsList) {
                    if (footballClub.getClubName().equals(input)) {
                        home = footballClub;
                        teamInLeague = false;
                        break;
                    }
                }
                if (home == null) {
                    System.out.println("\nERROR>>>>> Please Enter Club in premier League\n");
                }
            }
            FootballClub away = null;
            teamInLeague = true;
            while (teamInLeague) {
                System.out.println("Enter Away Team : ");
                String input = gettingInputs.nextLine();
                input = input.toUpperCase();
                for (FootballClub footballClub : footballClubsList) {
                    if (footballClub.getClubName().equals(input)) {
                        if (!(footballClub.getClubName().equals(home.getClubName()))) {
                            away = footballClub;
                            teamInLeague = false;
                            break;
                        } else {
                            System.out.println("\nERROR>>>>> Already Entered as Home Team\n");
                            away = footballClub;
                        }

                    }
                }
                if (away == null) {
                    System.out.println("\nERROR>>>>> Please Enter Club in premier League\n");
                }
            }
            boolean validGoalCount = true;
            int homeGoals = -1;
            while (validGoalCount) {
                System.out.println("Enter Home Team Goals  : ");
                String input = gettingInputs.nextLine();
                try {
                    homeGoals = Integer.parseInt(input);
                    validGoalCount = false;
                } catch (Exception e) {
                }
                if (homeGoals == -1) {
                    System.out.println("\nERROR>>>>> Please Enter Valid Goal Amount\n");
                }
            }
            validGoalCount = true;
            int awayGoals = -1;
            while (validGoalCount) {
                System.out.println("Enter Away Team Goals  : ");
                String input = gettingInputs.nextLine();
                try {
                    awayGoals = Integer.parseInt(input);
                    validGoalCount = false;
                } catch (Exception e) {
                }
                if (awayGoals == -1) {
                    System.out.println("\nERROR>>>>> Please Enter Valid Goal Amount\n");
                }
            }
            FootballMatch footballMatch = new FootballMatch();
            footballMatch.setDate(date);
            footballMatch.setTeamA(home);
            footballMatch.setTeamB(away);
            footballMatch.setTeamAScore(awayGoals);
            footballMatch.setTeamBScore(homeGoals);
            footballMatchList.add(footballMatch);
            home.setScoredGoalsCount(home.getScoredGoalsCount() + homeGoals);
            away.setScoredGoalsCount(away.getScoredGoalsCount() + awayGoals);
            home.setReceivedGoalsCount(home.getReceivedGoalsCount() + awayGoals);
            away.setReceivedGoalsCount(away.getReceivedGoalsCount() + homeGoals);
            home.setMatchesPlayed(home.getMatchesPlayed() + 1);
            away.setMatchesPlayed(away.getMatchesPlayed() + 1);

            if (homeGoals > awayGoals) {
                home.setPoints(home.getPoints() + 3);
                home.setWinCount(home.getWinCount() + 1);
                away.setDefeatCount(away.getDefeatCount() + 1);
            } else if (homeGoals < awayGoals) {
                away.setPoints(home.getPoints() + 3);
                away.setWinCount(home.getWinCount() + 1);
                home.setDefeatCount(away.getDefeatCount() + 1);
            } else {
                away.setPoints(home.getPoints() + 1);
                away.setPoints(home.getPoints() + 1);
                home.setDrawCount(home.getDefeatCount() + 1);
                away.setDrawCount(away.getDefeatCount() + 1);
            }
            home.setWiningPercentage();
            away.setWiningPercentage();
            System.out.println("\nINFORMATION>>>>>> Match added to League\n");
            saveClubsInFile((ArrayList) footballClubsList);
        } else {
            System.out.println("\nInvalid Operation>>>>> More than One Club should in League\n ");
        }


    }

    @Override
    public void matchesSummary() throws IOException {
        if (footballMatchList.size() == 0) {
            System.out.println("\nInvalid Operation>>>>> No Matches played in League\n ");
        } else {
            System.out.println("\n__Premier League Match Summary__\n");
            System.out.println("No of Football Clubs in League : " + footballClubsList.size());
            System.out.println("No of Matches played in League : " + footballMatchList.size());
            int matchCount = 1;
            for (FootballMatch footballMatch : footballMatchList) {
                System.out.println("\nMatch No      : " + matchCount);
                matchCount++;
                System.out.println(footballMatch);
            }
            saveMatchesInFile((ArrayList) footballMatchList);
        }


    }

    @Override
    public void resetClubStatistics() {
        if (footballClubsList.size() == 0) {
            System.out.println("\nInvalid Operation>>>>> No Football Clubs in League\n ");

        } else {
            for (FootballClub footballClub : footballClubsList) {
                footballClub.setMatchesPlayed(0);
                footballClub.setScoredGoalsCount(0);
                footballClub.setReceivedGoalsCount(0);
                footballClub.setGoalDifferenceCount(0);
                footballClub.setPoints(0);
            }

        }
    }

    @Override
    public void saveClubsInFile(ArrayList footballClubs) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(txtFootballClubs);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(footballClubs);
        objectOutputStream.close();


    }

    @Override
    public void saveMatchesInFile(ArrayList footballMatches) throws IOException {
        FileOutputStream fileOutputStream1 = new FileOutputStream(txtFootballMatches);
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
        objectOutputStream1.writeObject(footballMatches);
    }

    @Override
    public void loadingData() {
        try {
            FileInputStream fileInputStream = new FileInputStream(txtFootballClubs);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            footballClubsList = (ArrayList) objectInputStream.readObject();

        } catch (Exception e) {

        }


    }

    @Override
    public void loadingMatchesData() {
        try {
            FileInputStream fileInputStream1 = new FileInputStream(txtFootballMatches);
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
            footballMatchList = (ArrayList) objectInputStream1.readObject();

        } catch (Exception e) {
        }
    }
}