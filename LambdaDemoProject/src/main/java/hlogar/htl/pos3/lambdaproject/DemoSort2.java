/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

import java.util.ArrayList;

/**
 *
 * @author hlogar
 */
public class DemoSort2 {
    
    public static void main (String[] args) 
    { 
        ArrayList<Person> ar = new ArrayList<>(); 
        ar.add(new Person(4739, "Mickey Maus", "Kubinweg 1", "1010", "Wien")); 
        ar.add(new Person(8412, "Donald Duck", "Getreidestrasse 17", "8020", "Graz")); 
        ar.add(new Person(1393, "Dagobert Duck", "Speicherweg 1", "5020", "Entenhausen"));
        ar.add(new Person(3912, "Gustav Gans", "Klostergasse 3", "1010", "Wien")); 
        
        System.out.println("Unsortiert"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
  
        ar.sort((a, b) -> (a.Nr - b.Nr)); 
  
        System.out.println("\nSortiert nach Nr."); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
  
        ar.sort((a, b) -> (a.Name.compareTo(b.Name)));
  
        System.out.println("\nSortiert nach Name"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
        
        ar.sort((a, b) -> {
                        int PLZCompare = a.PLZ.compareTo(b.PLZ);
                        int StrasseCompare = a.Strasse.compareTo(b.Strasse);
                        if (PLZCompare == 0) { 
                            if (StrasseCompare == 0) {
                                return 0;
                            }
                            else {
                                return StrasseCompare;
                            }
                        }
                        else {
                            return PLZCompare;
                        }
                    });
        System.out.println("\nSortiert nach Adresse"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i));      
       
    }      
}
