/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.defaultmethoddemo;

/**
 *
 * @author hlogar
 */

// A simple program to Test Interface default 
// methods in java 
interface TestInterface 
{ 
    // abstract method 
    public void square(int a); 
  
    // default method 
    default void show() 
    { 
      System.out.println("Default Method Executed"); 
    } 
} 

class TestClass implements TestInterface 
{ 
    // implementation of square abstract method 
    public void square(int a) 
    { 
        System.out.println(a*a); 
    } 
} 

class TestClass2 implements TestInterface 
{ 
    // implementation of square abstract method 
    public void square(int a) 
    { 
        System.out.println(a*a); 
    } 
    
    public void show()
    {
        System.out.println("Method of TestClass Executed");
    }
} 

public class DefaultMethodDemo {
  
    public static void main(String args[]) 
    { 
        TestClass d = new TestClass(); 
        d.square(4); 
  
        // default method executed 
        d.show(); 
        
        TestClass2 d2 = new TestClass2(); 
        d2.square(7); 
  
        // default method executed 
        d2.show();         
    }    
}
