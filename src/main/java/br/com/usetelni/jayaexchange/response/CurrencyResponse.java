package br.com.usetelni.jayaexchange.response;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.usetelni.jayaexchange.model.enums.CurrencyType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse {
    
    @JsonProperty("endToEnd")
    private String endToEnd;
    @JsonProperty("id")
    private Long userId;
    @JsonProperty("originCurrency")
    @NotNull
    private CurrencyType originCurrency;
    @JsonProperty("destinationCurrency")
    @NotNull
    private CurrencyType destinationCurrency;
    @JsonProperty("originAmount")
    @NotNull
    private Double originAmount;
    @JsonProperty("destinationAmount")
    @NotNull
    private Double destinationAmount;
    @JsonProperty("taxConvertion")
    @NotNull
    private Double taxConvertion;
    @JsonProperty("date")
    private LocalDateTime dateRate;
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;


    public String getEndToEnd() {
        return endToEnd;
    }

    public void setEndToEnd(String endToEnd) {
        this.endToEnd = endToEnd;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Double getDestinationAmount() {
        return destinationAmount;
    }

    public void setDestinationAmount(Double destinationAmount) {
        this.destinationAmount = destinationAmount;
    }

    public Double getTaxConvertion() {
        return taxConvertion;
    }

    public void setTaxConvertion(Double taxConvertion) {
        this.taxConvertion = taxConvertion;
    }

    

    public LocalDateTime getDateRate() {
        return dateRate;
    }

    public void setDateRate(LocalDateTime dateRate) {
        this.dateRate = dateRate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((destinationAmount == null) ? 0 : destinationAmount.hashCode());
        result = prime * result + ((destinationCurrency == null) ? 0 : destinationCurrency.hashCode());
        result = prime * result + ((endToEnd == null) ? 0 : endToEnd.hashCode());
        result = prime * result + ((originAmount == null) ? 0 : originAmount.hashCode());
        result = prime * result + ((originCurrency == null) ? 0 : originCurrency.hashCode());
        result = prime * result + ((taxConvertion == null) ? 0 : taxConvertion.hashCode());
        result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
        CurrencyResponse other = (CurrencyResponse) obj;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (destinationAmount == null) {
            if (other.destinationAmount != null)
                return false;
        } else if (!destinationAmount.equals(other.destinationAmount))
            return false;
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
        if (updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        } else if (!updatedAt.equals(other.updatedAt))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CurrencyResponse [createdAt=" + createdAt + ", destinationAmount=" + destinationAmount
                + ", destinationCurrency=" + destinationCurrency + ", endToEnd=" + endToEnd + ", originAmount="
                + originAmount + ", originCurrency=" + originCurrency + ", taxConvertion=" + taxConvertion
                + ", updatedAt=" + updatedAt + ", userId=" + userId + "]";
    }


    
    
    
}
