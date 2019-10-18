package hlogar.htl.pos3.learningobjectivestest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hlogar
 */
public class Person {
 
    int Nr; 
    String Name;
    String PLZ;
    String Ort;
  
    public Person(int pNr, String pName, 
                              String pPLZ, String pOrt) 
    { 
        this.Nr = pNr; 
        this.Name = pName; 
        this.PLZ = pPLZ;
        this.Ort = pOrt;
    } 
  
    public String getName() {
        return this.Name;
    }
            
    public String toString() 
    { 
        return this.Nr + " " + this.Name + 
                           ", " + this.PLZ + " " + this.Ort; 
    } 

   
}
