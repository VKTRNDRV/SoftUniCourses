package hiberspring.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;


@Component
public class XmlParserImpl implements XmlParser{
    @Override
    @SuppressWarnings("unchecked")
    public <O> O parseXml(Class<O> objectClass, String xml) throws JAXBException {
        JAXBContext context = JAXBContext
                .newInstance(objectClass);
        return (O) context
                .createUnmarshaller()
                .unmarshal(new StringReader(xml));
    }
}
