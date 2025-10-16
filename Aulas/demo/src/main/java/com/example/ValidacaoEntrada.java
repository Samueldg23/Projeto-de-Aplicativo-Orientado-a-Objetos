package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidacaoEntrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite um número inteiro: ");
            int numero = scanner.nextInt();
            System.out.println("Número digitado: " + numero);
        } catch (InputMismatchException e) {
            System.err.println("Erro: Valor informado não é um número inteiro válido!");
        } finally {
            scanner.close();
        }
    }
}
