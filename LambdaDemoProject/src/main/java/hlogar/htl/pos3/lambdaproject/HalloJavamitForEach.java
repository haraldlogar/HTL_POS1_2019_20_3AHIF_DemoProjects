/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

import java.util.List;
import java.util.Arrays;

/**
 *
 * @author bmayr
 */
public class HalloJavamitForEach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> liste = Arrays.asList("\nHallo ", "Java 8!");
        // Die Liste der Strings in einer for-each-Schleife anzeigen
        for (String string : liste) {
            System.out.print(string);
        }
        // Alternativ eine Lambda-Expression benutzen; in der forEach()-
        // Methode der Klasse List<String> wird eine
        // Consumer<String>-Instanz übergeben
        liste.forEach((String s) -> System.out.print(s + " "));
        // Alternativ eine Methoden-Referenz benutzen;
        liste.forEach(System.out::print);
    }
}
