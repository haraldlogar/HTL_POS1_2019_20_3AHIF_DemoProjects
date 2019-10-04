/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.musternumbertester;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hlogar
 */
public class NumberTester {

    private String fileName;
    private NumberTest OddEvenTester;
    private NumberTest PrimeTester;
    private NumberTest PalindromeTester;
    private NumberTest PerfectTester;
    private FriendlyNumberTest FriendlyTester;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.OddEvenTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.PrimeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.PalindromeTester = palindromeTester;
    }

    public void setPerfectTester(NumberTest perfectTester) {
        this.PerfectTester = perfectTester;
    }    
    
    public void setFriendlyTest(FriendlyNumberTest FriendlyTester) {
        this.FriendlyTester = FriendlyTester;
    }      

    public void testFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            // erste Zeile beinhaltet die Anzahl der Tests
            String line = br.readLine();
            Integer testAnzahl =  Integer.parseInt(line);
            
            // lies nächste Zeile
            line = br.readLine();
            
            while (line != null && testAnzahl > 0) {
                String[] lineArray = line.split(" ");
                if (lineArray.length <= 1) {
                    throw new Exception("Angabe des Tests fehlerhaft");
                }
                
                int choose = Integer.parseInt(lineArray[0]);
                int testValue = Integer.parseInt(lineArray[1]);

                switch (choose) {
                    case 1:
                        if (this.OddEvenTester != null) {
                            if (this.OddEvenTester.testNumber(testValue)) {
                                System.out.println("EVEN");
                            } else {
                                System.out.println("ODD");
                            }
                        } else {
                            System.out.println("OddEvenTester not initialized");
                        }
                        break;
                    case 2:
                        if (this.PrimeTester != null) {
                            if (this.PrimeTester.testNumber(testValue)) {
                                System.out.println("PRIME");
                            } else {
                                System.out.println("NOT PRIME");
                            }
                        } else {
                            System.out.println("PrimeTester not initialized");
                        }                            
                        break;
                    case 3:
                        if (this.PalindromeTester != null) {
                            if (this.PalindromeTester.testNumber(testValue)) {
                                System.out.println("PALINDROME");
                            } else {
                                System.out.println("NO PALINDROME");
                            }
                        } else {
                            System.out.println("PalindromeTester not initialized");
                        }                              
                        break;
                    case 4:
                        if (this.PerfectTester != null) {
                            if (this.PerfectTester.testNumber(testValue)) {
                                System.out.println("PERFECT");
                            } else  {
                                System.out.println("NOT PERFECT");
                            }
                        } else {
                            System.out.println("PerfectTester not initialized");
                        }                              
                        break;
                    case 5:
                        if (this.FriendlyTester != null) {
                            if (lineArray.length <=2) {
                                throw new Exception("Angabe des Friendly-Tests fehlerhaft");
                            }
                            // ermittle den zweiten Test-Wert
                            int testValue2 = Integer.parseInt(lineArray[2]);
                            if (this.FriendlyTester.testNumber(testValue, testValue2)) {
                                System.out.println("FRIENDLY");
                            } else {
                                System.out.println("NOT FRIENDLY");
                            }
                        } else {
                            System.out.println("FriendlyTester not initialized");
                        }                              

                }

                line = br.readLine();
                
                testAnzahl = testAnzahl - 1;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
