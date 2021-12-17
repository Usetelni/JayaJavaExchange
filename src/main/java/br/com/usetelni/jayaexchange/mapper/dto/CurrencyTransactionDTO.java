package br.com.usetelni.jayaexchange.mapper.dto;

import br.com.usetelni.jayaexchange.request.CurrencyRequest;
import br.com.usetelni.jayaexchange.response.integration.exchange.convert.response.ExchageConvertResponse;

public class CurrencyTransactionDTO {
    
    private ExchageConvertResponse exchageConvertResponse;
    private CurrencyRequest currencyRequest;

    public CurrencyTransactionDTO(ExchageConvertResponse exchageConvertResponse, CurrencyRequest currencyRequest) {
        this.exchageConvertResponse = exchageConvertResponse;
        this.currencyRequest = currencyRequest;
    }

    public ExchageConvertResponse getExchageConvertResponse(){
        return this.exchageConvertResponse;
    }

    public CurrencyRequest getCurrencyRequest(){
        return this.currencyRequest;
    }
}
