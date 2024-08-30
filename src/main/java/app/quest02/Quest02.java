package app.quest02;

import java.util.Scanner;
/*
Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos
2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na
linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma
mensagem avisando se o número informado pertence ou não a sequência.

IMPORTANTE: Esse número pode ser informado através de qualquer entrada
de sua preferência ou pode ser previamente definido no código;

 */
public class Quest02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();

        scanner.close();

        if (isFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }

    }

    // Método para verificar se um número pertence à sequência de Fibonacci
    public static boolean isFibonacci(int numero) {

        if (numero == 0 || numero == 1) {
            return true;
        }

        int primeiroNumero = 0;
        int secundoNumero = 1;

        while (secundoNumero < numero) {
            int soma = primeiroNumero + secundoNumero;
            primeiroNumero = secundoNumero;
            secundoNumero = soma;
        }

        return secundoNumero == numero;
    }
}

