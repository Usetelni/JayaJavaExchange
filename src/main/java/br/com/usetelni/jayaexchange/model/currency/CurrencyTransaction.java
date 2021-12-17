package br.com.usetelni.jayaexchange.model.currency;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import br.com.usetelni.jayaexchange.model.common.BaseModel;
import br.com.usetelni.jayaexchange.model.enums.CurrencyType;

@Entity
@Table(name = "currency_transaction")
@SQLDelete(sql = "UPDATE currency_transaction SET deletado_em = CURRENT_TIMESTAMP WHERE id=? and versao=?")
@Where(clause = "deleted_at is null")
public class CurrencyTransaction extends BaseModel<CurrencyTransaction>{
    
    @Column(name = "end_to_end")
    private String endToEnd;
    @Column(name = "origin_currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType originCurrency;
    @Column(name = "destination_currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType destinationCurrency;
    @Column(name = "origin_amount", nullable = false ) 
    private Double originAmount;
    @Column(name = "destination_amount")
    private Double destinationAmount;
    @Column(name = "conversion_tax" )
    private Double taxConvertion;
    @Column(name = "date_rate")
    private LocalDateTime dateRate;
    
    public String getEndToEnd() {
        return endToEnd;
    }
    public void setEndToEnd(String endToEnd) {
        this.endToEnd = endToEnd;
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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateRate == null) ? 0 : dateRate.hashCode());
        result = prime * result + ((destinationAmount == null) ? 0 : destinationAmount.hashCode());
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
        CurrencyTransaction other = (CurrencyTransaction) obj;
        if (dateRate == null) {
            if (other.dateRate != null)
                return false;
        } else if (!dateRate.equals(other.dateRate))
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
        return true;
    }
    
    @Override
    public String toString() {
        return "CurrencyTransaction [dateRate=" + dateRate + ", destinationAmount=" + destinationAmount
                + ", destinationCurrency=" + destinationCurrency + ", endToEnd=" + endToEnd + ", originAmount="
                + originAmount + ", originCurrency=" + originCurrency + ", taxConvertion=" + taxConvertion + "]";
    }

    
    
    
       
    

}
