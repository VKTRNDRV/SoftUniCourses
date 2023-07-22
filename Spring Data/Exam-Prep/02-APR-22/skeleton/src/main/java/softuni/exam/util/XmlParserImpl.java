package softuni.exam.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
public class XmlParserImpl implements XmlParser{
    @Override
    public <T> T fromString(String string, Class<T> clazz) throws JAXBException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(clazz)
                .createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(string));

    }
}
