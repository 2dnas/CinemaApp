package Authorization;


import Users.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class AuthorizationController {
    public VBox authorizationVBox;
    public StackPane authorizationStackPane;
    Connection connection;
    public TextField usernameTextField;
    public PasswordField passwordField;

    public void onRegisterPage() throws IOException {
            Parent root1 =  FXMLLoader.load(getClass().getResource("/Registration/registration.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

    }

    public void onAuthorization(ActionEvent event)throws Exception{
        Label label = new Label();
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", "postgres", "1");

        Statement statement = connection.createStatement();
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        ResultSet result = statement.executeQuery("SELECT * FROM users WHERE username='" + username + "'");
        if(result.next()){
            if(result.getString("password").equals(password)){
                label.setText("თქვენ წარმატებით გაიარეთ ავტორიზაცია");
                label.setStyle("-fx-text-fill: #339933;-fx-font-size: 15;-fx-font-weight: bold");
                Parent mainParent = FXMLLoader.load(getClass().getResource("/CinemaMainStage/cinemaMainStage.fxml"));
                Scene mainScene = new Scene(mainParent,1500,800);
                Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                mainStage.setScene(mainScene);
                mainStage.show();


            }else {
                label.setText("თქვენ შეიყვანეთ არასწორი პაროლი");
                label.setStyle("-fx-text-fill: #FF1111;-fx-font-size: 15;-fx-font-weight: bold");
            }
            authorizationVBox.getChildren().add(label);
        }else{
            label.setText("ასეთი მომხმარებელი არ არსებობს");
            label.setStyle("-fx-text-fill: #FF1111;-fx-font-size: 15;-fx-font-weight: bold");
            authorizationVBox.getChildren().add(label);
        }
    }


}
