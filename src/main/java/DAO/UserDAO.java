package DAO;

import model.User;

import java.util.List;

public interface UserDAO {

    User getUserByName(String name);

    List<User> findAllUsers();

}
