package com.crypto.service;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crypto.exceptions.CryptocurrencyNotFoundException;
import com.crypto.models.Cryptocurrency;
import com.crypto.respository.CryptocurrencyRepository;

@Service
public class CryptocurrencyService {
    private final CryptocurrencyRepository cryptocurrencyRepository;

    public CryptocurrencyService(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    
    /** 
     * @param pageable
     * @return Page<Cryptocurrency>
     */
    public Page<Cryptocurrency> getAllCryptocurrencies(Pageable pageable) {
        // Implement logic to retrieve all cryptocurrencies
        return cryptocurrencyRepository.findAll(pageable);
    }

    
    /** 
     * @param id
     * @return Cryptocurrency
     */
    public Cryptocurrency getCryptocurrencyById(Long id) {
        Optional<Cryptocurrency> optionalCryptocurrency = cryptocurrencyRepository.findById(id);

        if (!optionalCryptocurrency.isPresent()) {
            throw new CryptocurrencyNotFoundException(id);
        }
        
        Cryptocurrency cryptocurrency = optionalCryptocurrency.get();
        return cryptocurrency;
    }

    public Cryptocurrency createCryptocurrency(Cryptocurrency cryptocurrency) {
        // Implement logic to create a new cryptocurrency
        return cryptocurrencyRepository.save(cryptocurrency);
    }

    public Cryptocurrency updateCryptocurrency(Long id, Cryptocurrency updatedCryptocurrency) {
        Optional<Cryptocurrency> optionalCryptocurrency = cryptocurrencyRepository.findById(id);

        if (!optionalCryptocurrency.isPresent()) {
            throw new CryptocurrencyNotFoundException(id);
        }
        // Implement logic to update a specific cryptocurrency
        updatedCryptocurrency.setId(id);
        return cryptocurrencyRepository.save(updatedCryptocurrency);
    }

    public void deleteCryptocurrency(Long id) {
        Optional<Cryptocurrency> optionalCryptocurrency = cryptocurrencyRepository.findById(id);

        if (!optionalCryptocurrency.isPresent()) {
            throw new CryptocurrencyNotFoundException(id);
        }
        // Implement logic to delete a specific cryptocurrency
        cryptocurrencyRepository.deleteById(id);
    }
}