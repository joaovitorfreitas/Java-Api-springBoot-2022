package br.com.springboot.UserAPi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Vai ser um Entity
@Entity

//Vai ser uma table pode passar um nome para tabela
@Table
public class Teste {

    @Id
    //Id gerando automaticamente
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String name;
}
