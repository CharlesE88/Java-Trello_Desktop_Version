package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddItemController {

    //private int userID;

    public static int userID;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label emptyTaskLabel;

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private ImageView addButton;

    @FXML
    void initialize(){
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            try {
                AnchorPane formPane = FXMLLoader.load(getClass().getResource("/sample/view/addItemForm.fxml"));

                AddItemController.userID = getUserID();

                //AddItemFormController addItemFormController = new AddItemFormController();
                //addItemFormController.setUserID(getUserID());

                rootAnchorPane.getChildren().setAll(formPane);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
    public int getUserID(){
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
        System.out.println(this.userID);
    }
}
