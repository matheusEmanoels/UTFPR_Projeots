/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.servidorsocket;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author mathe
 */
public class ServidorSocket {

    /**
     * @param args the command line arguments
     */
    static private boolean testaIdade(Pessoa p) {
        System.out.println("Processing: " + p.getNome()+" age...");
        //Se a idade for maior igual a 18 recebe true, senÃ£o false
        boolean b = p.getIdade() >= 18 ? true : false;
        System.out.println("Age is 18+?: " + b);
        return b;    
    }
    public static void main(String[] args)throws IOException, ClassNotFoundException {

        //criar uma conexão com o servidor
        int porta=1286;
       
        try(ServerSocket serverSocket = new ServerSocket(porta)){
            Socket socket = serverSocket.accept();
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            
            Pessoa p = (Pessoa) is.readObject();
            boolean valor = testaIdade(p);
            //envio a resposta do teste
            os.writeObject(valor);
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
/*
        //Servidor fica "Ouvindo" uma requisição
        Socket socket = serverSocket.accept();
        
        //Envio da resposta
        OutputStream socketOutStream =  socket.getOutputStream();
        
        //Cria um "datagrama" para o envio
        DataOutputStream socketData  = new DataOutputStream(socketOutStream);
        String str = "oi!";
        
        //Envio da mensagem via socket
        socketData.writeUTF(str);
        
        //Fechar os sockets para depois abrir "a comunicação" 
        socketData.close();
        socket.close();
        serverSocket.close();
        */