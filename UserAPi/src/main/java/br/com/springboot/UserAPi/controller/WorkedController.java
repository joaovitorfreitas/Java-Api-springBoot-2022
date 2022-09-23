package br.com.springboot.UserAPi.controller;

import br.com.springboot.UserAPi.Dto.workedDto;
import br.com.springboot.UserAPi.model.worked;
import br.com.springboot.UserAPi.service.workedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Worked")
public class WorkedController {

    private final workedService WorkedService;

    @Autowired
    public WorkedController(workedService workedService){
        this.WorkedService = workedService;
    }

    @GetMapping("/List")
    public List<workedDto> findall(){ return this.WorkedService.findall(); }

    @GetMapping("Find/{id}")
    public workedDto findworked(@PathVariable Integer id){ return this.WorkedService.findByID(id);}

    @PostMapping("post")
    public workedDto postworked(@RequestBody worked work){
        return this.WorkedService.Save(work);
    }

    @DeleteMapping("remove/{id}")
    public void removeworked(@PathVariable  Integer id){
        this.WorkedService.remove(id);
    }

    @PutMapping("put/{id}")
    public workedDto updateWorked(@PathVariable Integer id, @RequestBody worked workss){
        return this.WorkedService.update(id, workss);
    }
}
