package br.edu.univas;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Calculator {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        double result = 0;
        int quant;
        boolean again = false;

        do {
            TimeUnit.MILLISECONDS.sleep(1500);

            buildOperationMenu();
            int operation = scan.nextInt();

            if (operation > 0 && operation < 5) {
                System.out.print("\nDigite a quantidade de números envolvidos na operação: ");
                quant = scan.nextInt();
            } else {
                quant = 0;
            }

            switch (operation) {
                case 1 -> result = calcSum(result, quant, scan);
                case 2 -> result = calcSub(result, quant, scan);
                case 3 -> result = calcDiv(result, quant, scan);
                case 4 -> result = calcMul(result, quant, scan);
                default -> System.out.println("\nOpção inválida!");
            }

            System.out.print("\nO resultado da operação é: " + result);

            TimeUnit.MILLISECONDS.sleep(1500);

            buildOptionMenu();
            int option = scan.nextInt();

            switch (option) {
                case 1 -> {
                    again = true;
                    result = 0;
                }
                case 2 -> again = true;
                case 3 -> {
                    again = false;
                    System.out.println("\nAdeus!");
                }
                default -> System.out.println("\nOpção inválida!");
            }

        } while (again);

    }

    public static void buildOperationMenu() {
        System.out.println("\nDigite a operação desejada:");
        System.out.println("1 - Adição\n2 - Subtração\n3 - Divisão\n4 - Multiplicação\n");
        System.out.print("Digite: ");
    }

    public static void buildOptionMenu() {
        System.out.println("\n\nDigite a opção desejada:");
        System.out.println("1 - Realizar outro cálculo\n2 - Continuar o cálculo atual\n3 - Sair");
        System.out.print("Digite: ");
    }

    public static double calcSum(double value, int quant, Scanner scan) {
        for (int i = 0; i < quant; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            value += scan.nextDouble();
        }

        return value;
    }

    public static double calcSub(double value, int quant, Scanner scan) {
        for (int i = 0; i < quant; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            if (i == 0 && value == 0) {
                value = scan.nextDouble();
            } else {
                value -= scan.nextDouble();
            }
        }

        return value;
    }

    public static double calcDiv(double value, int quant, Scanner scan) {
        for (int i = 0; i < quant; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            if (i == 0 && value == 0) {
                value = scan.nextDouble();
            } else {
                value /= scan.nextDouble();
            }
        }

        return value;
    }

    public static double calcMul(double value, int quant, Scanner scan) {
        for (int i = 0; i < quant; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            if (i == 0 && value == 0) {
                value = scan.nextDouble();
            } else {
                value *= scan.nextDouble();
            }
        }

        return value;
    }

}