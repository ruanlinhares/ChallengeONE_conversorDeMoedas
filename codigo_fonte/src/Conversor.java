import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Conversor {
    private double valueToConvert;
    private String coinForConversion;

    public void setValueToConvert(double valueToConvert){this.valueToConvert = valueToConvert;}
    public double getValueToConvert(){return this.valueToConvert;}
    public void setCoinForConversion(String coinForConversion){this.coinForConversion = coinForConversion;}
    public String getCoinForConversion(){return this.coinForConversion;}

    public Conversor(double ValueToConvert, String cointForConversion){
        this.setValueToConvert(ValueToConvert);
        this.setCoinForConversion(cointForConversion);
    }

    public double convertendo(double valueToConvert, String coinForConversion){

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/148aecca3bcf9872738966ff/latest/USD")).build();

        return 0;
    }
}
