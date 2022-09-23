package br.com.springboot.UserAPi.configurantion;

import br.com.springboot.UserAPi.Dto.workedDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class workedDtoConfig {

    @Bean
    public workedDto workedDto() {
        return  new workedDto();
    }
}
