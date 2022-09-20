package br.com.springboot.UserAPi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    private String Email;

    private String passWord;

    private boolean administrator;
}
