/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utfpr.ad_thread;

/**
 *
 * @author josea
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       // ExemploThread t1 = new ExemploThread("Thread Alberto",100);
       // ExemploThread t2 = new ExemploThread("Thread Mauricio",200);
        
       // ExemploRunnable r1 = new ExemploRunnable("Thread Alberto",100);
       // ExemploRunnable r2 = new ExemploThread("Thread Mauricio",200);
                
        //ExemploRunnable r1 = new ExemploRunnable("Thread Jorge");
       // ExemploRunnable r2 = new ExemploRunnable("Thread Gustavo");
       // ExemploRunnable r3 = new ExemploRunnable("Thread Rogerio");
        
       // Thread t1 = new Thread(r1);
      //  Thread t2 = new Thread(r2);
      //  Thread t3 = new Thread(r3);
        
        //t1.start();
       // t2.start();
      // t3.start();
        
       //t1.join();
      //  t2.join();
      //  t3.join();
        
       // t1.setPriority(t1.MAX_PRIORITY);
        //t2.setPriority(t2.NORM_PRIORITY);
        //t3.setPriority(t3.MIN_PRIORITY);
      //  t1.setPriority(1);
     //   t2.setPriority(5);
       // t3.setPriority(10);
       
       int[] array = {1,2,3,4,5};
        ExemploRunnable r1 = new ExemploRunnable("#1",array);
        ExemploRunnable r2 = new ExemploRunnable("#2",array);
    
}

}
