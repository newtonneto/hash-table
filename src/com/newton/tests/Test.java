package com.newton.tests;

import com.newton.resources.HashTable;

public class Test {
    public void testOne() {
        HashTable hash = new HashTable(11);

        hash.insertItem("TESTE");
        System.out.println(hash.findElement("TESTE"));
    }
}
