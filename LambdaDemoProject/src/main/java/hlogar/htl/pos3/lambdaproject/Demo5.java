/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

import java.util.function.Function;

public class Demo5 {
//API which accepts an implementation of
//Function interface

    static void modifyTheValue(int valueToBeOperated,
            Function<Integer, Integer> function) {
        int newValue = function.apply(valueToBeOperated);
        /*
* Do some operations using the new value.
         */
        System.out.println(newValue);
    }

    public static void main(String[] args) {
        int incr = 20;
        int myNumber = 10;
        modifyTheValue(myNumber, val -> val + incr);
        myNumber = 15;
        modifyTheValue(myNumber, val -> val * 10);
        modifyTheValue(myNumber, val -> val - 100);
        modifyTheValue(myNumber, val -> "somestring".length() + val - 100);
    }
}
