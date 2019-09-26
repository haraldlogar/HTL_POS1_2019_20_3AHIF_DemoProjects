/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

import java.util.function.BiPredicate;

public class DemoBiPredicate {

    public static void main(String[] args) {
        BiPredicate<Integer, String> condition = (i, s) -> i > 20 && s.startsWith("R");
        System.out.println(condition.test(10, "Ram"));
        System.out.println(condition.test(30, "Shyam"));
        System.out.println(condition.test(30, "Ram"));
    }
}
