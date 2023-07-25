package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
public class XmlParserImpl implements XmlParser{

//    public XmlParserImpl(Class<T> clazz){
//        try {
//            this.unmarshaller = JAXBContext
//                    .newInstance(clazz)
//                    .createUnmarshaller();
//        }catch (JAXBException e){}
//    }

    public <T> T parseXML(String xml, Class<T> clazz) throws JAXBException {
       return (T) JAXBContext
               .newInstance(clazz)
               .createUnmarshaller()
               .unmarshal(new StringReader(xml));
    }
}
