package hlogar.htl.pos3.learningobjectivestest;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hlogar
 */
public class LearningObjectivesTest4 {

    public static void main(String[] args) {

        ArrayList<Person> ar = new ArrayList<>();
        ar.add(new Person(4739, "Mickey Maus", "1010", "Wien"));
        ar.add(new Person(8412, "Donald Duck", "8020", "Graz"));
        ar.add(new Person(1393, "Dagobert Duck", "5020", "Entenhausen"));
        ar.add(new Person(3912, "Gustav Gans", "1010", "Wien"));

        // Solution 1
        ar.stream()
          .map(s -> s.getName())
          .sorted()
          .forEach(System.out::println);
                
        // Solution 2
        ar.stream()
          .sorted((a1, a2) -> a1.getName().compareTo(a2.getName()))
          .forEach(s2 -> System.out.println(s2.getName()));
    }
}
