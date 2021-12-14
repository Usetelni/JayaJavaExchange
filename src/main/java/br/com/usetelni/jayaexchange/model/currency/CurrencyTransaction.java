package br.com.usetelni.jayaexchange.model.currency;

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
@Where(clause = "deletado_em is null")
public class CurrencyTransaction extends BaseModel<CurrencyTransaction>{
    
    @Column(name = "origin_currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType originCurrency;
    @Column(name = "destination_currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType destinationCurrency;
    @Column(name = "origin_amount", nullable = false ) 
    private Double originAmount;
    @Column(name = "conversion_tax" )
    private Long taxConvertion;
    
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
    public Long getTaxConvertion() {
        return taxConvertion;
    }
    public void setTaxConvertion(Long taxConvertion) {
        this.taxConvertion = taxConvertion;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destinationCurrency == null) ? 0 : destinationCurrency.hashCode());
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
        if (destinationCurrency != other.destinationCurrency)
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
        return "CurrencyTransaction [destinationCurrency=" + destinationCurrency + ", originAmount=" + originAmount
                + ", originCurrency=" + originCurrency + ", taxConvertion=" + taxConvertion + "]";
    }

    
    

}
