
package br.edu.utfpr.aulachatTcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {
    private ServerSocket socket;

    public Servidor(ServerSocket socket)  {
        this.socket = socket;
    }

    public void iniciarSessao() throws IOException{
        while(!socket.isClosed()){
            /**Nesse ponto o servidor aguarda coneção
             Quando um cliente se conecta retorna .accept retorna um socket*/
            
            //Cliente usa o Objeto conecao para se conectar
            Socket conecao = socket.accept();
            System.out.println("Um cliente se conectou");
            
            GerenciadorCliente gc = new GerenciadorCliente(conecao);
            
            /**
             * Uma thread pode receber um objeto que contenha a interface
             * Runnable, a thread ficara responsavel por rodar essa instancia
             * de forma separada e independente do resto do codigo
             */
            Thread t = new Thread(gc);
            t.start();
        }//Fim do while
    }//Fim iniciar sessão
    
    public void fecharSessao() throws IOException{
        if(socket != null){
            socket.close();
        }
    }
    
    public static void main(String[] args) throws IOException{
        ServerSocket socket = new ServerSocket(8080);// Seta a porta 
        Servidor servidor = new Servidor(socket);// Instancio um objeto
        System.out.println("Servidor subiu");
        servidor.iniciarSessao();// chamo o metodo de iniciar sessao
    }
    
}
