package com.crypto.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crypto.models.Cryptocurrency;
import com.crypto.service.CryptocurrencyService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/currencies")
public class CryptocurrencyController {
    private final CryptocurrencyService cryptocurrencyService;

    public CryptocurrencyController(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    
    /** 
     * @param pageable
     * @return Page<Cryptocurrency>
     */
    @GetMapping
    public Page<Cryptocurrency> getAllCryptocurrencies(Pageable pageable) {
        return cryptocurrencyService.getAllCryptocurrencies(pageable);
    }

    
    /** 
     * @param id
     * @return Cryptocurrency
     */
    @GetMapping("/{id}")
    public Cryptocurrency getCryptocurrency(@PathVariable Long id) {
        return cryptocurrencyService.getCryptocurrencyById(id);
    }

    @PostMapping
    public Cryptocurrency createCryptocurrency(@Valid @RequestBody Cryptocurrency cryptocurrency) {
        return cryptocurrencyService.createCryptocurrency(cryptocurrency);
    }

    @PutMapping("/{id}")
    public Cryptocurrency updateCryptocurrency(@PathVariable Long id, @RequestBody Cryptocurrency updatedCryptocurrency) {
        return cryptocurrencyService.updateCryptocurrency(id, updatedCryptocurrency);
    }

    @DeleteMapping("/{id}")
    public void deleteCryptocurrency(@PathVariable Long id) {
        cryptocurrencyService.deleteCryptocurrency(id);
    }
}
