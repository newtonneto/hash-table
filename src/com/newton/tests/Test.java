package com.newton.tests;

import com.newton.resources.HashTable;

public class Test {
    public void testOne() {
        HashTable hash = new HashTable(13);

        hash.insertItem("TESTE");
        hash.insertItem("ksahduia");
        hash.insertItem("shduahsu");
        hash.insertItem("lalala");

        hash.print();

        System.out.println("--->" + hash.findElement("TESTEdsad"));
        System.out.println("--->" + hash.removeElement("TESTE"));
        hash.insertItem("zZzZzZz");
        hash.insertItem("hUASHUAHS");
        hash.insertItem("meeeeh");
        hash.insertItem("fallenace");
        hash.insertItem("winteriscoming");
        hash.insertItem("testando");
        hash.insertItem("testador");
        hash.insertItem("thetest");
        hash.insertItem("hahaha");
        hash.insertItem("funciona");

        hash.print();

        hash.insertItem("lololol");

        hash.print();
    }
}
