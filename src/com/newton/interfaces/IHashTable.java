package com.newton.interfaces;

public interface IHashTable {
    Integer findElement(Object element, Character type);
    void insertItem(Object element, Character type);
    Object removeElement(Object element, Character type);
    void print();
}
