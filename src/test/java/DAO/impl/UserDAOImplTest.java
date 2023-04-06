package DAO.impl;

import model.User;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserDAOImplTest {
    public static final String USER_ONE = "Сергей";
    public static final String USER_TWO = "Андрей";
    User user1;
    User user2;
    List<User> listUser = new ArrayList<>();
    private final UserDAOImpl out = new UserDAOImpl(listUser);

    @BeforeEach
    void init() {
        user1 = new User(USER_ONE);
        user2 = new User(USER_TWO);
        listUser.add(user1);
    }
    @AfterEach
    public void afterTest() {
        System.out.println("Testing is finished!");
    }

    @Test
    public void getUserByName() {
        assertNotNull(out.getUserByName(user1.getName()));
    }

    @Test
    public void findAllUsers() {
        assertNull(out.getUserByName(user2.getName()));
    }
}