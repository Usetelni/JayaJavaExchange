package br.com.usetelni.jayaexchange.response.integration.exchange.convert.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchageConvertResponse {

    @JsonProperty("sucess")
    private Boolean sucess;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("base")
    private String base;
    @JsonProperty("date")
    private String date;
    @JsonProperty("rates")
    private Map<String, String> rates;
    
    public Boolean getSucess() {
        return sucess;
    }
    public void setSucess(Boolean sucess) {
        this.sucess = sucess;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    public String getBase() {
        return base;
    }
    public void setBase(String base) {
        this.base = base;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Map<String, String> getRates() {
        return rates;
    }
    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((base == null) ? 0 : base.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((rates == null) ? 0 : rates.hashCode());
        result = prime * result + ((sucess == null) ? 0 : sucess.hashCode());
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
        ExchageConvertResponse other = (ExchageConvertResponse) obj;
        if (base == null) {
            if (other.base != null)
                return false;
        } else if (!base.equals(other.base))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (rates == null) {
            if (other.rates != null)
                return false;
        } else if (!rates.equals(other.rates))
            return false;
        if (sucess == null) {
            if (other.sucess != null)
                return false;
        } else if (!sucess.equals(other.sucess))
            return false;
        if (timestamp == null) {
            if (other.timestamp != null)
                return false;
        } else if (!timestamp.equals(other.timestamp))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "ExchageConvertResponse [base=" + base + ", date=" + date + ", rates=" + rates + ", sucess=" + sucess
                + ", timestamp=" + timestamp + "]";
    }
    
    
    
    
    
    
}
