package com;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private double valueToConvert;
    private String coinForConversion;

    public double getValueToConvert(){return this.valueToConvert;}
    public String getCoinForConversion(){return this.coinForConversion;}

    public Conversor(double valueToConvert, String cointForConversion){
        this.valueToConvert = valueToConvert;
        this.coinForConversion = cointForConversion;
        this.converter(valueToConvert, coinForConversion);
    }

    public double converter(double valueToConvert, String coinForConversion){

        // criando um enviador da requisicao (o cliente)
        HttpClient client = HttpClient.newHttpClient();

        // criando uma requisicao do tipo get
        HttpRequest request = HttpRequest.newBuilder()
                //
                .uri(URI.create("https://v6.exchangerate-api.com/v6/148aecca3bcf9872738966ff/latest/" + coinForConversion))
                //tipo da requiscao (poderia ser update,delete,post)
                .GET()
                .build();

        try{
            
            // armazenando a resposta enviada pelo cliente
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());
            
            if(response.statusCode() == 200){
                //Gson gson = new Gson();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return valueToConvert;
    }

    //reescrevendo o metodo para devolver uma representacao em texto do objeto
    @Override
    public String toString() {
        
        return "Valor: " + valueToConvert + "Moeda Corrente:" + coinForConversion;
    }


}
