package com.conversordemoedas.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.google.gson.Gson;

//possibilidade de usar uma record class
public class Conversor {
    private final double valueToConvert;
    private final String currencyInput, currencyConversion;

    public double getValueToConvert(){return this.valueToConvert;}
    public String getCurrencyInput() {return this.currencyInput;}
    public String getCurrencyConversion(){return this.currencyConversion;}


    public Conversor(double valueToConvert, String currencyInput, String currencyConversion){
        this.valueToConvert = valueToConvert;
        this.currencyInput = currencyInput;
        this.currencyConversion = currencyConversion;
    }

    public double dataProcessing(double valueToConvert, String currencyInput, String currencyConversion){

        double convertedValue = 0;

        // criando um enviador da requisicao (o cliente)
        HttpClient client = HttpClient.newHttpClient();

        // criando uma requisicao do tipo get
        HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("https://v6.exchangerate-api.com/v6/148aecca3bcf9872738966ff/latest/" + currencyInput))
                            //tipo da requisicao (poderia ser update,delete,post)
                            .GET()
                            .build();

        try{
                        
            // armazenando a resposta enviada pelo cliente
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        
            if(response.statusCode() == 200){
                //instanciando um objeto gson para realizar uma coversão do JSON
                Gson gson = new Gson();

                // converte o corpo da resposta para um objeto ApiResponse e ela mapeia automaticamente os valores do campo conversion_rates
                ApiResponse taxasResponse = gson.fromJson(response.body(), ApiResponse.class);

                //armazenando o Map de taxas de cambio extraído de ApiResponse
                Map<String, Double> taxas = taxasResponse.getConversionRates();


                //iterando sobre as chaves:valores:
                for(Map.Entry<String,Double> taxa : taxas.entrySet()){

                    //verificando se a moeda corrente para conversão existe nas chaves:valor
                    if(taxa.getKey().equalsIgnoreCase(currencyConversion)){

                        //armazenando valor da chave
                        double taxaValue = taxa.getValue();

                        //fazendo conversão
                        convertedValue = taxaValue * valueToConvert;

                    }
                }

            }

        }catch(Exception e){
                e.printStackTrace();
        }

        return convertedValue;
    }
    //reescrevendo o metodo para devolver uma representacao em texto do objeto
    @Override
    public String toString() {

        return "Valor inserido: " + valueToConvert + currencyInput + "\nValor Convertido: " + dataProcessing(valueToConvert, currencyInput, currencyConversion) +currencyConversion;
    }


}
