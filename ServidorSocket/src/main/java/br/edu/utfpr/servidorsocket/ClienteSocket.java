/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.servidorsocket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ClienteSocket {

    public static void main(String[] args)throws IOException{
        int porta =1286;
        
        Pessoa pessoa = new Pessoa("Matheus",21);
        
        
        //cria socket de pergunta
        try{
            Socket socket = new Socket("localhost",porta);
            
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(pessoa);
            
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            
            boolean resposta = (boolean)is.readBoolean();
            
            
            
          
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
        //envio da pergunta(requisição)
       
        
       
        
        
        //Recebo a requisão

        
        //fecho conexão
        
        
    }
    
}
