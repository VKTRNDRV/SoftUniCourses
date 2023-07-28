package softuni.exam.util;

public interface XmlParser {

    <T> T fromString(String xml, Class<T> objClass);
}
