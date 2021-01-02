package CinemaMainStage;

import CinemaMainStage.Tickets.Ticket;
import CinemaMainStage.Tickets.TicketsImpl;
import Users.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;


public class CinemaMainStageController {


    public HBox mainStageHBox;

    public void initialize() throws Exception{
        int pictureNum = 1;

        for(int i = 1; i < 8;i++){
            VBox mainStageVbox = new VBox();
            FileInputStream input = new FileInputStream(("C:\\Users\\sandro\\IdeaProjects\\CinemaApp\\src\\CinemaMainStage\\Resources\\picture" + pictureNum +".jpg"));
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(300);
            imageView.setFitWidth(150);
            mainStageVbox.getChildren().add(imageView);
            mainStageHBox.setSpacing(40);
            mainStageVbox.setAlignment(Pos.CENTER);
            pictureNum++;
            Button button = new Button("ყიდვა");
            button.setPadding(new Insets(10,10,10,10));
            button.setStyle("-fx-background-color: #2A3638; -fx-text-fill: #FFFFFF");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        buyTicket(event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            mainStageVbox.getChildren().add(button);
            mainStageHBox.getChildren().add(mainStageVbox);

        }

    }

    public void buyTicket(ActionEvent event) throws Exception {
        Parent root1 =  FXMLLoader.load(getClass().getResource("Confirmation.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
