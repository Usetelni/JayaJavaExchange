package br.com.usetelni.jayaexchange.api;


import br.com.usetelni.jayaexchange.response.integration.exchange.convert.response.ExchageConvertResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ExchangeApi {
	
    @RequestLine("GET /convert?access_key={api_key}}&from={from}&to={to}&amount={amount}")
    @Headers({"Content-Type: application/json"})
    ExchageConvertResponse getConversion(
                @Param("api_key")   String apiKey,
                @Param("from")      String from,
                @Param("to")        String to,
                @Param("amount")    String amount);

    @RequestLine("GET /latest?access_key={api_key}")
    @Headers({"Content-Type: application/json"})
    ExchageConvertResponse getRates(@Param("api_key")   String apiKey);

}
