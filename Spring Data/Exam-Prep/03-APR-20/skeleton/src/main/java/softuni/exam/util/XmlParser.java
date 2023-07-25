package softuni.exam.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <T> T fromString(String str, Class<T> entityClass) throws JAXBException;
}
