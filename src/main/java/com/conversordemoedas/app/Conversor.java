package com.conversordemoedas.app;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Conversor {
    private double valueToConvert;
    // mudar nome de isertValue
    private String currencyInput, currencyConversion;

    public double getValueToConvert(){return this.valueToConvert;}
    public String getCurrencyInput() {return this.currencyInput;}
    public String getCurrencyConversion(){return this.currencyConversion;}

    public Conversor(double valueToConvert, String currencyInput, String currencyConversion){
        this.valueToConvert = valueToConvert;
        this.currencyInput = currencyInput;
        this.currencyConversion = currencyConversion;
        this.converter(valueToConvert, currencyConversion, currencyInput);
    }

    public double converter(double valueToConvert, String currencyInput, String currencyConversion){

        // criando um enviador da requisicao (o cliente)
        HttpClient client = HttpClient.newHttpClient();

        // criando uma requisicao do tipo get
        HttpRequest request = HttpRequest.newBuilder()
                //
                .uri(URI.create("https://v6.exchangerate-api.com/v6/148aecca3bcf9872738966ff/latest/" + currencyInput))
                //tipo da requiscao (poderia ser update,delete,post)
                .GET()
                .build();

        try{
            
            // armazenando a resposta enviada pelo cliente
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            if(response.statusCode() == 200){
                //instanciando um objeto gson
                Gson gson = new Gson();
                
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return valueToConvert;
    }

    //reescrevendo o metodo para devolver uma representacao em texto do objeto
    @Override
    public String toString() {
        
        return "Valor: " + valueToConvert + "\nMoeda Corrente:" + currencyConversion;
    }


}
