package com.newton.resources;

import com.newton.interfaces.IHashTable;
import com.sun.tools.jconsole.JConsoleContext;

public class HashTable implements IHashTable {
    private Integer size;
    private Object[] hashtable;
    private double occupancy_rate;

    public HashTable(Integer size) {
        this.size = size;
        this.hashtable = new Object[size];
        this.occupancy_rate = 0;
    }

    @Override
    public Object findElement(Object element) {
        return null;
    }

    public Object linearProbingFind(Object element) {
        return null;
    }

    @Override
    public void insertItem(Object element) {
        Integer dispersion_value = this.dispersion(element);
        Integer compression_value = this.compression(dispersion_value);

        this.linearProbingInsert(compression_value, element);
    }

    public void linearProbingInsert(Integer compression_value, Object element) {
        //Armazena a quantidade de tentativas de alocação, o número não deve execeder o tamanho do array
        Integer allocation_attempts = 0;

        while (allocation_attempts < this.size) {
            //Recebe o que está armazenado no indice atual
            Object storaged_item = this.hashtable[compression_value];

            if (storaged_item == null) {
                System.out.println("-> Alocando " + element.toString() + " no índice " + compression_value + " após " +
                        allocation_attempts + " tentativa(s) de inserção.");

                this.hashtable[compression_value] = element;

                return;
            } else {
                System.out.println("-> Espaço " + compression_value + " ocupado, passando para o próximo espaço...");
                allocation_attempts++;
                compression_value++;
            }
        }
    }

    @Override
    public Object removeElement(Object element) {
        return null;
    }

    @Override
    public Integer dispersion(Object element) {
        Integer dispersion_value = 0;

        //Verifica se o objeto passado é uma string, que no caso é o tipo de elemento armazenado
        if (element instanceof String) {
            Integer string_size = ((String) element).length();

            //Acumulação polinomial
            for (Integer index =0; index < string_size; index++) {
                dispersion_value = dispersion_value + (((int) ((String) element).charAt(index)) * ((int) Math.pow(2, index)));
            }
        }

        return dispersion_value;
    }

    @Override
    public Integer compression(Integer dispersion_value) {
        return dispersion_value % this.size;
    }
}