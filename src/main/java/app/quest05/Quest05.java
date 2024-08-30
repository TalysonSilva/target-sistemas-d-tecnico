package app.quest05;

import java.util.Scanner;

/*
 Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência
ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;
 */
public class Quest05 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.println("Digite uma palavra");

        String texto = scanner.nextLine();

        scanner.close();

        String palavraInvertida = "";

        //Verificar se o String está vazio
        if (!texto.isEmpty()) {

            for (int i = texto.length()-1; i>=0; i--){
                palavraInvertida += texto.charAt(i);
            }

            System.out.printf("Texto escolhida: %s \n", texto);
            System.out.printf("Texto após inverter: %s\n", palavraInvertida);

        }else{
            System.out.println("Texto não encontrado");
        }
    }
}
