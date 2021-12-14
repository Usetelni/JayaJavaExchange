package br.com.usetelni.jayaexchange.mapper.currency;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.usetelni.jayaexchange.model.currency.CurrencyTransaction;
import br.com.usetelni.jayaexchange.request.CurrencyRequest;
import br.com.usetelni.jayaexchange.response.CurrencyResponse;

@Service
public class CurrencyTransactionMapper {
    

    public CurrencyTransaction create(CurrencyRequest request){
        CurrencyTransaction model = new CurrencyTransaction();

        model.setOriginCurrency(request.getOriginCurrency());
        model.setDestinationCurrency(request.getDestinationCurrency());
        model.setOriginAmount(request.getOriginAmount());
        model.setTaxConvertion(request.getTaxConvertion());
        
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
        response.setCreatedAt(model.getDateModel().getCreatedAt());
        response.setUpdatedAt(model.getDateModel().getUpdatedAt());

        return response;
    }

    public List<CurrencyResponse> response(List<CurrencyTransaction> model){
        return model.stream().map(this::response).collect(Collectors.toList());
    }
}
