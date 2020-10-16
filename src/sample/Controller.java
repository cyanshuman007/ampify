package sample;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller
{
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    public Button SignIn;
    @FXML
    public Button SignUp;
    @FXML
    public Button logout;
    @FXML
    public Button play;
    @FXML
    public Button pause;
    @FXML
    public Button previous;
    @FXML
    public Button stop;
    @FXML
    public Button next;
    @FXML
    public Button equalizer;
    @FXML
    public Button repeat;
    @FXML
    public Button shuffle;

    public void login() throws IOException {
        String Username = username.getText();
        String Password = password.getText();

        Alert message=new Alert(Alert.AlertType.INFORMATION);

        //if user enters right credentials
        if(Username.equals("root")&&Password.equals("root"))
        {
            message.setContentText("Welcome "+Username+"!");
            message.setTitle("Welcome!");

            //Hide Sign In interface
            SignIn.getScene().getWindow().hide();

            //Show media player
            Parent  root = (Parent)FXMLLoader.load(getClass().getResource("MediaPlayer.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Ampify");
            primaryStage.setScene(new Scene(root, 500, 500));
            primaryStage.show();
            message.show();

        }

        else if(Username.equals("")&&Password.equals(""))
        {
            message.setContentText("Please fill the Details");
            message.setTitle("Unsuccessful Login");
            message.show();
        }
        else
        {
            message.setContentText("Invalid User Details");
            message.setTitle("Unsuccessful Login!");
            message.show();
        }


        username.setText("");
        password.setText("");
    }

    public void signup()
    {

    }

    public void logout() throws IOException {
        //Hide media player
        logout.getScene().getWindow().hide();
        Parent  root = (Parent)FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Ampify");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

}
