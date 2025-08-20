import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Conversor conversor = new Conversor();
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
        System.out.println(menu);
        System.out.println("Digite um valor:");




        scan.close();
    }
}
