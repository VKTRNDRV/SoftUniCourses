package com.example.football.util;

public interface XmlParser {

    <T> T fromString(String xml, Class<T> clazz);
}
