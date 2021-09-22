package com.newton.resources;

import com.newton.interfaces.IHashTable;
import com.sun.tools.jconsole.JConsoleContext;

public class HashTable implements IHashTable {
    private Integer size;
    private Integer prime = 7;
    private Object[] hashtable;
    private double used_slots;

    public HashTable(Integer size) {
        this.size = size;
        this.hashtable = new Object[size];
        this.used_slots = 0;
    }

    @Override
    public Integer findElement(Object element) {
        Integer dispersion_value = this.dispersion(element);
        Integer compression_value = this.compression(dispersion_value);
        Integer index_finded_element = this.linearProbingFind(compression_value, element);

        return index_finded_element;
    }

    public Integer linearProbingFind(Integer compression_value, Object element) {
        // Armazena a quantidade de tentativas de busca, o número não deve execeder o
        // tamanho do array
        Integer find_attempts = 0;

        while (find_attempts < this.size) {
            // Recebe o que está armazenado no indice atual
            Object storaged_item = this.hashtable[compression_value];

            if (storaged_item == null) {
                System.out.println("NO_SUCH_KEY");

                return null;
            } else if (element == storaged_item) {
                System.out.println("-> Elemento " + element + " encontrado no índice " + compression_value + ".");

                return compression_value;
            } else {
                find_attempts++;
                compression_value = this.compression(compression_value + 1);
            }
        }

        System.out.println("NO_SUCH_KEY");

        return null;
    }

    @Override
    public void insertItem(Object element) {
        Integer dispersion_value = this.dispersion(element);
        Integer compression_value = this.compression(dispersion_value);
        double alfa = this.calculateAlfa();

        if (element instanceof String && element != "AVAILABLE" && alfa <= 0.5) {
            this.linearProbingInsert(compression_value, element);
        } else if (alfa > 0.5) {
            // re hash
            this.reHash(compression_value, element);
        } else {
            // exception here
        }
    }

    public double calculateAlfa() {
        return this.used_slots / this.size;
    }

    public void linearProbingInsert(Integer compression_value, Object element) {
        // Armazena a quantidade de tentativas de alocação, o número não deve execeder o
        // tamanho do array
        Integer allocation_attempts = 0;

        while (allocation_attempts < this.size) {
            // Recebe o que está armazenado no indice atual
            Object storaged_item = this.hashtable[compression_value];

            if (storaged_item == null || storaged_item == "AVAILABLE") {
                System.out.println("-> Alocando " + element + " no índice " + compression_value + " após "
                        + allocation_attempts + " tentativa(s) de inserção.");

                this.hashtable[compression_value] = element;
                this.used_slots++;

                return;
            } else {
                System.out.println("-> Espaço " + compression_value + " ocupado, passando para o próximo espaço...");
                allocation_attempts++;
                compression_value = this.compression(compression_value + 1);
            }
        }
    }

    @Override
    public Object removeElement(Object element) {
        // using linear probing
        if (findElement(element) == null) {
            return "NO_SUCH_KEY";
        }

        Integer index = findElement(element);
        Object temp = this.hashtable[index];
        this.hashtable[index] = "AVAILABLE";

        return temp;
    }

    public boolean isPrime(int n) {
        if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public int nextPrime(int n) {
        int p;
        if (n % 2 == 0)
            n++;

        for (p = n; p < 2 * n + 2; p += 2) {
            if (isPrime(p))
                return p;
        }

        return -1;
    }

    public void reHash(Integer compression_value, Object element) {
        Integer allocation_attempts = 0;
        Integer j = 1;

        while (allocation_attempts < this.size) {
            // Recebe o que está armazenado no indice atual
            Object storaged_item = this.hashtable[compression_value];

            if (storaged_item == null || storaged_item == "AVAILABLE") {
                System.out.println("-> Alocando " + element + " no índice " + compression_value + " após "
                        + allocation_attempts + " tentativa(s) de inserção.");

                this.hashtable[compression_value] = element;
                this.used_slots++;

                return;
            } else {
                allocation_attempts++;

                Integer index = compression_value;
                Integer index2 = this.compressionDouble(compression_value + 1);

                Integer newIndex = (index + j * index2) % this.size;

                // if no collision occours
                if (this.hashtable[newIndex] == null || this.hashtable[newIndex] == "AVAILABLE") {
                    System.out.println("-> Realocando " + element + " no índice " + newIndex + " apos "
                            + allocation_attempts + " tentativa(s) de inserção.");

                    this.hashtable[newIndex] = element;
                    return;
                }
                j++;
            }
        }
    }

    @Override
    public Integer dispersion(Object element) {
        Integer dispersion_value = 0;

        // Verifica se o objeto passado é uma string, que no caso é o tipo de elemento
        // armazenado
        if (element instanceof String) {
            Integer string_size = ((String) element).length();

            // Acumulação polinomial
            for (Integer index = 0; index < string_size; index++) {
                dispersion_value = dispersion_value
                        + (((int) ((String) element).charAt(index)) * ((int) Math.pow(2, index)));
            }
        }

        return dispersion_value;
    }

    @Override
    public Integer compression(Integer dispersion_value) {
        return dispersion_value % this.size;
    }

    public Integer compressionDouble(Integer dispersion_value) {
        return (prime - (dispersion_value % prime));
    }
}
