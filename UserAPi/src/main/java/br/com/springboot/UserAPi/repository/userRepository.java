package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.model.User;

import java.util.List;

public class userRepository {
    private List<User> tempoList;

    private int id = 1;

    private static userRepository _userRepository;

    public static userRepository getUserRepository(){

        if(_userRepository == null){
            _userRepository = new userRepository();
        }

        return  _userRepository;
    }
}
