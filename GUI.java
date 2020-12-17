import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GUI {
    private File fileFootballClubs = new File("src/Data/FootballClubs");
    private File fileFootballMatches = new File("src/Data/FootballMatches");
    private TableView clubTable, matchesTable;
    private TextField txtFieldSearch;
    private Label lblBg = GUIComponents.creatingLabelForBackground();
    private Label lblTeams, lblHomeGoals, lblAwayGoals;
    private List<FootballClub> footballClubsList = new ArrayList<>();
    private List<FootballMatch> footballMatchList = new ArrayList<>();
    GUIComponents guiComponents = new GUIComponents();
    private Button btnBack = GUIComponents.createBtnBack();
    private ImageView leagueLogo = GUIComponents.leagueLogo();
    TestLeague testLeague = new TestLeague();


    public void guiWindow() {
        loadingData();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("GUI");

        //adding image to background
        Image image1 = new Image("PICS/Home window/homeBG.jpg");
        ImageView homeBG = new ImageView();
        homeBG.setImage(image1);
        homeBG.setFitWidth(1000);
        homeBG.setFitHeight(800);


        Button btnClubTable = guiComponents.creatingButton("Club Statistics", 500, 350, 100, 200);
        Button btnMatchesTable = guiComponents.creatingButton("Matches", 260, 350, 100, 200);


        Pane homePane = new Pane();
        homePane.getChildren().add(homeBG);
        homePane.getChildren().add(btnClubTable);
        homePane.getChildren().add(btnMatchesTable);
        homePane.getChildren().add(btnBack);
        homePane.getChildren().add(leagueLogo);

        btnClubTable.setOnAction(e -> {
            primaryStage.close();
            GUI showClubTable = new GUI();
            showClubTable.guiClubTableWindow();
        });
        btnMatchesTable.setOnAction(e -> {
            primaryStage.close();
            GUI showMatchesTable = new GUI();
            showMatchesTable.guiMatchesTableWindow();

        });
        btnBack.setOnAction(e -> {
            primaryStage.close();
            try {
                testLeague.mainMenu();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        primaryStage.setScene(new Scene(homePane, 1000, 800));
        primaryStage.show();


    }

    public void guiClubTableWindow() {
        loadingData();
        Collections.sort(footballClubsList);
        Stage clubTableStage = new Stage();
        clubTableStage.setTitle("Club Statistics");

        //adding image to background
        Image image2 = new Image("PICS/clubtableWindow/clubtableBG.jpg");
        ImageView clubTableBG = new ImageView();
        clubTableBG.setImage(image2);
        clubTableBG.setFitWidth(1000);
        clubTableBG.setFitHeight(900);

        clubTable = guiComponents.creatingTable(200, 100, 800, 400);
        Button btnSortByScoredGoalsCount = guiComponents.creatingButton("Sort By Scored Goals", 100, 620, 50, 250);
        Button btnSortByPoints = guiComponents.creatingButton("Sort By Points", 375, 620, 50, 250);
        Button btnSortByWinCount = guiComponents.creatingButton("Sort By Wins", 650, 620, 50, 250);


        TableColumn<SportsClub, String> columnCLubName = new TableColumn<>("Club Name");
        columnCLubName.setPrefWidth(300);
        TableColumn<FootballClub, Integer> columnPlayed = new TableColumn<>("Played");
        columnPlayed.setStyle("-fx-alignment: center;");
        TableColumn<FootballClub, Integer> columnWon = new TableColumn<>("Won");
        columnWon.setStyle("-fx-alignment: center;");
        TableColumn<FootballClub, Integer> columnDefeat = new TableColumn<>("Defeat");
        columnDefeat.setStyle("-fx-alignment: center;");
        TableColumn<FootballClub, Integer> columnDraw = new TableColumn<>("Drawn");
        columnDraw.setStyle("-fx-alignment: center;");
        TableColumn<FootballClub, Integer> columnScoredGoals = new TableColumn<>("Scored");
        columnScoredGoals.setStyle("-fx-alignment: center;");
        TableColumn<FootballClub, Integer> columnReceivedGoals = new TableColumn<>("Received");
        columnReceivedGoals.setStyle("-fx-alignment: center;");
        TableColumn<FootballClub, Integer> columnGoalDifference = new TableColumn<>("GF");
        columnGoalDifference.setStyle("-fx-alignment: center;");
        TableColumn<FootballClub, Integer> columnWiningPercentage = new TableColumn<>("WP");
        columnWiningPercentage.setStyle("-fx-alignment: center;");
        columnWiningPercentage.setPrefWidth(65);
        TableColumn<FootballClub, Integer> columnPoints = new TableColumn<>("Points");
        columnPoints.setStyle("-fx-alignment: center;");

        columnCLubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        columnPlayed.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));
        columnWon.setCellValueFactory(new PropertyValueFactory<>("winCount"));
        columnDefeat.setCellValueFactory(new PropertyValueFactory<>("defeatCount"));
        columnDraw.setCellValueFactory(new PropertyValueFactory<>("drawCount"));
        columnScoredGoals.setCellValueFactory(new PropertyValueFactory<>("scoredGoalsCount"));
        columnReceivedGoals.setCellValueFactory(new PropertyValueFactory<>("receivedGoalsCount"));
        columnGoalDifference.setCellValueFactory(new PropertyValueFactory<>("goalDifferenceCount"));
        columnWiningPercentage.setCellValueFactory(new PropertyValueFactory<>("winingPercentage"));
        columnPoints.setCellValueFactory(new PropertyValueFactory<>("points"));

        clubTable.getColumns().addAll(columnCLubName, columnPlayed, columnWon, columnDefeat, columnDraw, columnScoredGoals,
                columnReceivedGoals, columnGoalDifference, columnWiningPercentage, columnPoints);

        sortClubTableByPoints();

        Pane clubTablePane = new Pane();
        clubTablePane.getChildren().add(clubTableBG);
        clubTablePane.getChildren().add(lblBg);
        clubTablePane.getChildren().add(clubTable);
        clubTablePane.getChildren().add(btnSortByScoredGoalsCount);
        clubTablePane.getChildren().add(btnSortByPoints);
        clubTablePane.getChildren().add(btnSortByWinCount);
        clubTablePane.getChildren().add(btnBack);
        clubTablePane.getChildren().add(leagueLogo);

        btnSortByScoredGoalsCount.setOnAction(e -> {
            CustomComparator customComparator = new CustomComparator();
            Collections.sort(footballClubsList, customComparator.sortByScoredGoalsCount);
            ObservableList<FootballClub> clubsObservableList = FXCollections.observableArrayList();
            for (FootballClub footballClub : footballClubsList) {
                clubsObservableList.add(footballClub);
            }
            clubTable.setItems(clubsObservableList);
        });
        btnSortByPoints.setOnAction(e -> {
            sortClubTableByPoints();
        });
        btnSortByWinCount.setOnAction(e -> {
            CustomComparator customComparator = new CustomComparator();
            Collections.sort(footballClubsList, customComparator.sortByWinCount);
            ObservableList<FootballClub> clubsObservableList = FXCollections.observableArrayList();
            for (FootballClub footballClub : footballClubsList) {
                clubsObservableList.add(footballClub);
            }
            clubTable.setItems(clubsObservableList);
        });
        btnBack.setOnAction(e -> {
            clubTableStage.close();
            guiWindow();

        });

        clubTableStage.setScene(new Scene(clubTablePane, 1000, 800));
        clubTableStage.show();

    }


    public void guiMatchesTableWindow() {
        loadingData();
        Stage matchesTableStage = new Stage();
        matchesTableStage.setTitle("Matches Summary");


        //adding image to background
        Image image3 = new Image("PICS/MatchesTableWindow/matches table BG.jpg");
        ImageView matchesTableBG = new ImageView();
        matchesTableBG.setImage(image3);
        matchesTableBG.setFitWidth(1500);
        matchesTableBG.setFitHeight(800);

        Button btnRandomMatch = guiComponents.creatingButton("Random Match", 50, 500, 50, 250);
        Button btnSearchByDate = guiComponents.creatingButton("Search By Date", 50, 580, 50, 250);
        txtFieldSearch = guiComponents.creatingTextField("DD/MM/YYYY", 300, 580, 50, 250);
        lblTeams = GUIComponents.creatingLabel("Home Team VS Away Team", 600, 580, 50, 380);
        lblTeams.setStyle("-fx-background-color:transparent;-fx-text-fill:#f5f7f7;-fx-font-size:1.2em;-fx-font-weight: Bold;-fx-border-color:#38003c;-fx-border-width:2;-fx-alignment: center;");
        lblHomeGoals = GUIComponents.creatingLabel(" Home Goals", 600, 640, 50, 380);
        lblAwayGoals = GUIComponents.creatingLabel(" Away Goals", 600, 700, 50, 380);


        matchesTable = guiComponents.creatingTable(100, 50, 900, 400);

        TableColumn<FootballMatch, FootballClub> columnHomeTeam = new TableColumn<>("Home Team");
        columnHomeTeam.setPrefWidth(200);
        TableColumn<FootballMatch, FootballClub> columnAwayTeam = new TableColumn<>("Away Team");
        columnAwayTeam.setPrefWidth(200);
        TableColumn<FootballMatch, FootballClub> columnHomeGoals = new TableColumn<>("Home Goals");
        columnHomeGoals.setPrefWidth(100);
        columnHomeGoals.setStyle("-fx-alignment: center;");
        TableColumn<FootballMatch, FootballClub> columnAwayGoals = new TableColumn<>("Away Goals");
        columnAwayGoals.setPrefWidth(100);
        columnAwayGoals.setStyle("-fx-alignment: center;");
        TableColumn<FootballMatch, FootballClub> columnMatchDate = new TableColumn<>("Match Date");
        columnMatchDate.setPrefWidth(300);
        columnMatchDate.setStyle("-fx-alignment: center;");

        columnHomeTeam.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));
        columnAwayTeam.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));
        columnHomeGoals.setCellValueFactory(new PropertyValueFactory<>("homeGoals"));
        columnAwayGoals.setCellValueFactory(new PropertyValueFactory<>("awayGoals"));
        columnMatchDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        matchesTable.getColumns().addAll(columnHomeTeam, columnHomeGoals, columnAwayTeam, columnAwayGoals, columnMatchDate);


        Pane matchesTablePane = new Pane();
        matchesTablePane.getChildren().add(matchesTableBG);
        matchesTablePane.getChildren().add(lblBg);
        matchesTablePane.getChildren().add(matchesTable);
        matchesTablePane.getChildren().add(leagueLogo);
        matchesTablePane.getChildren().add(btnRandomMatch);
        matchesTablePane.getChildren().add(txtFieldSearch);
        matchesTablePane.getChildren().add(lblTeams);
        matchesTablePane.getChildren().add(lblHomeGoals);
        matchesTablePane.getChildren().add(lblAwayGoals);
        matchesTablePane.getChildren().add(btnSearchByDate);
        matchesTablePane.getChildren().add(btnBack);

        refreshMatchTable();


        btnBack.setOnAction(e -> {
            matchesTableStage.close();
            guiWindow();
        });
        btnRandomMatch.setOnAction(e -> {
            try {
                randomPlayedMatch();
                refreshMatchTable();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btnSearchByDate.setOnAction(e -> {
            searchingByDate();
        });

        matchesTableStage.setScene(new Scene(matchesTablePane, 1000, 800));
        matchesTableStage.show();

    }


    public void randomPlayedMatch() throws IOException {
        if (footballClubsList.size() > 0) {
            loadingData();
            Random random = new Random();
            int randomIndex1 = random.nextInt(footballClubsList.size());
            int randomIndex2 = random.nextInt(footballClubsList.size());
            while (randomIndex1 == randomIndex2) {
                randomIndex2 = random.nextInt(footballClubsList.size());
            }
            FootballClub homeTeam = footballClubsList.get(randomIndex1);
            FootballClub awayTeam = footballClubsList.get(randomIndex2);
            int homeGoals = random.nextInt(37);
            int awayGoals = random.nextInt(37);
            FootballMatch randomMatch = new FootballMatch();
            int randomMonth = random.nextInt(13);
            while (randomMonth == 0) {
                randomMonth = random.nextInt(13);
            }
            int randomDay = random.nextInt(31);
            while (randomDay == 0) {
                randomDay = random.nextInt(31);
                if (randomMonth == 2) {
                    randomDay = random.nextInt(29);
                }
            }
            randomMatch.setDate(new Date(randomDay, randomMonth, 2020));
            randomMatch.setHomeTeam(homeTeam);
            randomMatch.setAwayTeam(awayTeam);
            randomMatch.setHomeGoals(homeGoals);
            randomMatch.setAwayGoals(awayGoals);
            footballMatchList.add(randomMatch);

            homeTeam.setScoredGoalsCount(homeTeam.getScoredGoalsCount() + homeGoals);
            awayTeam.setScoredGoalsCount(awayTeam.getScoredGoalsCount() + awayGoals);
            homeTeam.setReceivedGoalsCount(homeTeam.getReceivedGoalsCount() + awayGoals);
            awayTeam.setReceivedGoalsCount(awayTeam.getReceivedGoalsCount() + homeGoals);
            homeTeam.setMatchesPlayed(homeTeam.getMatchesPlayed() + 1);
            awayTeam.setMatchesPlayed(awayTeam.getMatchesPlayed() + 1);
            String wonTeam;
            if (homeGoals > awayGoals) {
                homeTeam.setPoints(homeTeam.getPoints() + 3);
                homeTeam.setWinCount(homeTeam.getWinCount() + 1);
                awayTeam.setDefeatCount(awayTeam.getDefeatCount() + 1);
                wonTeam = homeTeam.getClubName();
            } else if (homeGoals < awayGoals) {
                awayTeam.setPoints(awayTeam.getPoints() + 3);
                awayTeam.setWinCount(awayTeam.getWinCount() + 1);
                homeTeam.setDefeatCount(homeTeam.getDefeatCount() + 1);
                wonTeam = homeTeam.getClubName();
            } else {
                homeTeam.setPoints(homeTeam.getPoints() + 1);
                awayTeam.setPoints(awayTeam.getPoints() + 1);
                homeTeam.setDrawCount(homeTeam.getDrawCount() + 1);
                awayTeam.setDrawCount(awayTeam.getDrawCount() + 1);
                wonTeam = "Drawn";
            }

            homeTeam.setWiningPercentage((homeTeam.getWinCount() * 100) / homeTeam.getMatchesPlayed());
            awayTeam.setWiningPercentage((awayTeam.getWinCount() * 100) / awayTeam.getMatchesPlayed());
            guiComponents.informationAlert("Random Match Played : " + homeTeam + " VS " + awayTeam + "\nWon By " + wonTeam);

            saveMatchesInFile((ArrayList) footballMatchList);
            saveClubsInFile((ArrayList) footballClubsList);

        } else {
            guiComponents.errorAlert("There Should be two or more Clubs to Play a Random Match");
        }

    }

    public void searchingByDate() {
        Date searchingDate = new Date();
        boolean dateOfPlayedMatch = false;
        String matchDate = txtFieldSearch.getText();
        if (txtFieldSearch.getText().equals("")) {
            guiComponents.errorAlert("Please Enter Match date in Text Field");
            txtFieldSearch.clear();
        } else {
            if (matchDate.length() == 10) {
                try {
                    searchingDate.setYear(matchDate);
                    searchingDate.setMonth(matchDate);
                    searchingDate.setDay(matchDate);
                    int day = Integer.parseInt(matchDate.substring(0, 2));
                    int month = Integer.parseInt(matchDate.substring(3, 5));
                    int year = Integer.parseInt(matchDate.substring(6, 10));
                    Date date = new Date(day, month, year);
                    for (FootballMatch footballMatch : footballMatchList) {
                        if (date.equals(footballMatch.getDate())) {
                            System.out.println(footballMatch);
                            dateOfPlayedMatch = true;
                            lblTeams.setText(footballMatch.getHomeTeam() + " VS " + footballMatch.getAwayTeam());
                            lblHomeGoals.setText(footballMatch.getHomeTeam() + " Goals : " + footballMatch.getHomeGoals());
                            lblAwayGoals.setText(footballMatch.getAwayTeam() + " Goals : " + footballMatch.getAwayGoals());
                            guiComponents.informationAlert(lblTeams.getText() + "\n" + lblHomeGoals.getText() + "\n" + lblAwayGoals.getText());
                        }
                    }
                    if (!dateOfPlayedMatch) {
                        guiComponents.errorAlert("There was No Played Matches in " + matchDate);
                    }
                } catch (InvalidDayException invalidDay) {
                    guiComponents.errorAlert("Please Enter Valid Day - (DD/MM/YYYY)");


                } catch (InvalidMonthException invalidMonth) {
                    guiComponents.errorAlert("Please Enter Valid Month - (DD/MM/YYYY)");


                } catch (NumberFormatException dateWithLettersError) {
                    guiComponents.errorAlert("Please Enter Valid Date Without Letters - (DD/MM/YYYY)");

                } finally {
                    txtFieldSearch.clear();
                }

            } else {
                guiComponents.errorAlert("Please Enter Valid Date - (DD/MM/YYYY)");
                txtFieldSearch.clear();
            }
        }


    }

    public void sortClubTableByPoints() {
        Collections.sort(footballClubsList);
        ObservableList<FootballClub> clubsObservableList = FXCollections.observableArrayList();
        for (FootballClub footballClub : footballClubsList) {
            clubsObservableList.add(footballClub);
        }
        clubTable.setItems(clubsObservableList);
    }

    public void refreshMatchTable() {
        ObservableList<FootballMatch> matchesObservableList = FXCollections.observableArrayList();
        for (FootballMatch footballMatch : footballMatchList) {
            matchesObservableList.add(footballMatch);
        }
        matchesTable.setItems(matchesObservableList);
    }


    public void loadingData() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileFootballClubs);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            footballClubsList = (ArrayList<FootballClub>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
        }
        try {
            FileInputStream fileInputStream1 = new FileInputStream(fileFootballMatches);
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
            footballMatchList = (ArrayList<FootballMatch>) objectInputStream1.readObject();
            objectInputStream1.close();
        } catch (Exception e) {
        }
    }

    public void saveClubsInFile(ArrayList footballClubs) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(fileFootballClubs);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try {
            objectOutputStream.writeObject(footballClubs);

        } catch (FileNotFoundException fileNotFoundException) {

        } finally {
            objectOutputStream.close();
        }
    }
    public void saveMatchesInFile(ArrayList footballMatches) throws IOException {
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileFootballMatches);
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
        try {
            objectOutputStream1.writeObject(footballMatches);
        } catch (FileNotFoundException fileNotFoundException) {

        } finally {
            objectOutputStream1.close();
        }
    }
}
