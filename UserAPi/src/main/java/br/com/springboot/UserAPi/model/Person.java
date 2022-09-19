package br.com.springboot.UserAPi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer id;

    private String Cpf;

    private String Name;

    private String Street;

    private Integer numberHome;

    private String District;

    private String Complement;

    private String County;

    private String Uf;

    private String Rg;
}
