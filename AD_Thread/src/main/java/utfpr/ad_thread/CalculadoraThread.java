/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.ad_thread;

/**
 *
 * @author josea
 */
public class CalculadoraThread {
    
    private int soma;
    
    public synchronized int somaArray(int[] array){
        
        soma = 0;
        
        for( int i=0; i< array.length;i++){
            soma += array[i];
            System.out.println("Executando a "+Thread.currentThread().getName()+" somando o valor "+array[i]
                        +" em um total de soma: "+soma);
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
                
        }
        
        return soma;
    }
    
}
