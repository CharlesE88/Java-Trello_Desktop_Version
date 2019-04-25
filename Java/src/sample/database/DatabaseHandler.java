package sample.database;

import sample.controller.AddItemController;
import sample.controller.AddItemFormController;
import sample.controller.LoginController;
import sample.model.Task;
import sample.model.User;

import java.sql.*;

public class DatabaseHandler extends Configs {



    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        //String url="jdbc:mysql://localhost:3306/todoapp";
        //String dbUser="root";
        //String dbPass="TestingTestingTesting123";

        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/"
                + dbName;

        //Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    //Write
    public void signUpUser(User user){

        String insert = "INSERT INTO "+ Const.USERS_TABLE +"("+Const.USERS_FIRSTNAME +","+Const.USERS_LASTNAME +","+Const.USERS_USERNAME +","
                +Const.USERS_PASSWORD +","+Const.USERS_LOCATION +","+Const.USERS_GENDER+")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getLocation());
            preparedStatement.setString(6, user.getGender());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getTaskByUser(int userID){
        ResultSet resultTasks = null;

        String query = "SELECT * FROM " + Const.TASKS_TABLE + " WHERE "
                + Const.USERS_ID + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userID);

            resultTasks = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return resultTasks;
    }

    public ResultSet getUser(User user){
        ResultSet resultSet = null;
        if(!user.getUserName().equals("") || !user.getPassword().equals("")){
            String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE "
                    + Const.USERS_USERNAME + "=?" +  " AND " + Const.USERS_PASSWORD
                    + "=?";

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());

                resultSet = preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Please enter credentials");
        }

        return resultSet;
    }

    public int getAllTasks(int userID) throws SQLException, ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM " + Const.TASKS_TABLE + " WHERE " + Const.USERS_ID + "=?";


            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userID);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt(1);
            }
         return resultSet.getInt(1);
    }

    public void insertTask(Task task){
        AddItemController addItemController = new AddItemController();
        String insert = "INSERT INTO "+ Const.TASKS_TABLE +"("+Const.USERS_ID +","+Const.TASKS_DATE +","+Const.TASKS_DESCRIPTION +","+Const.TASKS_TASK + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setInt(1, task.getUserID());
            preparedStatement.setTimestamp(2, task.getDateCreated());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setString(4, task.getTask());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //Read

    //Update

    //Delete
    public void deleteTask(int userID, int taskID) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM " + Const.TASKS_TABLE + " WHERE " + Const.USERS_ID + "=?" + " AND " + Const.TASKS_ID + "=?";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setInt(1, userID);
        preparedStatement.setInt(2, taskID);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
