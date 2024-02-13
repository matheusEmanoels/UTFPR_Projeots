
package utfpr.exercicioTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

   
    public static void main(String[] args) throws IOException, ClassNotFoundException{
       //Definir o serverSocket (porta de conexão)
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("O servidor esta ouvindo na porta 8080");
        
        //Abrir comunicação
        Socket socket = serverSocket.accept();
        
        //Mostrar o IP do cliente que vai estar conectado
        System.out.println("Um cliente se conectou: "+ socket.getInetAddress().getHostAddress());
        
        //Definir um stream de entrada
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        
        //Converte os a mensagem que esta vindo do cliente em Bytes para String
        Pessoa pessoa = (Pessoa) entrada.readObject();
        
        pessoa.setImc(pessoa.getPeso()/(pessoa.getAltura() * pessoa.getAltura()));
        
        
        //Defini um stream de saida para o servidor para conversar
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeObject(pessoa);
        
        saida.close();
        entrada.close();
        socket.close();
    }
    
}
