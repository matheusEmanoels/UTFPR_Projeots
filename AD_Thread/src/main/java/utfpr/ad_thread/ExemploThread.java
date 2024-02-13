/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.ad_thread;

/**
 *
 * @author josea
 */
public class ExemploThread extends Thread{

    String nome;
    int tempo;
   

    public ExemploThread(String nome, int tempo){
        this.nome = nome;
        this.tempo = tempo;
        start();
    }
    
    @Override
    public void run(){
        try{
            for(int i =0; i < 10; i++){
                System.out.println("A " + this.nome+ " está sendo executada!");
                Thread.sleep(this.tempo);
            }
            System.out.println("A "+ this.nome+ " terminou a execução!");
        }catch(InterruptedException e){
        
        }
    }
}
