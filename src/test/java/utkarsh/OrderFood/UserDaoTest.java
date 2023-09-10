package utkarsh.OrderFood;

import org.junit.jupiter.api.*;
import utkarsh.OrderFood.dao.UserDao;
import utkarsh.OrderFood.exception.UserNotFoundException;
import utkarsh.OrderFood.models.User;

import java.util.UUID;

public class UserDaoTest {
    UserDao userDao = UserDao.getInstance();

    @BeforeAll
    public void init() {
        userDao.addUser(User.builder().id(UUID.randomUUID().toString()).phNo("5312391157").name("Kayla Maystone").build());

        userDao.addUser(User.builder().id(UUID.randomUUID().toString()).phNo("8531569267").name("Reagan Tomes").build());

        userDao.addUser(User.builder().id(UUID.randomUUID().toString()).phNo("8122078352").name("Karissa O'Sesnane").build());

        userDao.addUser(User.builder().id(UUID.randomUUID().toString()).phNo("5654134454").name("Eloise Dolligon").build());

        userDao.addUser(User.builder().id(UUID.randomUUID().toString()).phNo("9279672667").name("Stefano Lampke").build());

        userDao.addUser(User.builder().id(UUID.randomUUID().toString()).phNo("4894059180").name("Othella Coathup").build());
    }

    @Test
    @DisplayName("Adding User")
    public void add() {
        User user1 = User.builder().id(UUID.randomUUID().toString()).phNo("7087257166").name("Utkarsh Kumar").build();
        User user2 = User.builder().id(UUID.randomUUID().toString()).phNo("9087367166").name("Udit").build();
        userDao.addUser(user1);
        userDao.addUser(user2);
        Assertions.assertEquals(user1.getPhNo(), "7087257166");
        Assertions.assertEquals(user2.getPhNo(), "9087367166");
    }

    @Test
    @DisplayName("Removing Users")
    public void remove() {
        userDao.remove("5654134454");
        userDao.remove("4894059180");
        Assertions.assertThrows(UserNotFoundException.class, () -> userDao.getUserByPhone("5654134454"));
        Assertions.assertThrows(UserNotFoundException.class, () -> userDao.getUserByPhone("4894059180"));
    }
}