package com.newton.tests;

import com.newton.resources.HashTable;

public class Test {
    public void testLinearProbing() {
        HashTable hash = new HashTable(13);

        // Populando a hash
        hash.insertItem("Ryzen 5 3600X", 'l');
        hash.print();
        hash.insertItem("32gb", 'l');
        hash.print();
        hash.insertItem("3200MHz", 'l');
        hash.print();
        hash.insertItem("RTX 2080", 'l');
        hash.print();
        hash.insertItem("FTW3", 'l');
        hash.print();
        hash.insertItem("H80i V2", 'l');
        hash.print();
        hash.insertItem("AB350 Gaming 3", 'l');
        hash.print();
        hash.insertItem("TG5 RGB", 'l');
        hash.print();
        hash.insertItem("HX750i", 'l');
        hash.print();
        hash.insertItem("SN750", 'l');
        hash.print();
        hash.insertItem("SSD Plus", 'l');
        hash.print();
        hash.insertItem("Dualsense", 'l');
        hash.print();
        hash.insertItem("Ace Kawaii", 'l');
        hash.print();

        // Procurando o indice de um elemento presente na hash
        System.out.println("HX750i index: " + hash.findElement("HX750i", 'l'));

        // Procurando o indice de um elemento que não existe na hash
        System.out.println("Core i7 index: " + hash.findElement("Core i7", 'l'));

        // Removendo um elemento que não foi realocado (inserido de primeira)
        hash.removeElement("Ryzen 5 3600X", 'l');
        hash.print();

        // Removendo um elemento que foi realocado (não foi inserido de primeira)
        hash.removeElement("HX750i", 'l');
        hash.print();

        // Inserindo elemento em um índice que já foi ocupado por algum elemento mas agora está vazio
        hash.insertItem("Ryzen 5 3600X", 'l');
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
