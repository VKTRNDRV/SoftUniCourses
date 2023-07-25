package softuni.exam.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

     <T> T parseXML(String xml, Class<T> clazz) throws JAXBException;
}
