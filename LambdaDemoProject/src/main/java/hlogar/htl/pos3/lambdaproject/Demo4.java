/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

public class Demo4 {

    interface MyString {

        String myStringFunction(String str);
    }

    public static String reverseStr(MyString reverse, String str) {
        return reverse.myStringFunction(str);
    }

    public static void main(String args[]) {
// Block lambda to reverse string
        MyString reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
// Output: omeD adbmaL
        System.out.println(reverseStr(reverse, "Lambda Demo"));
    }
}
