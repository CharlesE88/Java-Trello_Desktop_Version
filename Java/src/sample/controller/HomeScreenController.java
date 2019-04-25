package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class HomeScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane homeScreenRightAnchor1;

    @FXML
    private JFXListView<?> homeScreenBoardsListView;

    @FXML
    private JFXButton homeScreenLeftAnchorBoardsBtn;

    @FXML
    private JFXButton homeScreenRightAnchorAddBtn;

    @FXML
    private JFXListView<?> homeScreenAddListView;

    @FXML
    private JFXButton homeScreenRightAnchorAvatarBtn;

    @FXML
    private JFXListView<String> homeScreenAvatarListView;

    @FXML
    private JFXButton homeScreenAnchorLogoBtn;

    @FXML
    private AnchorPane homeScreenRightAnchor;

    @FXML
    private JFXButton homeScreenRightAnchorHelpBtn;

    @FXML
    private JFXListView<?> homeScreenHelpListView;

    @FXML
    private JFXButton homeScreenHomeLeftAnchorBtn;

    @FXML
    private JFXButton homeScreenRightAnchorNotificationBtn;

    @FXML
    private JFXListView<?> homeScreenNotificationListView;

    @FXML
    private AnchorPane homeScreenRootAnchor;

    public boolean isBoardsLVDisplayed = false;
    public boolean isAvatarLVDisplayed = false;
    public boolean isHelpLVDisplayed = false;
    public boolean isAddLVDisplayed = false;
    public boolean isNotificationLVDisplayed = false;

    Stage window;

    @FXML
    void initialize() {
        //CALL THE showHomeScreenBoardsListView() METHOD
        showHomeScreenBoardsListView();

        //CALL THE showHomeScreenAvatarListView() METHOD
        showHomeScreenAvatarListView();

        //CALL THE showHomeScreenHelpListView() METHOD
        showHomeScreenHelpListView();

        //CALL THE showHomeScreenNotificationListView() METHOD
        showHomeScreenNotificationListView();

        //CALL THE showHomeScreenAddListView() METHOD
        showHomeScreenAddListView();

        //ON LOGO BUTTON CLICK
        homeScreenAnchorLogoBtn.setOnAction(event -> {

                returnToHomeScreenLogoBtnPressed();
        });
        //ON HOME BUTTON CLICK
        homeScreenHomeLeftAnchorBtn.setOnAction(event -> {

                returnToHomeScreenHomeBtnPressed();
        });
        /*ON PROFILE BUTTON CLICK
        homeScreenRightAnchorAvatarBtn.setOnAction(event -> {

                goToUserAccountScreen();
        });
        */
    }

    public void goToUserAccountScreen(){

        homeScreenRightAnchorAvatarBtn.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/login.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.show();

    }

    public void  returnToHomeScreenHomeBtnPressed(){

        homeScreenAnchorLogoBtn.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/homeScreen.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.show();

        //return homeScreenRootAnchor;
    }

    public void  returnToHomeScreenLogoBtnPressed(){

        homeScreenAnchorLogoBtn.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/homeScreen.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.show();

        //return homeScreenRootAnchor;
    }

    public void showHomeScreenBoardsListView(){
        //SET THE BOARDS LIST VIEW VISIBILITY TO FALSE;
        homeScreenBoardsListView.setVisible(isBoardsLVDisplayed);

        //MOUSE CLICKED EVENT LISTENER FOR THE BOARDS BUTTON
        homeScreenLeftAnchorBoardsBtn.setOnMouseClicked(event -> {

            //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS FALSE
            if(!homeScreenBoardsListView.isVisible()) {

                //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO TRUE
                homeScreenBoardsListView.setVisible(true);
                homeScreenNotificationListView.setVisible(false);
                homeScreenHelpListView.setVisible(false);
                homeScreenAddListView.setVisible(false);
                homeScreenAvatarListView.setVisible(false);

             //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS TRUE
            }else if (homeScreenBoardsListView.isVisible()) {

                //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO FALSE
                homeScreenBoardsListView.setVisible(false);
            }
        });
    }

    public void showHomeScreenAvatarListView(){
        //SET THE BOARDS LIST VIEW VISIBILITY TO FALSE;
        homeScreenAvatarListView.setVisible(isAvatarLVDisplayed);

        //MOUSE CLICKED EVENT LISTENER FOR THE BOARDS BUTTON
        homeScreenRightAnchorAvatarBtn.setOnMouseClicked(event -> {

            //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS FALSE
            if(!homeScreenAvatarListView.isVisible()) {

                //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO TRUE
                homeScreenAvatarListView.setVisible(true);
                homeScreenNotificationListView.setVisible(false);
                homeScreenHelpListView.setVisible(false);
                homeScreenAddListView.setVisible(false);
                homeScreenBoardsListView.setVisible(false);

                //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS TRUE
            }else if (homeScreenAvatarListView.isVisible()) {

                //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO FALSE
                homeScreenAvatarListView.setVisible(false);
            }
        });
    }

    public void showHomeScreenAddListView(){
        //SET THE BOARDS LIST VIEW VISIBILITY TO FALSE;
        homeScreenAddListView.setVisible(isAddLVDisplayed);

        //MOUSE CLICKED EVENT LISTENER FOR THE BOARDS BUTTON
        homeScreenRightAnchorAddBtn.setOnMouseClicked(event -> {

            //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS FALSE
            if(!homeScreenAddListView.isVisible()) {

                //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO TRUE
                homeScreenAddListView.setVisible(true);
                homeScreenNotificationListView.setVisible(false);
                homeScreenHelpListView.setVisible(false);
                homeScreenAvatarListView.setVisible(false);
                homeScreenBoardsListView.setVisible(false);

                //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS TRUE
            }else if (homeScreenAddListView.isVisible()) {

                //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO FALSE
                homeScreenAddListView.setVisible(false);
            }
        });
    }

    public void showHomeScreenHelpListView(){
        //SET THE BOARDS LIST VIEW VISIBILITY TO FALSE;
        homeScreenHelpListView.setVisible(isHelpLVDisplayed);

        //MOUSE CLICKED EVENT LISTENER FOR THE BOARDS BUTTON
        homeScreenRightAnchorHelpBtn.setOnMouseClicked(event -> {

            //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS FALSE
            if(!homeScreenHelpListView.isVisible()) {

                //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO TRUE
                homeScreenHelpListView.setVisible(true);
                homeScreenNotificationListView.setVisible(false);
                homeScreenAddListView.setVisible(false);
                homeScreenAvatarListView.setVisible(false);
                homeScreenBoardsListView.setVisible(false);

                //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS TRUE
            }else if (homeScreenHelpListView.isVisible()) {

                //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO FALSE
                homeScreenHelpListView.setVisible(false);
            }
        });
    }

    public void showHomeScreenNotificationListView(){
        //SET THE BOARDS LIST VIEW VISIBILITY TO FALSE;
        homeScreenNotificationListView.setVisible(isNotificationLVDisplayed);
        //GET THE OTHER LIST VIEW VISIBILITY PROPERTY
        //MOUSE CLICKED EVENT LISTENER FOR THE BOARDS BUTTON
        homeScreenRightAnchorNotificationBtn.setOnMouseClicked(event -> {

                //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS FALSE
                if (!homeScreenNotificationListView.isVisible()) {

                    //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO TRUE
                    homeScreenNotificationListView.setVisible(true);
                    homeScreenHelpListView.setVisible(false);
                    homeScreenAddListView.setVisible(false);
                    homeScreenAvatarListView.setVisible(false);
                    homeScreenBoardsListView.setVisible(false);

                    //CHECK TO SEE IF THE BOARDS LIST VIEW VISIBILITY IS TRUE
                } else if (homeScreenNotificationListView.isVisible()) {

                    //SET THE VISIBILITY OF THE BOARDS LIST VIEW TO FALSE
                    homeScreenNotificationListView.setVisible(false);
                }

        });
    }

}
