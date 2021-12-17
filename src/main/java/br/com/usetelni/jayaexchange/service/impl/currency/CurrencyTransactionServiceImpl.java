package br.com.usetelni.jayaexchange.service.impl.currency;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.usetelni.jayaexchange.api.ExchangeApi;
import br.com.usetelni.jayaexchange.exceptions.BaseException;
import br.com.usetelni.jayaexchange.mapper.currency.CurrencyTransactionMapper;
import br.com.usetelni.jayaexchange.mapper.dto.CurrencyResponseDTO;
import br.com.usetelni.jayaexchange.mapper.dto.CurrencyTransactionDTO;
import br.com.usetelni.jayaexchange.model.currency.CurrencyTransaction;
import br.com.usetelni.jayaexchange.repository.CurrencyRepository;
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
    private final CurrencyTransactionMapper mapper;
    private final CurrencyRepository repository;


    @Autowired
    public CurrencyTransactionServiceImpl(final ExchangeApi api, 
                                        final Environment env, 
                                        final CurrencyTransactionMapper mapper, 
                                        final CurrencyRepository repository){
        this.api = api;
        this.env = env;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public BaseReturn<CurrencyResponse> create(CurrencyRequest request) {
        String authKey = env.getProperty(Environments.EXCHANGE_AUTH_KEY);
        ExchageConvertResponse responseExchange = this.api.getRates(authKey);
        CurrencyTransactionDTO dto = new CurrencyTransactionDTO(responseExchange, request);
        CurrencyTransaction model = mapper.create(dto);
        model = repository.save(model);
        CurrencyResponse response = mapper.response(model);
       
        return new BaseReturn<>(response);
    }

    
    @Override
    public BaseReturn<CurrencyResponse> update(CurrencyRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public BaseReturn<List<CurrencyResponse>> list() {
        List<CurrencyTransaction> currencies = this.repository.findAll();
        if(currencies.isEmpty()){
            throw new BaseException(HttpStatus.NOT_FOUND, "There is no currency transaction resgistered.");
        }
        List<CurrencyResponse> currencyResponses = this.mapper.response(currencies);
        return new BaseReturn<>(currencyResponses);
        
    }
    
    @Override
    public BaseReturn<List<CurrencyResponse>> listById(String id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public BaseReturn<CurrencyResponse> getById(String id) {
        CurrencyTransaction model  =  this.repository.findById(Long.parseLong(id)).orElseThrow();
        CurrencyResponse response = this.mapper.response(model);
        return new BaseReturn<>(response);
    }
    
    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        
    }
    
}
