package exam.config;
//ToDo

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exam.util.ValidationUtils;
import exam.util.ValidationUtilsImpl;
import exam.util.XmlParser;
import exam.util.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }

    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }

    @Bean
    public ValidationUtils validationUtils(){
        return new ValidationUtilsImpl();
    }
}
