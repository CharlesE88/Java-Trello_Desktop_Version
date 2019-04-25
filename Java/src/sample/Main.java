package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.AddItemController;
import sample.controller.AddItemFormController;
import sample.database.DatabaseHandler;

import java.sql.ResultSet;

public class Main extends Application {

    Stage window;

    //public String stylesheet = getClass().getResource("view/stylesheet.css").toExternalForm();

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Task Manager App");

        //Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("view/homeScreen.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();

        //DatabaseHandler databaseHandler = new DatabaseHandler();
        //ResultSet resultSet = databaseHandler.getTaskByUser(14);
        //while (resultSet.next()){
            //System.out.println("User tasks: " + resultSet.getString("task"));
        //}
        //System.out.println("Current Tasks: " + databaseHandler.getAllTasks(AddItemController.userID));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
