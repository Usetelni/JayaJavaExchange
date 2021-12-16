package br.com.usetelni.jayaexchange.service.impl.currency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.usetelni.jayaexchange.api.ExchangeApi;
import br.com.usetelni.jayaexchange.request.CurrencyRequest;
import br.com.usetelni.jayaexchange.response.CurrencyResponse;
import br.com.usetelni.jayaexchange.response.common.BaseReturn;
import br.com.usetelni.jayaexchange.response.integration.exchange.convert.response.ExchageConvertResponse;
import br.com.usetelni.jayaexchange.service.currency.CurrencyTransactionService;
import br.com.usetelni.jayaexchange.util.Environments;

@Service
public class CurrencyTransactionServiceImpl implements CurrencyTransactionService{

    private final ExchangeApi api;
    private final Environment env;


    @Autowired
    public CurrencyTransactionServiceImpl(final ExchangeApi api, final Environment env){
        this.api = api;
        this.env = env;
    }

    @Override
    public BaseReturn<CurrencyResponse> create(CurrencyRequest request) {
        String authKey = env.getProperty(Environments.EXCHANGE_AUTH_KEY);
        ExchageConvertResponse response = this.api.getRates(authKey);

        System.out.println(response);
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
