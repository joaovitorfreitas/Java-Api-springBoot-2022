package br.com.springboot.UserAPi.service;

import br.com.springboot.UserAPi.Dto.workedDto;
import br.com.springboot.UserAPi.model.worked;
import br.com.springboot.UserAPi.repository.WorkedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class workedService {

    private WorkedRepository worked;
    private  workedDto workedto;

    @Autowired
    workedService(WorkedRepository worked, workedDto works){
        this.worked = worked;
        this.workedto = works;
    }

    public List<workedDto> findall(){
        List<worked> work = worked.findAll();
        return workedto.convertModelWorkedToDto(work);
    }


    public workedDto findByID(Integer id){

        worked work = worked.findById(id).get();
        return new workedDto(work);
    }

    @Transactional
    public workedDto Save(worked work){
        return new workedDto(worked.save(work));
    }

    @Transactional
    public void remove(Integer id){
        if(findByID(id) != null){
            worked.deleteById(id);
        }
    }

    public workedDto update(Integer id, worked works){

        worked work = worked.findById(id).get();

        work.setWorkname(works.getWorkname());

        return new workedDto(worked.save(work));
    }



}
