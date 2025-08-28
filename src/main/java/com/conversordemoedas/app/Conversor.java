package com.conversordemoedas.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Conversor {
    private double valueToConvert;
    private String currencyInput, currencyConversion;

    public double getValueToConvert(){return this.valueToConvert;}
    public String getCurrencyInput() {return this.currencyInput;}
    public String getCurrencyConversion(){return this.currencyConversion;}

    public Conversor(double valueToConvert, String currencyInput, String currencyConversion){
        this.valueToConvert = valueToConvert;
        this.currencyInput = currencyInput;
        this.currencyConversion = currencyConversion;
        this.dataProcessing();
    }

    public void dataProcessing(){
        // criando um enviador da requisicao (o cliente)
        HttpClient client = HttpClient.newHttpClient();
        
        // criando uma requisicao do tipo get
        HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("https://v6.exchangerate-api.com/v6/148aecca3bcf9872738966ff/latest/" + currencyInput))
                            //tipo da requiscao (poderia ser update,delete,post)
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


                // armzenando as chave em um arraylist string
                List<String> listaMoedas = new ArrayList<>(taxas.keySet());
                //armazenando os valores em um arraylist double
                List<Double> listaDeTaxas = new ArrayList<>(taxas.values());

                //imprimindo chaves
                for(String moeda : listaMoedas){
                    System.out.println(moeda);
                }
                //imprimindo valores
                for(Double taxa : listaDeTaxas){
                    System.out.println(taxa);
                }
                
                                  
            }

        }catch(Exception e){
                e.printStackTrace();
        }

        //System.out.println(conversor);
    }
    //reescrevendo o metodo para devolver uma representacao em texto do objeto
    @Override
    public String toString() {
        
        return "Valor: " + valueToConvert + "\nMoeda Corrente:" + currencyConversion;
    }


}
