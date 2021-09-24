package com.newton;

import com.newton.tests.Test;

public class Main {

    public static void main(String[] args) {
        Test test = new Test();

        test.testLinearProbing();
        test.testDoubleHash();
    }
}
