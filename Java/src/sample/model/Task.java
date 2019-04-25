package sample.model;

import javafx.scene.control.Button;

import java.sql.Timestamp;

public class Task {

    private int userID;
    private int taskID;
    private Timestamp dateCreated;
    private String description;
    private String task;


    public Task() {

    }

    public Task(int userID, Timestamp dateCreated, String description, String task) {
        this.userID = userID;
        this.taskID = taskID;
        this.dateCreated = dateCreated;
        this.description = description;
        this.task = task;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getUserID() { return userID; }

    public void setUserID(int userID) { this.userID = userID; }

    public int getTaskID() { return taskID; }

    public void setTaskID(int taskID) { this.taskID = taskID; }
}
