package hiberspring.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;


public interface XmlParser {

    <O> O parseXml(Class<O> objectClass, String xml) throws JAXBException;
}
