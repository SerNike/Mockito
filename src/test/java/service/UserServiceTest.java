package service;

import DAO.UserDAO;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    public final String NAME = "Сергей";
    User user;

    @BeforeEach
    public void init() {
        user = new User(NAME);
    }

    @AfterEach
    public void afterTest() {
        System.out.println("Testing is finished!");
    }
    @Mock
    private UserDAO userDAOMock;

    @InjectMocks
    private UserService out;

    @Test
    public void ReturnsTrueIfThereIsUser() {
        when(userDAOMock.getUserByName(NAME)).thenReturn(user);
        assertTrue(out.checkUserExist(user));
    }

    @Test
    public void ReturnsFalseIfThereIsUser() {
        when(userDAOMock.getUserByName(anyString())).thenReturn(null);
        assertFalse(out.checkUserExist(user));

    }
}





