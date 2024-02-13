
package br.edu.utfpr.aulachatTcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {
    private BufferedReader receber;
    private BufferedWriter enviar;

    private String username;
    private Socket socket;

    public Cliente(String username, Socket socket) {
        try{
            this.username = username;
            this.socket = socket;
            this.receber = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.enviar = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch(IOException e){
            fechaTudo(socket, receber, enviar);
        }

    }
    
    /**
     * Esse metodo envia mensagem para o gerenciador de clientes
     * que ira destribuir a mensagem para os outros clientes
     */
    public void enviarMsg(){
        try{
            enviar.write(username);
            enviar.newLine();
            enviar.flush();
            Scanner scan = new Scanner(System.in);
            while(socket.isConnected()){
                String msg = scan.nextLine();
                enviar.write(username+": "+msg);
                enviar.newLine();
                enviar.flush();
            }
        }catch(IOException e){
            fechaTudo(socket, receber, enviar);
        }
    }
    
    
    public void receberMsg(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgDoChat;
                while(socket.isConnected()){
                    try{
                        msgDoChat = receber.readLine();
                        System.out.println(msgDoChat);
                    }catch(IOException e){
                        fechaTudo(socket, receber, enviar);
                    }
                }
            }
        }).start();
    }
    
    
    public void fechaTudo(Socket socket, BufferedReader receber, BufferedWriter enviar) {
        try {
            if (socket != null) {
                socket.close();
            }
            if (enviar != null) {
                enviar.close();
            }
            if (receber != null) {
                receber.close();
            }
        } catch (IOException e) {

        }
    }
    
    
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu nome de usuario:");
        String username = scan.nextLine();
        Socket socket = new Socket("localhost",8080);
        Cliente cliente = new Cliente(username, socket);
        
        cliente.receberMsg();// Bloco com thread, sempre ira executar a par do resto do codigo
        cliente.enviarMsg();
    }
}
