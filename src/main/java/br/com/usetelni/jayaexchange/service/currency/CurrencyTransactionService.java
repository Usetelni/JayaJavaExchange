package br.com.usetelni.jayaexchange.service.currency;

import java.util.List;

import br.com.usetelni.jayaexchange.request.CurrencyRequest;
import br.com.usetelni.jayaexchange.response.CurrencyResponse;
import br.com.usetelni.jayaexchange.response.common.BaseReturn;

public interface CurrencyTransactionService {
    
    BaseReturn<CurrencyResponse> create(CurrencyRequest request);
    BaseReturn<CurrencyResponse> update(CurrencyRequest request);
    BaseReturn<List<CurrencyResponse>> list();
    BaseReturn<List<CurrencyResponse>> listById(String id);
    BaseReturn<CurrencyResponse> getById(String id);
    void delete(String id);
}
