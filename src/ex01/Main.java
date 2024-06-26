package ex01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("digite o numerador: ");
        int n1 = sc.nextInt();
        System.out.println("Digite o divisor: ");
        int n2 = sc.nextInt();

        try {
            System.out.println("O resultado da divisão é: " + (n1 / n2));
        } catch (ArithmeticException mensagem){
            System.out.println("Erro! Denominador não pode ser zero!");
        }

    }
}