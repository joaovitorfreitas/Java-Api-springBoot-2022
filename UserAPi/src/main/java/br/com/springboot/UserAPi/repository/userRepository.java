package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class userRepository {
    private List<User> tempList;

    private int id = 1;

    private static userRepository _userRepository;

    private userRepository(){
        tempList = new ArrayList<>();
    }

    public static userRepository getUserRepository() {

        if (_userRepository == null) {
            _userRepository = new userRepository();
        }

        return _userRepository;
    }

    private boolean checkEmail(String email) {
        return tempList.stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).count() > 0;
    }


    public User registerUser(User _user) {

        if (checkEmail(_user.getEmail())) {
            return null;
        }

        _user.setId((id++));

        tempList.add(_user);

        return _user;
    }

}
