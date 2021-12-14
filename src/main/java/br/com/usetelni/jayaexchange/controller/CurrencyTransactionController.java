package br.com.usetelni.jayaexchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.usetelni.jayaexchange.request.CurrencyRequest;
import br.com.usetelni.jayaexchange.response.CurrencyResponse;
import br.com.usetelni.jayaexchange.response.common.BaseReturn;
import br.com.usetelni.jayaexchange.service.currency.CurrencyTransactionService;

@RestController
@RequestMapping("/currency")
public class CurrencyTransactionController {
    
    
    private final CurrencyTransactionService service;

    @Autowired
    public CurrencyTransactionController(CurrencyTransactionService service){
        this.service = service;
    }

    //TODO pageable and filters
    @GetMapping
    public BaseReturn<List<CurrencyResponse>> list(){
        return this.service.list();
    }
   
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseReturn<CurrencyResponse> getById(@PathVariable("id") String id){
        return this.service.getById(id);
    }

    @GetMapping(path = "/currencies/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseReturn<List<CurrencyResponse>> listById(@PathVariable("id") String id){
        return this.service.listById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseReturn<CurrencyResponse> create(CurrencyRequest request){
        return this.service.create(request);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseReturn<CurrencyResponse> update(CurrencyRequest request){
        return this.service.update(request);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable() String id){
         this.service.delete(id);
    }

}
