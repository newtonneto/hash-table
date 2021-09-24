package com.newton.interfaces;

public interface IHashTable {
    Integer findElement(Object element);
    void insertItem(Object element, Character type);
    Object removeElement(Object element);
    void print();
}
