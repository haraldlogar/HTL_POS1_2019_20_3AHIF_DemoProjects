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
public class LearningObjectivesTest2 {

    public static void main(String[] args) {

        String[] txt = {"This", "is", "a", "stream", "demo"};

        String result = Arrays.stream(txt)
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .map(s2 -> s2.substring(0, 1))
                .sorted()
                .reduce("X", (a, b) -> a + b + a + " ");
        System.out.println(result);
        
        // Result will be:
        // ==> this is a stream demo
        // .filter(s -> s.length() > 3)
        // ==> this      stream demo
        // .map(String::toUpperCase)
        // ==> THIS      STREAM DEMO
        // .map(s2 -> s2.substring(0, 1))
        // ==> T         S      D
        // .sorted()
        // ==> D         S      T
        // .reduce("X", (a, b) -> a + b + a + " ");
        // "X" "D" "S" "T"
        // ==> reduce (a, b) -> "X" + "D" + "X" + " " ==> "XDX "
        // "XDX " "S" "T" 
        // ==> reduce (a, b) -> "XDX " + "S" + "XDX " + " " ==> "XDX SXDX  "
        // "XDX SXDX  " "T"
        // ==> reduce (a, b) -> "XDX SXDX  " + "T" + "XDX SXDX  " + " " ==> "XDX SXDX  TXDX SXDX   "
        // ==> "XDX SXDX  TXDX SXDX   "
    }
}
