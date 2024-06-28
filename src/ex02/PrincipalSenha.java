package ex02;

import java.util.Scanner;



public class PrincipalSenha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite sua senha: ");
        String senha = sc.next();

        try {
            ValidarSenha.validarSenha(senha);
            System.out.println("Senha correta!");

        }catch (SenhaInvalida e){
            System.out.println("Erro: " + e.getMessage());
        }

    }



}
