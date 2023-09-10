package utkarsh.OrderFood.dao;

import lombok.Getter;
import lombok.Setter;
import utkarsh.OrderFood.exception.UserNotFoundException;
import utkarsh.OrderFood.models.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDao {
    private static UserDao instance = null;

    private UserDao() {
    }
    private Map<String, User> userMap = new ConcurrentHashMap<>();

    public @Getter @Setter User currentLogIn = null;
    public static UserDao getInstance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    public User addUser(User user) {
        System.out.printf("ADDING USER :: %s%n", user.toString());
        return userMap.put(user.getPhNo(), user);
    }

    public User getUserByPhone(String phone) throws UserNotFoundException {
        System.out.printf(" FIND USER WITH PHONE %s%n", phone);
        if(!userMap.containsKey(phone))
            throw new UserNotFoundException();
        return userMap.get(phone);
    }
}