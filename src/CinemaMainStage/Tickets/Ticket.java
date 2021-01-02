package CinemaMainStage.Tickets;

public class Ticket {
    private String username;

    private String movieName;

    public Ticket(String username, String movieName) {
        this.username = username;
        this.movieName = movieName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
