package br.com.alura.conversorDeMoedas.classes;

import java.util.Scanner;

public class Menu {
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        API api = new API("API_KEY");

        Currency dollar = api.resquetCurrency("USD");
        Currency euro = api.resquetCurrency("EUR");
        Currency real = api.resquetCurrency("BRL");

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

            switch (controller) {
                case 1: {
                    System.out.println("Digite o valor em dólar que queira converter para real:");
                    double value = scanner.nextDouble();
                    double exchangedValue = value * dollar.conversion_rates().get("BRL");
                    System.out.println("*********************************************");
                    System.out.println("$" + value + " -> R$ " + String.format("%.2f", exchangedValue));
                    break;
                }
                case 2: {
                    System.out.println("Digite o valor em real que queira converter para dólar:");
                    double value = scanner.nextDouble();
                    double exchangedValue = value * real.conversion_rates().get("USD");
                    System.out.println("*********************************************" + '\n');
                    System.out.println("\n R$" + value + " -> $" + String.format("%.2f", exchangedValue));
                    break;
                }
                case 3: {
                    System.out.println("Digite o valor em Euro que queira converter para real:");
                    double value = scanner.nextDouble();
                    double exchangedValue = value * euro.conversion_rates().get("BRL");
                    System.out.println("*********************************************");
                    System.out.println("€" + value + " -> R$ " + String.format("%.2f", exchangedValue));
                    break;
                }
                case 4: {
                    System.out.println("Digite o valor em real que queira converter para euro:");
                    double value = scanner.nextDouble();
                    double exchangedValue = value * real.conversion_rates().get("EUR");
                    System.out.println("*********************************************");
                    System.out.println("R$" + value + " -> € " + String.format("%.2f", exchangedValue));
                    break;
                }
                case 5: {
                    System.out.println("Digite o valor em dólar que queira converter para euro:");
                    double value = scanner.nextDouble();
                    double exchangedValue = value * dollar.conversion_rates().get("EUR");
                    System.out.println("*********************************************");
                    System.out.println("$" + value + " -> € " + String.format("%.2f", exchangedValue));
                    break;
                }
                case 6: {
                    System.out.println("Digite o valor em euro que queira converter para dólar:");
                    double value = scanner.nextDouble();
                    double exchangedValue = value * euro.conversion_rates().get("USD");
                    System.out.println("*********************************************");
                    System.out.println("€" + value + " -> $ " + String.format("%.2f", exchangedValue));
                    break;
                }
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
