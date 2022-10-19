package com.bci.examen.examen.utils;

@FunctionalInterface
public interface RegExInterface {
    public boolean match (String field, String regex);
}
