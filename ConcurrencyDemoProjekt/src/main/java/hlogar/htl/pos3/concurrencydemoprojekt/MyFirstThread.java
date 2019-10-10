/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.concurrencydemoprojekt;

/**
 *
 * @author hlogar
 */
public class MyFirstThread extends Thread {

    public void hello(String s) {
        System.out.println(s);
    }

    public void run() {
        hello("Im running");
    } // end of run()

    public static void main(String[] args) {
        MyFirstThread t = new MyFirstThread();
        t.start();
        System.out.println("Thread has been started ...");
    } // end of main()
} // end of class MyFirstThread

