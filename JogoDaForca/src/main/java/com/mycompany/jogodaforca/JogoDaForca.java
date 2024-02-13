/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jogodaforca;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author mathe
 */

public class JogoDaForca {
    static Scanner scanner = new Scanner(System.in);
 
    static String[] palavrasFaceis = {"AZUL", "PAI", "OVO", "TESTE", "HORA", "MACA", "AULA", "MAGIA"};
    static String[] palavrasMedias = {"LIMONADA", "BASQUETE", "ESQUERDO", "CHICLETE"};
    static String[] palavrasDificeis = {"OFTAMOLOGISTA", "INDEPENDENCIA", "AMPULHETEIRO"};
    
    public static int MenuDificuldade(){
        System.out.println("1 - Facil\n"
                        + "2 - Medio\n" 
                        + "3 - Dificil\n"
                        + "4 - SAIR");
        
        System.out.print("Informa a dificuldade: ");
        int op = scanner.nextInt();
        
        return op;
    }
    
    public static void main(String[] args) {
        //Map<String, String> mapaFaceis = Map.of("AZUL","COR", "PAI", "FAMILIAR", "OVO", "ALIMENTO", "TESTE", "TESTE");
        
        while(true)
        {
            ArrayList<Character> letrasInformadas = new ArrayList<>();
            ArrayList<Character> letrasCorretas = new ArrayList<>();
            int tentativasMaximas = 3;
            int tentativas = 0;
            Random random = new Random();
            
            //mapaFaceis.
            
            String palavraEscolhida = "";
            int index = 0;

            int op = MenuDificuldade();

            
            switch (op) {
                case 1:
                    palavraEscolhida = palavrasFaceis[random.nextInt(palavrasFaceis.length)];
                    break;
                case 2:
                    palavraEscolhida = palavrasMedias[random.nextInt(palavrasMedias.length)];
                    break;
                case 3:
                    palavraEscolhida = palavrasDificeis[random.nextInt(palavrasDificeis.length)];
                    break;
                case 4:
                    System.out.println("Você esta saindo do jogo");
                    exit(0);
                    break;
                default:
                    System.out.println("Informe um dificuldade valida!\n");    
                    op = MenuDificuldade();
            }
            
            while (tentativas <= tentativasMaximas) {
                System.out.print("\nLetras informadas: ");
                for(int i=0; i < letrasInformadas.size(); i++){
                    System.out.print(letrasInformadas.get(i) + " ");
                }
                
                System.out.print("\nDigite uma letra: ");
                char letraAdivinhada = scanner.next().toUpperCase().charAt(0);
                letrasInformadas.add(letraAdivinhada);
                
                for (char letra : palavraEscolhida.toCharArray()) {
                    if(letra == letraAdivinhada){
                        letrasCorretas.add(letraAdivinhada);
                        index++;
                    }
                    
                    if (letrasCorretas.contains(letra)) {
                        System.out.print(letra);
                    } else {
                        System.out.print("_ ");
                    }
                }
                if (letrasCorretas.size() == palavraEscolhida.length()) {
                    System.out.println("\nParabéns, você venceu!");
                    System.out.println("Para continuar jogando tecle 0!!");
                    int nextGame = scanner.nextInt();
                    if(nextGame != 0){
                        System.out.println("Você esta saindo");
                        exit(0);
                    } else {
                        break;
                    }
                } else if (tentativas == tentativasMaximas) {
                    System.out.println("\nVocê perdeu! A palavra era: " + palavraEscolhida);
                    System.out.println("Para continuar jogando tecle 0!!");
                    int nextGame = scanner.nextInt();
                    if(nextGame != 0){
                        System.out.println("Você esta saindo");
                        exit(0);
                    } else {
                        break;
                    }
                }
                tentativas++;
            }
        }
    }
}
