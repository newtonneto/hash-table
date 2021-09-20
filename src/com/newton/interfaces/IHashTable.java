package com.newton.interfaces;

public interface IHashTable {
    Object findElement(Object element);
    void insertItem(Object element);
    Object removeElement(Object element);
    Integer dispersion(Object element);
    Integer compression(Integer dispersion_value);
}
