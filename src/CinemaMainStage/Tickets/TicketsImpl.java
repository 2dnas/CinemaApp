package CinemaMainStage.Tickets;

import java.sql.*;

public class TicketsImpl implements TicketsDAO{
    Connection connection;

    public TicketsImpl() throws Exception {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", "postgres", "1");
    }

    @Override
    public void add(Ticket ticket) throws SQLException {
        String username = ticket.getUsername();
        String movieName = ticket.getMovieName();
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO tickets (username , movieName) values('" + username + "','" + movieName + "')");


    }


}
