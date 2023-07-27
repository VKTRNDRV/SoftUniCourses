package com.example.football.config;

import com.example.football.util.ValidationUtils;
import com.example.football.util.ValidationUtilsImpl;
import com.example.football.util.XmlParser;
import com.example.football.util.XmlParserImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//ToDo Create configurations
@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ValidationUtils validationUtils(){
        return new ValidationUtilsImpl();
    }

    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }
}
