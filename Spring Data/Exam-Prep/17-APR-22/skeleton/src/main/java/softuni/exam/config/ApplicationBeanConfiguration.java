package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParser;
import softuni.exam.util.XmlParserImpl;

// TODO:
@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }

    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }

}
