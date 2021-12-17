package br.com.usetelni.jayaexchange.mapper.dto;

import br.com.usetelni.jayaexchange.model.currency.CurrencyTransaction;

public class CurrencyResponseDTO {
    
    private CurrencyTransaction currencyTransaction;
    private Double destinationAmount;
    private String endToEnd;

    public CurrencyResponseDTO(CurrencyTransaction currencyTransaction, Double destinationAmount, String endToEnd) {
        this.currencyTransaction = currencyTransaction;
        this.destinationAmount = destinationAmount;
        this.endToEnd = endToEnd;
    }
    public CurrencyTransaction getCurrencyTransaction() {
        return currencyTransaction;
    }

    public Double getDestinationAmount() {
        return destinationAmount;
    }

    public String getEndToEnd() {
        return endToEnd;
    }

    

    
    
}
