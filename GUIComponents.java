
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.awt.*;


public class GUIComponents {
    //method for creating buttons
    public javafx.scene.control.Button creatingButton(String txtOnBtn, int x, int y, int prefHeight, int prefWidth) {
        javafx.scene.control.Button btn = new Button(txtOnBtn);
        btn.setLayoutX(x);
        btn.setLayoutY(y);
        btn.setPrefHeight(prefHeight);
        btn.setPrefWidth(prefWidth);
        btn.setStyle("-fx-background-color:Transparent;-fx-border-color:#38003c;-fx-text-fill:#f5f7f7;-fx-font-size:2em;-fx-border-radius:20;-fx-border-width:4;");
        return btn;
    }

    //creating label for get dark appearance in all windows
    public static Label creatingLabelForBackground() {
        Label lblBG = new Label();
        lblBG.setLayoutX(0);
        lblBG.setLayoutY(0);
        lblBG.setPrefHeight(800);
        lblBG.setPrefWidth(1000);
        lblBG.setStyle("-fx-background-color: #000000;");
        lblBG.setOpacity(0.79);
        return lblBG;
    }

    public TableView creatingTable(int x, int y, int prefWidth, int prefHeight) {
        TableView tableView = new TableView();
        tableView.setPrefSize(prefWidth, prefHeight);
        tableView.setLayoutY(x);
        tableView.setLayoutX(y);
        tableView.setOpacity(.6);
        tableView.setStyle("-fx-background-color:Transparent;-fx-border-color:#38003c;-fx-text-fill:#f5f7f7;-fx-border-radius:20;-fx-border-width:2;-fx-base: #38003c;");
        return tableView;

    }

    //method for create back button, back button appears in most of the windows and this will avoid code duplication
    public static Button createBtnBack() {
        javafx.scene.image.Image imageBack = new javafx.scene.image.Image("PICS/back.png");
        ImageView backPng = new ImageView();
        backPng.setImage(imageBack);
        backPng.setFitWidth(30);
        backPng.setFitHeight(30);

        Button btnBack = new Button();
        btnBack.setLayoutX(0);
        btnBack.setLayoutY(0);
        btnBack.setPrefHeight(20);
        btnBack.setPrefWidth(30);
        btnBack.setGraphic(backPng);
        btnBack.setStyle("-fx-background-color:transparent; -fx-background-radius:100;");
        return btnBack;
    }

    public static ImageView leagueLogo() {
        javafx.scene.image.Image imageLogo = new javafx.scene.image.Image("PICS/leagueLogo.png");
        ImageView logo = new ImageView();
        logo.setImage(imageLogo);
        logo.setFitWidth(100);
        logo.setFitHeight(100);
        logo.setLayoutX(900);
        logo.setLayoutY(20);
        return logo;
    }

    //method for error alert and this will pop up with a sound
    public Alert errorAlert(String message) {
        Toolkit.getDefaultToolkit().beep();
        Alert errorAlert = new Alert(Alert.AlertType.NONE);
        errorAlert.setAlertType(Alert.AlertType.ERROR);
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
        return errorAlert;
    }

    public Alert informationAlert(String message) {
        Alert infoAlert = new Alert(Alert.AlertType.NONE);
        infoAlert.setAlertType(Alert.AlertType.INFORMATION);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
        return infoAlert;
    }
    //method for creating text fields
    public  javafx.scene.control.TextField creatingTextField(String promptTxt, int x, int y, int prefHeight, int PrefWidth) {
        javafx.scene.control.TextField txtField = new TextField();
        txtField.setPromptText(promptTxt);
        txtField.setLayoutX(x);
        txtField.setLayoutY(y);
        txtField.setPrefWidth(PrefWidth);
        txtField.setPrefHeight(prefHeight);
        txtField.setStyle("-fx-background-color:transparent; -fx-border-color:#66CDAA;-fx-text-fill:#f5f7f7;-fx-font-size:2em;-fx-border-radius:10;");
        return txtField;
    }
    //method for creating labels
    public static javafx.scene.control.Label creatingLabel(String txtOnLbl, int x, int y, int prefHeight, int PrefWidth) {
        javafx.scene.control.Label lbl = new Label(txtOnLbl);
        lbl.setLayoutX(x);
        lbl.setLayoutY(y);
        lbl.setPrefHeight(prefHeight);
        lbl.setPrefWidth(PrefWidth);
        lbl.setStyle("-fx-text-fill:#ffffff");
        lbl.setStyle("-fx-background-color:transparent;-fx-text-fill:#f5f7f7;-fx-font-size:1.2em;-fx-font-weight: Bold;-fx-border-color:#38003c;-fx-border-width:2;");
        return lbl;

    }


}
