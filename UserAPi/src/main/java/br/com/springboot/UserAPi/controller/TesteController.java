package br.com.springboot.UserAPi.controller;

import br.com.springboot.UserAPi.model.Teste;
import br.com.springboot.UserAPi.repository.TesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {
    private final TesteRepository testeRepository;


    @Autowired
     TesteController(TesteRepository testeRepository){
        this.testeRepository = testeRepository;
    }

    //Injeção de dependencia
    @PostMapping("/postTeste")
    public Teste postBanco(@RequestBody Teste teste){
       return this.testeRepository.save(teste);
    }

    @GetMapping("/ListTeste")
    public List<Teste> postBanco(){
        return this.testeRepository.findAll();
    }

    @GetMapping("/FindIdTeste/{id}")
    public Optional<Teste> postBanco(@PathVariable Integer id){
        return this.testeRepository.findById(id);
    }

    @GetMapping("/FindMoreThen/{id}")
    public List<Teste> postMoreThan(@PathVariable Integer id){
        return this.testeRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/FindByName/{name}")
    public List<Teste> findByName(@PathVariable String name){
        return this.testeRepository.findByNameIgnoreCase(name);
    }
}
