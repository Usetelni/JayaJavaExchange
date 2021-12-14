package br.com.usetelni.jayaexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usetelni.jayaexchange.model.currency.CurrencyTransaction;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyTransaction, Long>{
    

}
