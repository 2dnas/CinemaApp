package Users.DAO;

import Users.model.User;

import java.sql.*;

public class UserImpl implements UserDAO {

    private Connection connection;

    public UserImpl() throws Exception {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", "postgres", "1");
    }

    @Override
    public void addUser(User user)throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO users (username , password) values('" + username + "','" + password + "')");


    }
}
