package CinemaMainStage;

import CinemaMainStage.Tickets.Ticket;
import CinemaMainStage.Tickets.TicketsImpl;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Confirmation {
    public TextField usernameTextField;
    public TextField movieName;
    public VBox VBoxConfirmation;

    Label label = new Label("ტრანზაქცია წარმატებით განხორციელდა");

    public void onBuy() throws Exception {
        String username = usernameTextField.getText();
        String movie = movieName.getText();
        Ticket ticket = new Ticket(username,movie);
        TicketsImpl tickets = new TicketsImpl();
        tickets.add(ticket);
        label.setStyle("-fx-font-size: 15; -fx-text-fill: #215619;-fx-font-weight: bold");
        VBoxConfirmation.getChildren().add(label);
    }

}
