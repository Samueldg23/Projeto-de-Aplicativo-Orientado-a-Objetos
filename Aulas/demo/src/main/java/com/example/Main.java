package com.example;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console con = System.console();
        System.out.println("Digite um número:");
        Integer n1 = Integer.parseInt(con.readLine());
        System.out.println("Digite outro número:5");
        Integer n2 = Integer.parseInt(con.readLine());
        System.out.println("A soma é: " + (n1 + n2));
        try{
            System.out.println("A divisão é: " + (n1 / n2));
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero não é permitida." + e.getMessage());
        }
    }
}