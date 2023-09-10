package utkarsh.OrderFood.service;

import utkarsh.OrderFood.dao.UserDao;
import utkarsh.OrderFood.exception.UserNotFoundException;
import utkarsh.OrderFood.models.User;

import java.util.UUID;

public class UseService {
    UserDao userDao = UserDao.getInstance();

    public User registerUser(String name, String phoneNumber) {
        User user = User.builder().id(UUID.randomUUID().toString())
                .name(name)
                .phNo(phoneNumber)
                .build();
        return userDao.addUser(user);
    }

    public boolean setLogInUser(String phone) {
        User user = null;
        try {
            user = userDao.getUserByPhone(phone);
            userDao.setCurrentLogIn(user);
            return true;
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
