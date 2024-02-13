
package br.edu.utfpr.AulaSemaforo;


public class Semaforo implements Runnable{
    private String sinal;
    private boolean trocou;
    private boolean inativo;

    public Semaforo() {
        this.sinal = "verde";
        this.trocou = false;
        this.inativo = false;
        new Thread(this).start();
    }
    
    
    
    @Override
    public void run() {
        while(!inativo){
            try{
                switch (this.sinal) {
                    case "verde":
                        Thread.sleep(4100);
                        break;
                    case "vermelho":
                        Thread.sleep(3000);
                        break;

                }
                this.liberarSemaforo();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    /**
     * Metodos 
     */
    
    private synchronized void liberarSemaforo() {
        switch (this.sinal) {
            case "verde":
                this.sinal = "vermelho";
                break;
            case "vermelho":
                this.sinal = "verde";
                break;
        }
        
        this.trocou = true;
        notify();
    }
    
    public synchronized void esperarSinal(){
        while(!this.trocou){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.trocou = false;
    }
    
    public synchronized void fechaSemaforo(){
        this.inativo = true;
    }
    
    public void verificaMotor(Double motor){
        try {
            if(motor == 1.0)
                Thread.sleep(2000);
            if(motor == 1.2)
                Thread.sleep(1800);
            if(motor == 1.4)
                Thread.sleep(1600);
            if(motor == 1.6)
                Thread.sleep(1400);
            if(motor == 1.8)
                Thread.sleep(1200);
            if(motor == 2.0)
                Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
    
    /**
     * Getters e Setters
    */
    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    public boolean isTrocou() {
        return trocou;
    }

    public void setTrocou(boolean trocou) {
        this.trocou = trocou;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }
}
