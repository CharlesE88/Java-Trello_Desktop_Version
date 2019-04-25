package sample.controller;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXToggleNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import sample.model.Task;



public class CellController extends JFXListCell<Task> {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label cellTaskLabel;

    @FXML
    private Label cellDescriptionLabel;

    @FXML
    private AnchorPane cellTaskAnchor;

    @FXML
    private ImageView cellTaskIcon;

    @FXML
    private ImageView cellDeleteIcon;

    @FXML
    private Label cellDateCreatedLabel;

    @FXML
    private Button imageButton;

    private FXMLLoader fxmlLoader;

    private DatabaseHandler databaseHandler;

    private Task myTask = new Task();

    @FXML
    void initialize() {
        //Task myTask = new Task();

        BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("/sample/assets/icon_close.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        imageButton.setBackground(background);
    }


    @Override
    protected void updateItem(Task myTask, boolean empty) {
        super.updateItem(myTask, empty);

        if(empty || myTask == null){
            setText(null);
            setGraphic(null);
        }else{
            if(fxmlLoader == null){
                fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/cell.fxml"));
                fxmlLoader.setController(this); //This is the same thing as setting the controller in the fxml file
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            cellTaskLabel.setText(myTask.getTask());
            cellDateCreatedLabel.setText(myTask.getDateCreated().toString());
            cellDescriptionLabel.setText(myTask.getDescription());

            int taskID = myTask.getTaskID();

            cellDeleteIcon.setOnMouseClicked(event -> {
                databaseHandler = new DatabaseHandler();
                try {
                    databaseHandler.deleteTask(AddItemController.userID, taskID);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                getListView().getItems().remove(getItem());

            });

            setText(null);
            setGraphic(cellTaskAnchor);
        }
    }
}
