/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

import java.util.function.BiFunction;

public class DemoBiFunction {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:" + (num1 + num2);
        System.out.println(biFunction.apply(20, 25));
        
        BiFunction<Integer, Integer, Integer> biFunction2 = (num1, num2) -> (num1 + num2);
        System.out.println(biFunction2.apply(20, 25) + biFunction2.apply(20, 25));
        
        System.out.println(biFunction.apply(biFunction2.apply(20, 25), biFunction2.apply(20, 25)));
    }
}
