package br.com.springboot.UserAPi.Dto;

import br.com.springboot.UserAPi.model.worked;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class workedDto {

    private Integer id;

    private String workname;

    public workedDto(worked work){
        this.id = work.getId();
        this.workname = work.getWorkname();
    }

   public List<workedDto> convertModelWorkedToDto(List<worked> works){
        return works.stream().map(workedDto::new).collect(Collectors.toList());
    }


}
