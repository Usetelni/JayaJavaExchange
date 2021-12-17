package br.com.usetelni.jayaexchange.service.impl.currency;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.usetelni.jayaexchange.api.ExchangeApi;
import br.com.usetelni.jayaexchange.exceptions.BaseException;
import br.com.usetelni.jayaexchange.mapper.currency.CurrencyTransactionMapper;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyTransactionServiceImpl.class);
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
        if(Objects.isNull(request)){
            LOGGER.error("stage=error method=CurrencyTransactionServiceImpl.create message=Error creating currency request={}", request);
            throw new BaseException(HttpStatus.BAD_REQUEST, "Request body is empty or null."); 
        }

        LOGGER.info("stage=init method=CurrencyTransactionServiceImpl.create message=Begin creating currencies request={}", request);
        String authKey = env.getProperty(Environments.EXCHANGE_AUTH_KEY);
        LOGGER.info("stage=init method=CurrencyTransactionServiceImpl.create message=Begin getting currencies from ExchageConvert API auth_key={}", authKey);
        ExchageConvertResponse responseExchange = this.api.getRates(authKey);

        if(Objects.isNull(responseExchange)){
            LOGGER.error("stage=error method=CurrencyTransactionServiceImpl.create message=Error getting currencies from ExchageConvert API auth_key={}", authKey);
            throw new BaseException(HttpStatus.NOT_FOUND, "Unable to found currencies.");
        }
        LOGGER.info("stage=end method=CurrencyTransactionServiceImpl.create message=Finish getting currencies from ExchageConvert API response={}", responseExchange);
        CurrencyTransactionDTO dto = new CurrencyTransactionDTO(responseExchange, request);
        CurrencyTransaction model = mapper.create(dto);
        model = repository.save(model);
        CurrencyResponse response = mapper.response(model);
        LOGGER.info("stage=end method=CurrencyTransactionServiceImpl.create message=Finish creating currency  response={}", response);
        return new BaseReturn<>(response);
    }

    
    @Override
    public BaseReturn<CurrencyResponse> update(CurrencyRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public BaseReturn<List<CurrencyResponse>> list() {
        LOGGER.info("stage=init method=CurrencyTransactionServiceImpl.list message=Begin getting currencies");
        List<CurrencyTransaction> currencies = this.repository.findAll();

        if(currencies.isEmpty()){
            LOGGER.error("stage=error method=CurrencyTransactionServiceImpl.list message=Error getting currencies ");
            throw new BaseException(HttpStatus.NOT_FOUND, "There is no currency transaction resgistered.");
        }

        List<CurrencyResponse> response = this.mapper.response(currencies);
        LOGGER.info("stage=end method=CurrencyTransactionServiceImpl.create message=Finish creating currency  response={}", response);
        return new BaseReturn<>(response);
        
    }
    
    @Override
    public BaseReturn<List<CurrencyResponse>> listById(String id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public BaseReturn<CurrencyResponse> getById(String id) {
        LOGGER.info("stage=init method=CurrencyTransactionServiceImpl.getById message=Begin getting currencies id={}", id);
        CurrencyTransaction model  =  this.repository.findById(Long.parseLong(id)).orElseThrow();
        if(Objects.isNull(model)){
            LOGGER.error("stage=error method=CurrencyTransactionServiceImpl.getById message=Error getting currencies id={}", id);
            throw new BaseException(HttpStatus.NOT_FOUND, "Unable to found currencies by given id.");
        }
        CurrencyResponse response = this.mapper.response(model);
        LOGGER.info("stage=end method=CurrencyTransactionServiceImpl.getById message=Finish getting currencies response={}", response);
        return new BaseReturn<>(response);
    }
    
    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        
    }
    
}
