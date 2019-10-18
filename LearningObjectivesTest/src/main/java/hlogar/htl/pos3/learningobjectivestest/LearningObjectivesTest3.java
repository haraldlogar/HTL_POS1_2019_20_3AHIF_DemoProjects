package hlogar.htl.pos3.learningobjectivestest;


import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hlogar
 */
public class LearningObjectivesTest3 {

    public static void main(String[] args) {

        String[] txt = {"This", "is", "a", "stream", "demo"};
        
        // solution 1
        String result = Integer.toString(Arrays.stream(txt)
                    .mapToInt(s -> s.length())
                    .max().getAsInt());
        System.out.println(result);        

        // solution 2
        result = Arrays.stream(txt)
                    .mapToInt(s -> s.length())
                    .max().getAsInt() + "";
        System.out.println(result);
        
        // solution 2
        result = Arrays.stream(txt)
                    .map(s -> String.valueOf(s.length()))
                    .reduce("0", (a, b) -> (Integer.valueOf(a) > Integer.valueOf(b) ? a : b));
        System.out.println(result);        

    }
}
