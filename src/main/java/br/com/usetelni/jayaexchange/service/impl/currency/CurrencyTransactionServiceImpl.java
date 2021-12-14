package br.com.usetelni.jayaexchange.service.impl.currency;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.usetelni.jayaexchange.request.CurrencyRequest;
import br.com.usetelni.jayaexchange.response.CurrencyResponse;
import br.com.usetelni.jayaexchange.response.common.BaseReturn;
import br.com.usetelni.jayaexchange.service.currency.CurrencyTransactionService;

@Service
public class CurrencyTransactionServiceImpl implements CurrencyTransactionService{

    @Override
    public BaseReturn<CurrencyResponse> create(CurrencyRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BaseReturn<CurrencyResponse> update(CurrencyRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BaseReturn<List<CurrencyResponse>> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BaseReturn<List<CurrencyResponse>> listById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BaseReturn<CurrencyResponse> getById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        
    }
    
}
