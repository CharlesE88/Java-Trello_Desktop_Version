package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.animations.AnimShaker;
import sample.database.DatabaseHandler;
import sample.model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import static javafx.application.Application.setUserAgentStylesheet;

public class LoginController {

    Main main = new Main();

    private int userID;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField loginUsername;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXButton loginSignupButton;

    private DatabaseHandler databaseHandler;


    @FXML
    void initialize(){

        databaseHandler = new DatabaseHandler();



        loginButton.setOnAction(event -> {

            String loginText = loginUsername.getText().trim();
            String loginpwd = loginPassword.getText().trim();

            User user = new User();
            user.setUserName(loginText);
            user.setPassword(loginpwd);

            ResultSet userRow = databaseHandler.getUser(user);

            int counter = 0;
            try{
                while(userRow.next()){
                    counter++;
                    userID = userRow.getInt("userid");
                }
                if(counter == 1){
                    showAddItemScreen();
                } else {
                    AnimShaker userNameAnimShaker = new AnimShaker(loginUsername);
                    AnimShaker passwordAnimShaker = new AnimShaker(loginUsername);
                    passwordAnimShaker.animShake();
                    userNameAnimShaker.animShake();
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        });

        loginSignupButton.setOnAction(event -> {
            //Take users to signup screen
            loginSignupButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/signup.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });

    }

    private void showAddItemScreen(){
        //Take users to AddItem screen
        loginSignupButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/addItem.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        AddItemController addItemController = loader.getController();
        addItemController.setUserID(userID);

        stage.showAndWait();
    }

}
