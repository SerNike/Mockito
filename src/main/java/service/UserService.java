package service;

import DAO.UserDAO;
import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO;

    public boolean checkUserExist(User user) {
        if (userDAO.getUserByName(user.getName()) == null) {
            return false;
        }
        return true;
    }



}
