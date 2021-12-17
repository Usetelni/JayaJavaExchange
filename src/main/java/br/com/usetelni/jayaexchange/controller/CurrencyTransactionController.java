package br.com.usetelni.jayaexchange.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.usetelni.jayaexchange.request.CurrencyRequest;
import br.com.usetelni.jayaexchange.response.CurrencyResponse;
import br.com.usetelni.jayaexchange.response.common.BaseReturn;
import br.com.usetelni.jayaexchange.service.currency.CurrencyTransactionService;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyTransactionController {
    
    
    private final CurrencyTransactionService service;
    private static final  Logger LOGGER = LoggerFactory.getLogger(CurrencyTransactionController.class);

    @Autowired
    public CurrencyTransactionController(CurrencyTransactionService service){
        this.service = service;
    }

    @GetMapping
    public BaseReturn<List<CurrencyResponse>> list(){
        LOGGER.info("stage=init method=CurrencyTransactionController.list message=Begin getting currencies ");
        BaseReturn<List<CurrencyResponse>> response = this.service.list();
        LOGGER.info("stage=end method=CurrencyTransactionController.list message=Finished getting currencies ");
        return response;
    }
   
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseReturn<CurrencyResponse> getById(@PathVariable("id") String id){
        LOGGER.info("stage=init method=CurrencyTransactionController.getById message=Begin getting currencies id={} ", id);
        BaseReturn<CurrencyResponse> response = this.service.getById(id);
        LOGGER.info("stage=end method=CurrencyTransactionController.getById message=Finished getting currencies id={}", id);
        return response;
    }

    @GetMapping(path = "/currencies/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseReturn<List<CurrencyResponse>> listById(@PathVariable("id") String id){
        LOGGER.info("stage=init method=CurrencyTransactionController.listById message=Begin getting currencies id={} ", id);
        BaseReturn<List<CurrencyResponse>> response = this.service.listById(id);
        LOGGER.info("stage=end method=CurrencyTransactionController.listById message=Finished getting currencies id={}", id);
        return response;

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseReturn<CurrencyResponse> create(@RequestBody CurrencyRequest request){
        LOGGER.info("stage=init method=CurrencyTransactionController.create message=Begin creating currencies request={} ", request);
        BaseReturn<CurrencyResponse> response = this.service.create(request);
        LOGGER.info("stage=end method=CurrencyTransactionController.create message=Finished creating currencies request={}", request);
        return response;

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseReturn<CurrencyResponse> update(CurrencyRequest request){
        LOGGER.info("stage=init method=CurrencyTransactionController.update message=Begin updating currencies request={} ", request);
        BaseReturn<CurrencyResponse> response = this.service.update(request);
        LOGGER.info("stage=end method=CurrencyTransactionController.update message=Finished updating currencies request={}", request);
        return response;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable() String id){
        LOGGER.info("stage=init method=CurrencyTransactionController.delete message=Begin deleting currencies id={} ", id);
        this.service.delete(id);
        LOGGER.info("stage=end method=CurrencyTransactionController.delete message=Finished deleting currencies id={}", id);
    }

}
