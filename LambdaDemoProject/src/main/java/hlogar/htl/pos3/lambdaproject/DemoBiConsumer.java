/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DemoBiConsumer {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        
        BiConsumer<Integer,String> biConsumer = (key, value) -> System.out.println("Key:"+ key+" Value:"+ value);
        map.forEach(biConsumer);
    }
}
