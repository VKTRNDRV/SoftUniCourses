package softuni.exam.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <T> T fromString(String string, Class<T> clazz) throws JAXBException;
}
