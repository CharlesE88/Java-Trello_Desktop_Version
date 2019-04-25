package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import sample.model.Task;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton listSaveTaskButton;

    @FXML
    private JFXTextField listTaskTextField;

    @FXML
    private JFXTextField listDescriptionTextField;

    @FXML
    private JFXListView<Task> taskListView;

    private ObservableList<Task> tasks;

    private DatabaseHandler databaseHandler;

    @FXML
    void initialize() throws SQLException {

        tasks = FXCollections.observableArrayList();

        databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getTaskByUser(AddItemController.userID);
        while (resultSet.next()){

            Task task = new Task();
            task.setTaskID(resultSet.getInt("taskid"));
            task.setTask(resultSet.getString("task"));
            task.setDateCreated(resultSet.getTimestamp("datecreated"));
            task.setDescription(resultSet.getString("description"));

            tasks.add(task);
        }

        taskListView.setItems(tasks);
        taskListView.setCellFactory(CellController -> new CellController());

        listSaveTaskButton.setOnAction(event -> {
            addNewTask();
        });
    }

    public void addNewTask(){
        databaseHandler = new DatabaseHandler();
        CellController cellController = new CellController();


            Calendar calendar = Calendar.getInstance();

            java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTimeInMillis());

            String listTaskText = listTaskTextField.getText().trim();
            String listTaskDescription = listDescriptionTextField.getText().trim();

            if(!listTaskTextField.getText().equals("") || !listDescriptionTextField.getText().equals("")) {
                Task newTask = new Task();

                newTask.setUserID(AddItemController.userID);
                newTask.setDateCreated(timestamp);
                newTask.setDescription(listTaskDescription);
                newTask.setTask(listTaskText);

                databaseHandler.insertTask(newTask);
                listTaskTextField.setText("");
                listDescriptionTextField.setText("");


                try {
                    initialize();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }

}
