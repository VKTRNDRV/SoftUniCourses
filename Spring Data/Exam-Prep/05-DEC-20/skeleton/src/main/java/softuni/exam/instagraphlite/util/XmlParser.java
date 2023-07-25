package softuni.exam.instagraphlite.util;

public interface XmlParser {

    <T> T fromString(String xml, Class<T> entityClass);
}
