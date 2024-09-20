package com.example;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            menu();
            

            

            try {
                escolha = scanner.nextInt();
                if (escolha == 6) {
                    System.out.println("Saindo...");
                    break;
                }
                switch (escolha) {
                    case 1:
                        System.out.print("Digite o primeiro número: ");
                        double a1 = scanner.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        double b1 = scanner.nextDouble();
                        System.out.println("Resultado: " + soma(a1, b1));
                        break;

                    case 2:
                        System.out.print("Digite o primeiro número: ");
                        double a2 = scanner.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        double b2 = scanner.nextDouble();
                        System.out.println("Resultado: " + subtracao(a2, b2));
                        break;

                    case 3:
                        System.out.print("Digite o primeiro número: ");
                        double a3 = scanner.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        double b3 = scanner.nextDouble();
                        System.out.println("Resultado: " + multiplicacao(a3, b3));
                        break;

                    case 4:
                        System.out.print("Digite o primeiro número: ");
                        double a4 = scanner.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        double b4 = scanner.nextDouble();
                        System.out.println("Resultado: " + divisao(a4, b4));
                        break;

                    case 5:
                        System.out.print("Digite um número: ");
                        double a5 = scanner.nextDouble();
                        System.out.println("Resultado: " + raizQuadrada(a5));
                        break;

                    default:
                        System.out.println("Escolha inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.next(); // Limpa o scanner em caso de entrada inválida
            }
        } while (true);

        scanner.close();
    }

    public static void menu() {
        System.out.println("Calculadora:");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Raiz Quadrada");
        System.out.println("6. Sair");
        System.out.print("Escolha uma operação (1-6): ");
    }

    public static double soma(double a, double b) {
        return a + b;
    }

    public static double subtracao(double a, double b) {
        return a - b;
    }

    public static double multiplicacao(double a, double b) {
        return a * b;
    }

    public static double divisao(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Erro: Divisão por zero.");
        }
        return a / b;
    }

    public static double raizQuadrada(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Erro: Raiz quadrada de número negativo.");
        }
        return Math.sqrt(a);
    }
}
