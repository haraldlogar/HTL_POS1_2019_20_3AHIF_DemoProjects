/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.streamsdemoproject;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author hlogar
 */
public class DemoIntStream {

    public static void main(String args[]) {

        System.out.println("Liste mit allen Zahlen von 1 - 3");
        IntStream.range(1, 4).forEach(i -> System.out.println(i));
        System.out.println();
        
        System.out.println("Berechne den Durchschnitt aus diesen Zahlen");
        double avg = IntStream.range(1, 47)
                .average()
                .getAsDouble();
        System.out.println(avg);
        System.out.println();

        System.out.println("Berechne den Durchschnitt aus diesen Quadrat-Zahlen");
        avg = IntStream.range(1, 47)
                .map(n -> n * n)
                .average()
                .getAsDouble();
        System.out.println(avg);
        System.out.println();

        System.out.println("Ermittle den Zahlenwert aus der Liste (Präfix wird ignoriert: ");
        Stream.of("a1", "a8", "a3", "b4")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);
    }

}
