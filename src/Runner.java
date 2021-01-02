import Users.DAO.UserImpl;
import Users.model.User;

public class Runner {
    public static void main(String[] args)throws Exception{
        UserImpl userimp = new UserImpl();
        userimp.addUser(new User("ragaca","sfds"));

    }
}
