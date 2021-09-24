package com.newton.tests;

import com.newton.resources.HashTable;

public class Test {
    public void testLinearProbing() {
        HashTable hash = new HashTable(13);

        hash.insertItem("TESTE", 'l');
        hash.insertItem("ksahduia", 'l');
        hash.insertItem("shduahsu", 'l');
        hash.insertItem("lalala", 'l');

        hash.print();

        System.out.println("--->" + hash.findElement("TESTEdsad"));
        System.out.println("--->" + hash.removeElement("TESTE"));
        hash.insertItem("zZzZzZz", 'l');
        hash.insertItem("hUASHUAHS", 'l');
        hash.insertItem("meeeeh", 'l');
        hash.insertItem("fallenace", 'l');
        hash.insertItem("winteriscoming", 'l');
        hash.insertItem("testando", 'l');
        hash.insertItem("testador", 'l');
        hash.insertItem("thetest", 'l');
        hash.insertItem("hahaha", 'l');
        hash.insertItem("funciona", 'l');

        hash.print();

        hash.insertItem("lololol", 'l');

        hash.print();
    }

    public void testDoubleHash() {
        HashTable hash = new HashTable(13);

        hash.insertItem("18", 'h');
        hash.print();
        hash.insertItem("41", 'h');
        hash.print();
        hash.insertItem("22", 'h');
        hash.print();
        hash.insertItem("44", 'h');
        hash.print();
        hash.insertItem("59", 'h');
        hash.print();
        hash.insertItem("32", 'h');
        hash.print();
        hash.insertItem("31", 'h');
        hash.print();
        hash.insertItem("73", 'h');
        hash.print();
    }
}
