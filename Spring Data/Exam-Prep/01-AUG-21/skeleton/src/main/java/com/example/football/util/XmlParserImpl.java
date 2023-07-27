package com.example.football.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

public class XmlParserImpl implements XmlParser{
    @Override
    public <T> T fromString(String xml, Class<T> clazz) {
        try {
            return (T) JAXBContext.newInstance(clazz)
                    .createUnmarshaller()
                    .unmarshal(new StringReader(xml));
        }catch (JAXBException ignored){}
        return null;
    }
}
