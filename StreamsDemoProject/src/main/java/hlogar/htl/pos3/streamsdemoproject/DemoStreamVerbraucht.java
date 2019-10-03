/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.streamsdemoproject;

import java.util.stream.IntStream;
/**
 *
 * @author hlogar
 */
public class DemoStreamVerbraucht {
    
    public static void main(String[] args) {
        IntStream is = IntStream.range(0, 7).filter(i -> i >= 3);
        is.forEach(i -> System.out.print(i + ", ")); // ok
        System.out.println();
        
        int sum = is.sum(); // 2. consumer: problem! Stream muss neu erzeugt werden
        
        // correct wäre 
        // is = IntStream.range(0, 7).filter(i -> i >= 3);
        // int sum = is.sum(); // ok
        
    }    
    

}
