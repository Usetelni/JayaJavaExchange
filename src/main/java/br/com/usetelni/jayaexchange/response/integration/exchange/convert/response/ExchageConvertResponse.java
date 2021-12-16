package br.com.usetelni.jayaexchange.response.integration.exchange.convert.response;

import java.util.List;
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
    
    
    
    
    
    
}
