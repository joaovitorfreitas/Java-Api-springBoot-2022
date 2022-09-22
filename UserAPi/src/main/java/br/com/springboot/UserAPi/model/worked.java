package br.com.springboot.UserAPi.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Workedd {

    @Id
    @Column(name = "IDD")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String workName;
}