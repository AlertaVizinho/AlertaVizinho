package br.com.alertavizinho.app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class Configuration {

    @Bean
    public ModelMapper obterModelMapper() {
        return new ModelMapper();
    }
}
