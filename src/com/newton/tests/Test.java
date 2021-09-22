package com.newton.tests;

import com.newton.resources.HashTable;

public class Test {
    public void testOne() {
        HashTable hash = new HashTable(13);

        hash.insertItem("TESTE");
        hash.insertItem("TESTE");
        hash.insertItem("TESTE");
        hash.insertItem("TESTE");
        System.out.println("--->" + hash.findElement("TESTEdsad"));
        System.out.println("--->" + hash.removeElement("TESTE"));
        hash.insertItem("zZzZzZz");
        hash.insertItem("hUASHUAHS");
        hash.insertItem("TESTE");
    }
}
