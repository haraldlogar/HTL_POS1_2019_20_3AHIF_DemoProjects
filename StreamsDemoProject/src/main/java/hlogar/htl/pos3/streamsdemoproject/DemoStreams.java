/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.streamsdemoproject;

import java.util.Arrays;

/**
 *
 * @author hlogar
 */
public class DemoStreams {
    public static void main(String args[]) {
        String[] txt = {"This", "is", "a", "stream", "demo"};

        System.out.println("Komplette Liste: ");
        Arrays.stream(txt)
              .forEach(System.out::println);
        System.out.println();   
        
        System.out.println("Gefilterte Liste: ");
        Arrays.stream(txt)
              .filter(s -> s.length() > 3)
              .forEach(System.out::println);
        System.out.println();   
        
        System.out.println("Gefilterte Liste UpperCase-Liste: ");
        Arrays.stream(txt)
              .filter(s -> s.length() > 3)
              .map(String::toUpperCase)
              .forEach(System.out::println);        
        System.out.println();   
        
        System.out.println("Gefilterte und sortierte UpperCase-Liste: ");
        Arrays.stream(txt)
              .filter(s -> s.length() > 3)
              .map(String::toUpperCase)
              .sorted()
              .forEach(System.out::println);      
        System.out.println();   
        
        System.out.println("Erstes Element aus der gefilterten und sortierten UpperCase-Liste: ");
        Arrays.stream(txt)
              .filter(s -> s.length() > 3)
              .map(String::toUpperCase)
              .sorted()
              .findFirst()
              .ifPresent(System.out::println);         
        System.out.println();   
                
        System.out.println("Gefilterte und gemappte Liste: ");
        Arrays.stream(txt)
              .filter(s -> s.length() > 3)
              .mapToInt(s -> s.length())
              .forEach(System.out::println);
        System.out.println();   
        
        System.out.println("Reduziert auf einen String: ");
        String result = Arrays.stream(txt)
                              .filter(s -> s.length() > 3)
                              .reduce("", (a, b) -> a + b);
        System.out.println(result); 
        System.out.println();   
        
        System.out.println("Reduziert auf Summe der Längen: ");
        int x = Arrays.stream(txt)
                      .filter(s -> s.length() > 3)
                      .mapToInt(s -> s.length())
                      .reduce(1, (a, b) -> (a + b));
        System.out.println(x);
    }
    
}
