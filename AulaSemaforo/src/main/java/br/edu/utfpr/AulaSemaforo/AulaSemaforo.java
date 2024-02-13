package br.edu.utfpr.AulaSemaforo;

import java.util.LinkedList;
import java.util.Queue;

public class AulaSemaforo {

    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo();
        
        Carro carro1 = new Carro(1.0, "Fusca");
        Carro carro2 = new Carro(1.0, "Fiat Uno");
        Carro carro3 = new Carro(1.2, "C3");
        Carro carro4 = new Carro(1.8, "Triton");
        Carro carro5 = new Carro(1.0, "Palio");
        Carro carro6 = new Carro(1.4, "Onix");
        Carro carro7 = new Carro(1.6, "Gol");
        Carro carro8 = new Carro(1.6, "Polo");
        Carro carro9 = new Carro(1.6, "Punto");
        Carro carro10 = new Carro(1.0, "Fusca");
        Carro carro11 = new Carro(2.0, "Cruze");
        Carro carro12 = new Carro(1.8, "Fusca");
        
        
        Queue<Carro> carros = new LinkedList<>();
        carros.add(carro1);
        carros.add(carro2);
        carros.add(carro3);
        carros.add(carro4);
        carros.add(carro5);
        carros.add(carro6);
        carros.add(carro7);
        carros.add(carro8);
        carros.add(carro9);
        carros.add(carro10);
        carros.add(carro11);
        carros.add(carro12);
        
        for(int i = 0; i < 12; i++){
            System.out.println("O sinal esta: " + semaforo.getSinal());
           
            while(semaforo.getSinal().equals("verde")){
                if(!carros.isEmpty()){
                    semaforo.verificaMotor(carros.element().getMotor());
                    System.out.println("O " + carros.poll().getModelo() + " saiu!");
                }
                else{
                    break;
                }
            }
            semaforo.esperarSinal();
        }
        semaforo.fechaSemaforo();
        
//        for(int i = 0; i < carros.size(); i++){
//            System.out.println("O sinal esta: " + semaforo.getSinal());
//                while(semaforo.getSinal().equals("verde")){
//                   semaforo.verificaMotor(carros.element().getMotor());
//                    System.out.println("O " + carros.poll() + " saiu!");
//                }
//            }
//        }
        
    }
}
