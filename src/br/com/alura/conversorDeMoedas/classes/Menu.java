package br.com.alura.conversorDeMoedas.classes;

import java.util.Scanner;

public class Menu {
    public  static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        Exchanger exchanger = new Exchanger("c5c4cb2086e7d90a897300f7");

        int controller = 0;

        while (controller != 7) {
            System.out.println("************ CONVERSOR DE MOEDAS ************" + '\n');
            System.out.println("1) Dólar -> Real");
            System.out.println("2) Real -> Dólar");
            System.out.println("3) Euro -> Real");
            System.out.println("4) Real -> Euro");
            System.out.println("5) Dólar -> Euro");
            System.out.println("6) Euro -> Dólar");
            System.out.println("7) Sair");

            controller = scanner.nextInt();
            double inputVale;

            switch (controller) {
                case 1: {
                    System.out.println("Digite o valor em dólar que queira converter em real: ");
                    inputVale = scanner.nextDouble();
                    exchanger.exchange("USD", "BRL", inputVale);
                    break;
                }
                case 2: {
                    System.out.println("Digite o valor em real que queira converter em dólar: ");
                    inputVale = scanner.nextDouble();
                    exchanger.exchange("BRL", "USD", inputVale);
                    break;
                }
                case 3: {
                    System.out.println("Digite o valor em euro que queira converter em real: ");
                    inputVale = scanner.nextDouble();
                    exchanger.exchange("EUR", "BRL", inputVale);
                    break;
                }
                case 4: {
                    System.out.println("Digite o valor em real que queira converter em euro: ");
                    inputVale = scanner.nextDouble();
                    exchanger.exchange("BRL", "EUR", inputVale);
                    break;
                }
                case 5: {
                    System.out.println("Digite o valor em dólar que queira converter em euro: ");
                    inputVale = scanner.nextDouble();
                    exchanger.exchange("USD", "EUR", inputVale);
                    break;
                }
                case 6: {
                    System.out.println("Digite o valor em euro que queira converter em dólar: ");
                    inputVale = scanner.nextDouble();
                    exchanger.exchange("EUR", "USD", inputVale);
                    break;
                }
                case 7: {
                    break;
                }

                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
