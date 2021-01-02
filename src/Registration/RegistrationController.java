package Registration;

import Users.DAO.UserImpl;
import Users.model.User;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegistrationController  {
    UserImpl userImpl = new UserImpl();

    public TextField registrationUsername;
    public PasswordField registrationPassword;
    public PasswordField repeatPasswordField;
    public VBox registrationVBox;

    public RegistrationController() throws Exception {
    }


    public void onRegister() throws Exception{
        Label label = new Label();
        if(registrationPassword.getText().equals(repeatPasswordField.getText())){
            String username = registrationUsername.getText();
            String password = registrationPassword.getText();
            User user = new User(username,password);
            userImpl.addUser(user);
            label.setText("გილოცავთ თქვენ წარმატებით დარეგისტრირდით");
            label.setStyle("-fx-font-size: 15; -fx-text-fill: #339933;-fx-font-weight: bold");
        }else {
            label.setText("პაროლი არ ემთხვევა ერთმანეთს სცადეთ თავიდან");
            label.setStyle("-fx-font-size: 15; -fx-text-fill: #FF2222;-fx-font-weight: bold");

        }
        registrationVBox.getChildren().add(label);

    }

}
