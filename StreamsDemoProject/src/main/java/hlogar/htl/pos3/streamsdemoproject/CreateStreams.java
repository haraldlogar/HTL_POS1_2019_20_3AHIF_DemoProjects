/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.streamsdemoproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author hlogar
 */
public class CreateStreams {

    public static void main(String[] args) {
        
        // convert List into a Stream
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(1);
        myList.add(5);
        myList.add(8);
        
        System.out.println("Convert List into a Stream");
        Stream<Integer> myStream = myList.stream();
        myStream.forEach(System.out::println);        
        
        // Convert Array into a Stream
        System.out.println("Convert Array into a Stream");
        Integer[] myArray = {1, 5, 8};
        Stream<Integer> myStream2 = Arrays.stream(myArray);
        myStream2.forEach(System.out::println); 
        
        System.out.println("Create IntStream");
        IntStream is = IntStream.range(7, 12);
        is.forEach(System.out::println);
    }

}
