package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import sample.model.Task;

public class AddItemFormController {

    //private int userID;
    private int taskNumber = 0;
    private DatabaseHandler databaseHandler;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXButton saveTaskButton;

    @FXML
    private JFXButton moveToCellPage;

    @FXML
    private JFXTextField taskTextField;

    @FXML
    private JFXTextField descriptionTextField;


    @FXML
    void initialize() {

        Image save = new Image(getClass().getResourceAsStream("/sample/assets/Add.png"));
        JFXButton saveBtn = new JFXButton("", new ImageView(save));


        //BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("/sample/assets/Add.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //Background background = new Background(backgroundImage);

        //saveTaskButton.setBackground(background);

        databaseHandler = new DatabaseHandler();
        saveTaskButton.setOnAction(event -> {

            Task task = new Task();

            Calendar calendar = Calendar.getInstance();

            java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTimeInMillis());

            String taskText = taskTextField.getText().trim();
            String taskDescription = descriptionTextField.getText().trim();

            if(!taskText.equals("") || !taskDescription.equals("")){

                task.setUserID(AddItemController.userID);
                task.setDateCreated(timestamp);
                task.setDescription(taskDescription);
                task.setTask(taskText);

                databaseHandler.insertTask(task);

                try {
                    taskNumber = databaseHandler.getAllTasks(AddItemController.userID);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                System.out.println("Task Amount: " + taskNumber);
                taskTextField.setText("");
                descriptionTextField.setText("");

                //moveToCellPage.setOnAction(event1 -> {
                //    FXMLLoader loader = new FXMLLoader();
                //    loader.setLocation(getClass().getResource("/sample/view/list.fxml"));
//
                //    try {
                //        loader.load();
                //    } catch (IOException e) {
                //        e.printStackTrace();
                //    }
//
                //    Parent root = loader.getRoot();
                //    Stage stage = new Stage();
                //    stage.setScene(new Scene(root));
                //    stage.showAndWait();
                //});

            } else {
                System.out.println("Please enter a task and task description");
            }

        });
        moveToCellPage.setOnAction(event1 -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/list.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        rootPane.getChildren().addAll(saveBtn);
    }
    //public int getUserID() {
        //return userID;
    //}

    //public void setUserID(int userID) {
        //this.userID = userID;
        //System.out.println(this.userID);
    //}
}
