package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.model.Teste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TesteRepository extends JpaRepository<Teste, Integer> {

    @Query("SELECT u from Teste u where u.id > :id")
    public List<Teste> findAllMoreThan(@Param("id") Integer id);


    //Utilizando greaterThan para pegar oq vem dps do id
    public List<Teste> findByIdGreaterThan(Integer id);

    //após o findby o name é um parametro fornecido atraves do objeto
    public List<Teste> findByNameIgnoreCase(String name);
}
