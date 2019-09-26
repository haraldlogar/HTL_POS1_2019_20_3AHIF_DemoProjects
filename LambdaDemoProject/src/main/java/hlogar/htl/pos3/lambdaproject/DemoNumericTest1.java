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
public class DemoNumericTest1 {
    
    interface NumericTest {

        boolean computeTest(int n);
    }

    class IsEven implements NumericTest {

        @Override
        public boolean computeTest(int n) {
            return (n % 2) == 0;
        }
    }

    class IsNegative implements NumericTest {

        @Override
        public boolean computeTest(int n) {
            return n < 0;
        }
    }
    
    public void doDemoWork() {
        NumericTest isEven = new IsEven();
        NumericTest isNegative = new IsNegative();
        
        // Output: false
        System.out.println(isEven.computeTest(5));
        
        // Output: true
        System.out.println(isNegative.computeTest(-5));
    }
    
    public static void main(String args[]) {   
        DemoNumericTest1 demo = new DemoNumericTest1();
        demo.doDemoWork();
    }    
}
