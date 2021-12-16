package br.com.usetelni.jayaexchange.mapper.currency;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.usetelni.jayaexchange.mapper.dto.CurrencyTransactionDTO;
import br.com.usetelni.jayaexchange.model.currency.CurrencyTransaction;
import br.com.usetelni.jayaexchange.response.CurrencyResponse;
import br.com.usetelni.jayaexchange.util.TimeZones;

//TODO create DTO to receive data
@Service
public class CurrencyTransactionMapper {
    

    public CurrencyTransaction create(CurrencyTransactionDTO dto){
        CurrencyTransaction model = new CurrencyTransaction();

        model.setOriginCurrency(dto.getCurrencyRequest().getOriginCurrency());
        model.setDestinationCurrency(dto.getCurrencyRequest().getDestinationCurrency());
        model.setOriginAmount(dto.getCurrencyRequest().getOriginAmount());
        model.setTaxConvertion(toTaxCurrnecyConvertion(dto));
        model.setDateRate(toDateRate(dto));
        return model;
    }

    public CurrencyResponse response(CurrencyTransaction model){
        CurrencyResponse response = new CurrencyResponse();
        
        response.setEndToEnd("endToEnd");
        response.setUserId(model.getId());
        response.setOriginCurrency(model.getOriginCurrency());
        response.setDestinationCurrency(model.getDestinationCurrency());
        response.setOriginAmount(model.getOriginAmount());
        response.setDestinationAmount(0.0);
        response.setTaxConvertion(model.getTaxConvertion());
        response.setDateRate(model.getDateRate());
        response.setCreatedAt(model.getDateModel().getCreatedAt());
        response.setUpdatedAt(model.getDateModel().getUpdatedAt());
        
        return response;
    }

    public List<CurrencyResponse> response(List<CurrencyTransaction> model){
        return model.stream().map(this::response).collect(Collectors.toList());
    }

    private LocalDateTime toDateRate(CurrencyTransactionDTO dto) {
        if(Objects.nonNull(dto.getExchageConvertResponse()) && Objects.nonNull(dto.getExchageConvertResponse().getTimestamp())){
            Long timeStamp = dto.getExchageConvertResponse().getTimestamp() != null ? dto.getExchageConvertResponse().getTimestamp() : 0L;
            return LocalDateTime.ofEpochSecond(timeStamp, 0, TimeZones.getZoneOffSetUtc());
        }

        return LocalDateTime.now();
    }


    private Double toTaxCurrnecyConvertion(CurrencyTransactionDTO dto) {
        if(Objects.nonNull(dto.getExchageConvertResponse()) && Objects.nonNull(dto.getCurrencyRequest())){
            return Double.parseDouble(dto.getExchageConvertResponse().getRates().get(dto.getCurrencyRequest().getTaxConvertion().name()));
        }
        return null;
    }
}
