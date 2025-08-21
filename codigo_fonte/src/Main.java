import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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

        double moeda;
        String tipoMoeda;

        System.out.println(menu);

        System.out.println("Digite um valor para converter: ");
        moeda = scan.nextDouble();
        System.out.println("Qual moeda está inserindo: ");
        tipoMoeda = scan.next();

        Conversor conversor = new Conversor(moeda, tipoMoeda);

        System.out.println(conversor.getValueToConvert());
        System.out.println(conversor.getCoinForConversion());

        scan.close();
    }
}
