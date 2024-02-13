
package br.edu.utfpr.aulachatTcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;


class GerenciadorCliente implements Runnable{
    private Socket socket;
    
    /**
     * Criamos um array para cada instancia dessa classe,
     * o objetivo desse array é ficar de olho em cada cliente,
     * para quando um cliente mandar uma mensagem possamos percorrer o array e mandar
     * a mensagem para todos os outros clientes
     */
    public static  ArrayList<GerenciadorCliente> clientes = new ArrayList<>();
    
    //Buffer entrada e saida
    private BufferedReader receber;
    private BufferedWriter enviar;
    
    private String username;

    public GerenciadorCliente(Socket socket) {
        try{
            this.socket = socket;
            //Stream e buffer para leitura e escrita na rede
            this.receber = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.enviar = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //Ao atribuir um valor para a String username, ela sera lida pelo buffer
            this.username =  receber.readLine();
            clientes.add(this);
        }catch(IOException e){
            fechaTudo(socket, receber, enviar);
        }
    }

    @Override
    public void run() {
        /**
         * Toda vez que estamos ouvindo alguma mensagem nosso programa
         * bloqueia o restante do codigo, porém precisamos ser capaz
         * de continuar e enviar mensagem e ainda assim ficar ouvindo
         * para isso precimaos trabalhar com THREADS, do qual são capazes
         * de executar o nosso codigo em blocos
         */
        String msg;
        while(socket.isConnected()){
            try{
                msg = receber.readLine();
                transmitir(msg);
            }catch(IOException e){
                fechaTudo(socket, receber, enviar);
            }
        }
    }

    private void transmitir(String msg) {
        //Para cada cliente no loop do while no metodo RUN cria-se uma interação
        for(GerenciadorCliente cliente : clientes){
            try{
                if(!cliente.username.equals(username)){
                    cliente.enviar.write(msg);
                    cliente.enviar.newLine();// NewLine serve para que quando o cliente aperta enter a mensagem foi finalizada
                                            //Dessa forma o buffer se adapta ao tamanho da mensageme  nao fica sobrecarregado
                                            //E depois de enviado se esvazia automaticamente
                    cliente.enviar.flush();
                }
            }catch(IOException e){
                fechaTudo(socket, receber, enviar);
            }
        }
    }
    
    public void removerCliente(){
        clientes.remove(this);
        transmitir("SERVIDOR: " +username+ " saiu do chat!");
    }
    
    public void fechaTudo(Socket socket, BufferedReader receber, BufferedWriter enviar){
        try{
            if(socket != null){
                socket.close();
            }
            if(enviar != null){
                enviar.close();
            }
            if(receber != null){
                receber.close();
            }
        }catch(IOException e){
            
        }
    }
    
}
