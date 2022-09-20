package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class userRepository {
    private List<User> tempList;

    private int id = 1;

    private static userRepository _userRepository;

    public static userRepository getUserRepository() {

        if (_userRepository == null) {
            _userRepository = new userRepository();
        }

        return _userRepository;
    }

    private boolean checkEmail(String email) {
        if (tempList.stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).count() == 1) {
            return true;
        }

        return false;
    }


    private void checkNullList() {
        if (tempList == null) {
            tempList = new ArrayList<>();
        }
    }


    public User registerUser(User _user) {
        checkNullList();

        if (checkEmail(_user.getEmail())) {
            return null;
        }

        _user.setId((id++));

        tempList.add(_user);

        return _user;
    }

    public Stream<User> LoginUser(User _user) {

        return tempList.stream().filter(user -> user.getEmail().equals(_user.getEmail()) && user.getPassWord().equals(_user.getPassWord()));
    }


}
