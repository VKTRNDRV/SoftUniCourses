package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

@Component
public class XmlParserImpl implements XmlParser{
    @Override
    public <T> T fromString(String str, Class<T> entityClass) throws JAXBException {
        return (T) JAXBContext.newInstance(entityClass)
                .createUnmarshaller()
                .unmarshal(new StringReader(str));
    }
}
