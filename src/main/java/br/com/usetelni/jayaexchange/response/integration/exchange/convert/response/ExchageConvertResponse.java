package br.com.usetelni.jayaexchange.response.integration.exchange.convert.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchageConvertResponse {

    @JsonProperty("sucess")
    private Boolean sucess;
    @JsonProperty("query")
    private ExchangeQueryResponse queryResponse;
    @JsonProperty("info")
    private ExnchangeInfoResponse infoResponse;
    @JsonProperty("historical")
    private String historical;
    @JsonProperty("date")
    private String date;
    @JsonProperty("result")
    private Double result;

    public Boolean getSucess() {
        return sucess;
    }
    public void setSucess(Boolean sucess) {
        this.sucess = sucess;
    }
    public ExchangeQueryResponse getQueryResponse() {
        return queryResponse;
    }
    public void setQueryResponse(ExchangeQueryResponse queryResponse) {
        this.queryResponse = queryResponse;
    }
    public ExnchangeInfoResponse getInfoResponse() {
        return infoResponse;
    }
    public void setInfoResponse(ExnchangeInfoResponse infoResponse) {
        this.infoResponse = infoResponse;
    }
    public String getHistorical() {
        return historical;
    }
    public void setHistorical(String historical) {
        this.historical = historical;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Double getResult() {
        return result;
    }
    public void setResult(Double result) {
        this.result = result;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((historical == null) ? 0 : historical.hashCode());
        result = prime * result + ((infoResponse == null) ? 0 : infoResponse.hashCode());
        result = prime * result + ((queryResponse == null) ? 0 : queryResponse.hashCode());
        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
        result = prime * result + ((sucess == null) ? 0 : sucess.hashCode());
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
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (historical == null) {
            if (other.historical != null)
                return false;
        } else if (!historical.equals(other.historical))
            return false;
        if (infoResponse == null) {
            if (other.infoResponse != null)
                return false;
        } else if (!infoResponse.equals(other.infoResponse))
            return false;
        if (queryResponse == null) {
            if (other.queryResponse != null)
                return false;
        } else if (!queryResponse.equals(other.queryResponse))
            return false;
        if (result == null) {
            if (other.result != null)
                return false;
        } else if (!result.equals(other.result))
            return false;
        if (sucess == null) {
            if (other.sucess != null)
                return false;
        } else if (!sucess.equals(other.sucess))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "ExchageConvertResponse [date=" + date + ", historical=" + historical + ", infoResponse=" + infoResponse
                + ", queryResponse=" + queryResponse + ", result=" + result + ", sucess=" + sucess + "]";
    }
    
    
    
}
