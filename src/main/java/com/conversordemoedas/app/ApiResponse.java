package com.conversordemoedas.app;

import java.util.Map;

public class ApiResponse {
    // usando a interface map para mapear as taxas de conversão do json
    // o nome da variável tem que ser o mesmo do campo json
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversionRates(){
        return conversion_rates;
    }
}
