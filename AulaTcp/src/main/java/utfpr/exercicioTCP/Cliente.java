
package utfpr.exercicioTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String nome;
        double peso;
        double altura;
        int idade;
        //Estabelecendo uma conexão com o servidor na porta 8080
        Socket socket = new Socket("127.0.0.1",8080);
        
        //Definir os Stream de saida dos dados
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        Pessoa pessoa = new Pessoa();
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe seu nome: ");
        nome = scan.next();
        pessoa.setNome(nome);
        
        scan.nextLine();
        
        System.out.println("Informe sua idade: ");
        idade = scan.nextInt();
        pessoa.setIdade(idade);
        
        scan.nextLine();
        
        System.out.println("Informe sua altura(ex:. 1,80): ");
        altura = scan.nextDouble();
        pessoa.setAltura(altura);
        
        scan.nextLine();
        
        System.out.println("Informe seu peso(ex:. 60,0): ");
        peso = scan.nextDouble();
        pessoa.setPeso(peso);
        
        scan.nextLine();
        
        pessoa.setImc(0);
        
        //Envia mensagem para o servidor usando o writeUTF
        saida.writeObject(pessoa);
        
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        pessoa = (Pessoa) entrada.readObject();
        
        System.out.println("Olá " + pessoa.getNome()+ " seu IMC é: " + pessoa.getImc());
        
//        System.out.println(mensagem);
        
        entrada.close();
        saida.close();
        socket.close();
    }
    
}
