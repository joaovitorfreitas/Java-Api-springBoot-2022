package br.com.springboot.UserAPi.repository;


import br.com.springboot.UserAPi.model.worked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkedRepository extends JpaRepository<worked, Integer> {

}
