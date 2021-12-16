package br.com.usetelni.jayaexchange.factory; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import br.com.usetelni.jayaexchange.api.ExchangeApi;
import br.com.usetelni.jayaexchange.util.Environments;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

@Configuration
public class ExchangeAPIFactory {

    @Autowired
    private Environment env;

    @Bean
    public ExchangeApi entityAPI() {

        String host = env.getProperty(Environments.EXCHANGE_HOST, String.class);

        Integer connectionTimeout = env.getProperty(Environments.EXCHANGE_CONNECT_TIMEOUT, Integer.class) * 1000;
        Integer readTimeout = env.getProperty(Environments.EXCHANGE_READ_TIMEOUT, Integer.class) * 1000;

        return Feign.builder()
            .options(new Request.Options(connectionTimeout, readTimeout))
            .logger(new Slf4jLogger())
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .retryer(Retryer.NEVER_RETRY)
            .logLevel(Logger.Level.FULL)
            .target(ExchangeApi.class, host);

    }

}