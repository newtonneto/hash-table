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

        hash.insertItem("AMD", 'h');
        hash.print();
        hash.insertItem("Corsair", 'h');
        hash.print();
        hash.insertItem("Galax", 'h');
        hash.print();
        hash.insertItem("EVGA", 'h');
        hash.print();
        hash.insertItem("Sharkoon", 'h');
        hash.print();
        hash.insertItem("Lian Li", 'h');
        hash.print();
        hash.insertItem("XFX", 'h');
        hash.print();
        hash.insertItem("Sapphire", 'h');
        hash.print();
        hash.insertItem("Asus", 'h');
        hash.print();
        hash.insertItem("PowerColor", 'h');
        hash.print();
        hash.insertItem("Palit", 'h');
        hash.print();
        hash.insertItem("NVIDIA", 'h');
        hash.print();

        // Procurando o indice de um elemento presente na hash
        System.out.println("Sapphire: " + hash.findElement("Sapphire", 'h'));

        // Procurando o indice de um elemento que não existe na hash
        System.out.println("Intel index: " + hash.findElement("Intel", 'h'));

        // Removendo um elemento que não foi realocado (inserido de primeira)
        hash.removeElement("AMD", 'h');
        hash.print();

        // Removendo um elemento que foi realocado (não foi inserido de primeira)
        hash.removeElement("Sapphire", 'h');
        hash.print();

        // Inserindo elemento em um índice que já foi ocupado por algum elemento mas agora está vazio
        hash.insertItem("AMD", 'h');
        hash.print();
    }
}
