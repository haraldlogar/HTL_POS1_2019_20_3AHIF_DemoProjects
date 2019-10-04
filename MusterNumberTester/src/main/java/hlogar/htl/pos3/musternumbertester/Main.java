/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.musternumbertester;

/**
 *
 * @author hlogar
 */
public class Main {
    private static int getTeilerSumme (int a) {
        int sum = 0;
        for(int i = 1 ; i < a ; i++) {
                if(a % i == 0)  {
                        sum = sum + i;
                }
        }               
        return sum;
    }
    
    public static void main(String args[]) {
        NumberTester nt = new NumberTester("Testfile.txt");
        
        nt.setOddEvenTester(n -> n % 2 == 0);
        
        nt.setPrimeTester((a) ->{
                int sqrt = (int) Math.sqrt(a) + 1;
                for (int i = 2; i < sqrt; i++) {
                    if (a % i == 0) {
                        // number is perfectly divisible - no prime
                        return false;
                    }
                }
                return true;
        });
        
        nt.setPalindromeTester((a) -> {
                String clean = Integer.toString(a).replaceAll("\\s+", "").toLowerCase();
                int length = clean.length();
                int forward = 0;
                int backward = length - 1;
                while (backward > forward) {
                    char forwardChar = clean.charAt(forward++);
                    char backwardChar = clean.charAt(backward--);
                    if (forwardChar != backwardChar)
                        return false;
                }
                return true;
        });   
        
        nt.setPerfectTester((n) -> (n == getTeilerSumme(n)));
        
        nt.setFriendlyTest((a,b) -> (getTeilerSumme(a) == b && getTeilerSumme(b) == a));
        
        nt.testFile();
    }
}
