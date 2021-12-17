package br.com.usetelni.jayaexchange.request;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.usetelni.jayaexchange.model.enums.CurrencyType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRequest {
    
    private  String endToEnd;

    @JsonProperty("originCurrency")
    @NotNull
    private CurrencyType originCurrency;
    @JsonProperty("destinationCurrency")
    @NotNull
    private CurrencyType destinationCurrency;
    @JsonProperty("originAmount")
    @NotNull
    private Double originAmount;
    @JsonProperty("taxConvertion")
    @NotNull
    private CurrencyType taxConvertion;

    
    public String getEndToEnd() {
        return endToEnd = UUID.randomUUID().toString();
    }
    public CurrencyType getOriginCurrency() {
        return originCurrency;
    }
    public void setOriginCurrency(CurrencyType originCurrency) {
        this.originCurrency = originCurrency;
    }
    public CurrencyType getDestinationCurrency() {
        return destinationCurrency;
    }
    public void setDestinationCurrency(CurrencyType destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }
    public Double getOriginAmount() {
        return originAmount;
    }
    public void setOriginAmount(Double originAmount) {
        this.originAmount = originAmount;
    }
    public CurrencyType getTaxConvertion() {
        return taxConvertion;
    }
    public void setTaxConvertion(CurrencyType taxConvertion) {
        this.taxConvertion = taxConvertion;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destinationCurrency == null) ? 0 : destinationCurrency.hashCode());
        result = prime * result + ((endToEnd == null) ? 0 : endToEnd.hashCode());
        result = prime * result + ((originAmount == null) ? 0 : originAmount.hashCode());
        result = prime * result + ((originCurrency == null) ? 0 : originCurrency.hashCode());
        result = prime * result + ((taxConvertion == null) ? 0 : taxConvertion.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CurrencyRequest other = (CurrencyRequest) obj;
        if (destinationCurrency != other.destinationCurrency)
            return false;
        if (endToEnd == null) {
            if (other.endToEnd != null)
                return false;
        } else if (!endToEnd.equals(other.endToEnd))
            return false;
        if (originAmount == null) {
            if (other.originAmount != null)
                return false;
        } else if (!originAmount.equals(other.originAmount))
            return false;
        if (originCurrency != other.originCurrency)
            return false;
        if (taxConvertion == null) {
            if (other.taxConvertion != null)
                return false;
        } else if (!taxConvertion.equals(other.taxConvertion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CurrencyRequest [destinationCurrency=" + destinationCurrency + ", endToEnd=" + endToEnd
                + ", originAmount=" + originAmount + ", originCurrency=" + originCurrency + ", taxConvertion="
                + taxConvertion + "]";
    }

    
    
}
