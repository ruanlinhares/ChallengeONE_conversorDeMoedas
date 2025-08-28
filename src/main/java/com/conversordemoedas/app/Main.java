package com.conversordemoedas.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String menu1 = """
                /////////CONVERSOR DE MOEDAS/////////
                +-----------------------------------+
                | 1. Real Brasileiro                |
                | 2. Dólar Americano                |
                | 3. Yuan chinês                    |
                | 4. Peso Argentino                 |
                | 5. Libra Esterlina                |
                | 6. Franco Suíço                   |
                | 7. Sair                           |
                +-----------------------------------+
                """;

        // textblocs a apartir do java 
        String menu2 = """
                /////////CONVERSOR DE MOEDAS/////////
                +-----------------------------------+
                | 1. Converter para Dólar Americano |
                | 2. Converter para Libra Esterlina |
                | 3. Converter para Yuan  Chinês    |
                | 4. Converter para Peso Argentino  |
                | 5. Converter para Franco Suíço    |
                | 6. Converter para Real Brasileiro |
                | 7. Sair                           |
                +-----------------------------------+
                """;

        int opcMenu1, opcMenu2;
        double valueForConversion;
        String currencyInput = "", currencyConversion = "";
        String[] validValues = {"BRL", "USD", "CNY", "GBP", "CHF", "ARS"};

        

        do{

            System.out.println(menu1);

            System.out.println("Qual o tipo de moeda vai inserir?");
            opcMenu1 = scan.nextInt();

            switch (opcMenu1) {
                case 1:
                    currencyInput = "BRL";
                    break;
                case 2:
                    currencyInput = "USD";
                    break;
                case 3:
                    currencyInput = "CNY";
                    break;
                case 4:
                    currencyInput = "ARS";
                    break;
                case 5:
                    currencyInput = "GBP";
                    break;
                case 6:
                    currencyInput = "CHF";
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Tipo de moeda não válida para convesão");
                    break;
            }

            for(int i = 0; i < validValues.length; i++){
                if(currencyInput.equalsIgnoreCase(validValues[i])){

                    System.out.println("Digite um valor para converter: ");
                    valueForConversion = scan.nextDouble();

                    System.out.println(menu2);

                    System.out.println("Para qual opção deseja converter o valor? ");
                    opcMenu2 = scan.nextInt();

                    switch(opcMenu2){
                        case 1:
                            currencyConversion = "USD";
                            break;
                         case 2:
                            currencyConversion = "GBP";
                            break;
                         case 3:
                            currencyConversion = "CNY";
                            break;
                         case 4:
                            currencyConversion = "ARS";
                            break;
                         case 5:
                            currencyConversion = "CHF";
                            break;
                         case 6:
                            currencyConversion = "BRL";
                            break;
                        case 7:
                            break;
                        default:
                            System.out.println("Opção  de conversão inválida");
                            break;
                    }

                    Conversor conversor = new Conversor(valueForConversion, currencyInput, currencyConversion);


                }
            }

        }while(opcMenu1 != 7 );

        System.out.println("Programa encerrado!");
        scan.close();
    }
}
