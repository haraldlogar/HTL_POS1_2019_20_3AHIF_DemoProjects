/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

/**
 *
 * @author hlogar
 */
public class Person {
 
    int Nr; 
    String Name;
    String Strasse; 
    String PLZ;
    String Ort;
  
    public Person(int pNr, String pName, 
                               String pStrasse, String pPLZ, String pOrt) 
    { 
        this.Nr = pNr; 
        this.Name = pName; 
        this.Strasse = pStrasse; 
        this.PLZ = pPLZ;
        this.Ort = pOrt;
    } 
  
    public String toString() 
    { 
        return this.Nr + " " + this.Name + 
                           " " + this.Strasse + ", " + this.PLZ + " " + this.Ort; 
    } 
}
