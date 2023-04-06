package DAO.impl;

import DAO.UserDAO;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class UserDAOImpl implements UserDAO {

    private final List<User> userList = new ArrayList<>();

    public UserDAOImpl(List<User> userList) {
        this.userList.add(new User("Сергей"));
        this.userList.add(new User("Анна"));
    }

    @Override
    public User getUserByName(String name) {
        if (!userList.isEmpty()) {
            Optional<User> user = userList.stream()
                    .filter(x -> x.getName().equals(name))
                    .findFirst();
            if (user.isPresent()) {
                return user.get();
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return userList;
    }


}
