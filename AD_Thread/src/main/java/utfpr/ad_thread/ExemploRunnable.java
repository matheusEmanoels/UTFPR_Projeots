/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.ad_thread;

/**
 *
 * @author josea
 */
public class ExemploRunnable implements Runnable{
    private static CalculadoraThread calc = new CalculadoraThread();
    private String nome;
    private int[] nums;
    
    @Override
    public void run() {
        System.out.println(this.nome + " iniciou ");
        int soma = calc.somaArray(this.nums);
        System.out.println("Resultado da soma da Tread "+this.nome+": "+soma);
        System.out.println("Thread encerrada!");
        
    }

    public ExemploRunnable(String nome, int[] nums) {
        this.nome = nome;
        this.nums = nums;
        new Thread(this,nome).start();
        
    
    }
    
    
    
}
