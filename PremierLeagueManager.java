import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {
    private final int numberOfFootballClubs;
    private List<FootballClub> clubList = new ArrayList<>();
    private List<FootballMatch> matchList = new ArrayList<>();
    private final Scanner gettingInputs = new Scanner(System.in);
    private File txtFootballClubs = new File("FootballClubs.txt");
    private File txtFootballMatches = new File("FootballMatches.txt");

    public PremierLeagueManager(int numberOfFootballClubs) throws IOException {
        loadingData();
        loadingMatchesData();
        this.numberOfFootballClubs = numberOfFootballClubs;
        showMainMenu();
    }

    @Override
    public void showMainMenu() throws IOException {
        boolean mainMenu = true;
        while (mainMenu) {
            System.out.println("\n__Premier League Main Menu__\n");
            System.out.println("Adding a New Football Club         : Press 1");
            System.out.println("Remove Football Club from League   : Press 2");
            System.out.println("Display Football Club Statistics   : Press 3");
            System.out.println("Display Premier League Table       : Press 4");
            System.out.println("Add Played Match                   : Press 5");
            System.out.println("Display Matches Summary            : Press 6");
            System.out.println("Exit from Application              : Press 7");
            String input = gettingInputs.nextLine();
            int action = 0;
            try {
                action = Integer.parseInt(input);
            } catch (Exception e) {
            }
            switch (action) {
                case 1:
                    if (clubList.size() == numberOfFootballClubs) {
                        System.out.println("\nERROR>>>>> List full\n");
                    } else {
                        addingFootballClubToLeague();
                        saveClubsInFile((ArrayList) clubList);
                    }
                    break;
                case 2:
                    if (clubList.size() == 0) {
                        System.out.println("\nInvalid Operation>>>>> No Football Clubs in League\n ");
                    } else {
                        removeFootballClubFromLeague();
                        saveClubsInFile((ArrayList) clubList);
                    }
                    break;
                case 3:
                    if (clubList.size() == 0) {
                        System.out.println("\nInvalid Operation>>>>> No Football Clubs in League\n ");
                    } else {
                        displayFootballClubStatistics();
                    }
                    break;
                case 4:
                    if (clubList.size() == 0) {
                        System.out.println("\nInvalid Operation>>>>> No Football Clubs in League\n ");
                    } else {
                        displayPremierLeagueTable();
                    }
                    break;
                case 5:
                    if (clubList.size() > 1) {
                        addPlayedMatch();
                        saveClubsInFile((ArrayList) clubList);
                    } else {
                        System.out.println("\nInvalid Operation>>>>> More than One Club should in League\n ");
                    }
                    break;
                case 6:
                    if (matchList.size() == 0) {
                        System.out.println("\nInvalid Operation>>>>> No Matches played in League\n ");
                    } else {
                        matchesSummary();
                        saveMatchesInFile((ArrayList) matchList);
                    }
                    break;
                case 7:
                    saveClubsInFile((ArrayList) clubList);
                    saveMatchesInFile((ArrayList) matchList);
                    mainMenu = false;
                    break;
                default:
                    System.out.println("\nERROR>>>>> Please Enter Valid Input\n");
            }
        }
    }

    @Override
    public void addingFootballClubToLeague() {

        System.out.println("\n__Adding a Football Club to Premier League__\n");
        boolean subMenu = true;
        while (subMenu) {
            System.out.println("Enter Football Club Name     : ");
            String footballClubName = gettingInputs.nextLine();
            footballClubName = footballClubName.toUpperCase();
            for (FootballClub footballClub : clubList) {
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
                        clubList.add(footballClub);
                        System.out.println("\nINFORMATION>>>>>> " + footballClub.getClubName() + " Club is Added to the League\n");
                        subMenu = false;
                        break;
                    case 2:
                        System.out.println("Enter University FootballClub Club Location : ");
                        String universityFootballCluLocation = gettingInputs.nextLine();
                        System.out.println("Enter University Name                       : ");
                        String universityName = gettingInputs.nextLine();
                        FootballClub universityFootballClub = new UniversityFootballClub(footballClubName, universityFootballCluLocation, universityName);
                        clubList.add(universityFootballClub);
                        System.out.println("\nINFORMATION>>>>>> " + universityFootballClub.getClubName() + " Club is Added to the League\n");
                        subMenu = false;
                        break;
                    case 3:
                        System.out.println("Enter School FootballClub Club Location : ");
                        String schoolFootballCluLocation = gettingInputs.nextLine();
                        System.out.println("Enter School Name                       : ");
                        String schoolName = gettingInputs.nextLine();
                        FootballClub schoolFootballClub = new SchoolFootballClub(footballClubName, schoolFootballCluLocation, schoolName);
                        clubList.add(schoolFootballClub);
                        System.out.println("\nINFORMATION>>>>>> " + schoolFootballClub.getClubName() + " Club is Added to the League\n");
                        subMenu = false;
                        break;
                    default:
                        System.out.println("\nERROR>>>>> Please Enter Valid Input\n");
                }

            }
        }

    }

    @Override
    public void removeFootballClubFromLeague() {
        System.out.println("\n__Remove Club from Premier League__\n");
        boolean footballClubNotHere = true;
        while (footballClubNotHere) {
            System.out.println("Enter Club Name here : ");
            String footballClubName = gettingInputs.nextLine();
            footballClubName = footballClubName.toUpperCase();
            for (FootballClub footballClub : clubList) {
                if (footballClub.getClubName().equals(footballClubName)) {
                    clubList.remove(footballClub);
                    System.out.println("\nINFORMATION>>>>>> " + footballClub.getClubName() + " Club is Removed from League\n");
                    footballClubNotHere = false;
                    break;
                }
            }
            if (footballClubNotHere) {
                System.out.println("\nERROR>>>>> Please Enter Valid Club Name\n");
            }
        }


    }

    @Override
    public void displayFootballClubStatistics() {
        System.out.println("\n__Club Statistics in Premier League__\n");
        boolean footballClubNotHere = true;
        while (footballClubNotHere) {
            System.out.println("Enter Club Name here : ");
            String footballClubName = gettingInputs.nextLine();
            footballClubName = footballClubName.toUpperCase();
            for (FootballClub footballClub : clubList) {
                if (footballClub.getClubName().equals(footballClubName)) {
                    System.out.println("\nClub Name        : " + footballClub.getClubName());
                    System.out.println("Club Location    : " + footballClub.getClubLocation());
                    System.out.println("School Name      : " + footballClub.getSchoolName());
                    System.out.println("University Name  : " + footballClub.getUniversityName());
                    System.out.println("Win Count        : " + footballClub.getWinCount());
                    System.out.println("Defeat Count     : " + footballClub.getDefeatCount());
                    System.out.println("Draw Count       : " + footballClub.getDrawCount());
                    System.out.println("Club Points      : " + footballClub.getPoints());
                    System.out.println("Goal Difference  : " + footballClub.getGoalDifferenceCount());
                    System.out.println("Matches Played   : " + footballClub.getMatchesPlayed());
                    footballClubNotHere = false;
                    break;
                }
            }
            if (footballClubNotHere) {
                System.out.println("\nERROR>>>>> Please Enter Valid Club Name\n");
            }
        }


    }

    @Override
    public void displayPremierLeagueTable() {

    }

    @Override
    public void addPlayedMatch() {
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
            for (FootballClub footballClub : clubList) {
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
            for (FootballClub footballClub : clubList) {
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
        matchList.add(footballMatch);
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


    }

    @Override
    public void matchesSummary() {
        System.out.println("\n__Premier League Match Summary__\n");
        int matchCount = 1;
        for (FootballMatch footballMatch : matchList) {
            System.out.println("\nMatch No     : " + matchCount);
            matchCount++;
            System.out.println(footballMatch);
        }

    }

    @Override
    public void saveClubsInFile(ArrayList footballClubs) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(txtFootballClubs);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(footballClubs);


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
            ArrayList footballClubs = (ArrayList) objectInputStream.readObject();
            clubList = footballClubs;
        } catch (Exception e) {
        }


    }

    @Override
    public void loadingMatchesData() {
        try {
            FileInputStream fileInputStream1 = new FileInputStream(txtFootballMatches);
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
            ArrayList footballMatches = (ArrayList) objectInputStream1.readObject();
            matchList = footballMatches;
        } catch (Exception e) {
        }
    }
}
