package com;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // textblocs a apartir do java 
        String menu = """
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

        //int opc;
        double moeda;
        String tipoMoeda = "BRL";

        //do{
            // System.out.println(menu);

            // System.out.println("Qual opção deseja converter? ");
            // opc = scan.nextInt();

            System.out.println("Digite um valor para converter: ");
            moeda = scan.nextDouble();
            
            // switch(opc){
            //     case 1:
            //         tipoMoeda = "BRL";
            //         break;
            //     case 7:
            //         break;
            //     default:
            //         System.out.println("Opção  de conversão inválida");
            //         break;
            // }

            Conversor conversor = new Conversor(moeda, tipoMoeda);

            System.out.println(conversor);

        //}while(opc != 7);

        System.out.println("Programa encerrado!");
        scan.close();
    }
}
