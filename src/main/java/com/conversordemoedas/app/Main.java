package com.conversordemoedas.app;
import com.conversordemoedas.app.Conversor;

import java.util.Scanner;

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
                | 3. Converter para Yuan            |
                | 4. Converter para Peso Argentino  |
                | 5. Converter para Franco Suíço    |
                | 6. Converter para Iene            |
                | 7. Sair                           |
                +-----------------------------------+
                """;

        //trocar nome das variaveis para ingles
        int opcMenu1, opcMenu2;
        double valueForConversion;
        String moedaInserida = "", moedaConvesao = "";
        String[] validValues = {"BRL", "USD", "CNY", "GBP", "CHF", "ARS"};

        

        do{

            System.out.println(menu1);

            System.out.println("Qual o tipo de moeda vai inserir?");
            opcMenu1 = scan.nextInt();

            switch (opcMenu1) {
                case 1:
                    moedaInserida = "BRL";
                    break;
                case 2:
                    moedaInserida = "USD";
                    break;
                case 3:
                    moedaInserida = "CNY";
                    break;
                case 4:
                    moedaInserida = "ARS";
                    break;
                case 5:
                    moedaInserida = "GBP";
                    break;
                case 6:
                    moedaInserida = "CHF";
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Tipo de moeda não válida para convesão");
                    break;
            }

            for(int i = 0; i < validValues.length; i++){
                if(moedaInserida.equalsIgnoreCase(validValues[i])){

                    System.out.println("Digite um valor para converter: ");
                    valueForConversion = scan.nextDouble();

                    System.out.println(menu2);

                    System.out.println("Para qual opção deseja converter o valor? ");
                    opcMenu2 = scan.nextInt();

                    switch(opcMenu2){
                        case 1:
                            moedaConvesao = "BRL";
                            break;
                        case 7:
                            break;
                        default:
                            System.out.println("Opção  de conversão inválida");
                            break;
                    }

                    Conversor conversor = new Conversor(valueForConversion, moedaInserida, moedaConvesao);

                    System.out.println(conversor);

                }
            }

        }while(opcMenu1 != 7 );

        System.out.println("Programa encerrado!");
        scan.close();
    }
}
