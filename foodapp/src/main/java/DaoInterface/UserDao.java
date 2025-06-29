package DaoInterface;

import domain.Users;

public interface UserDao {
    public boolean saveUser(Users user);
    public Users getUsers(String username, String password);
}
