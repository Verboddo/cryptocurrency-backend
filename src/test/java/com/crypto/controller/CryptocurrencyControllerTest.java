package com.crypto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.crypto.models.Cryptocurrency;
import com.crypto.service.CryptocurrencyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CryptocurrencyControllerTest {

    @InjectMocks
    private CryptocurrencyController cryptocurrencyController;

    @Mock
    private CryptocurrencyService cryptocurrencyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCryptocurrencies() {
        Pageable pageable = Pageable.unpaged();
        Page<Cryptocurrency> expectedPage = createSamplePageOfCryptocurrencies();

        when(cryptocurrencyService.getAllCryptocurrencies(pageable)).thenReturn(expectedPage);

        Page<Cryptocurrency> result = cryptocurrencyController.getAllCryptocurrencies(pageable);

        assertEquals(expectedPage, result);
    }

    @Test
    public void testGetCryptocurrency() {
        Long id = 1L;
        Cryptocurrency expectedCryptocurrency = createSampleCryptocurrency(id);

        when(cryptocurrencyService.getCryptocurrencyById(id)).thenReturn(expectedCryptocurrency);

        Cryptocurrency result = cryptocurrencyController.getCryptocurrency(id);

        assertEquals(expectedCryptocurrency, result);
    }

    @Test
    public void testCreateCryptocurrency() {
        Cryptocurrency newCryptocurrency = createSampleCryptocurrency(1L);

        when(cryptocurrencyService.createCryptocurrency(newCryptocurrency)).thenReturn(newCryptocurrency);

        Cryptocurrency createdCryptocurrency = cryptocurrencyController.createCryptocurrency(newCryptocurrency);

        assertEquals(newCryptocurrency, createdCryptocurrency);
    }

    @Test
    public void testUpdateCryptocurrency() {
        Long id = 1L;
        Cryptocurrency updatedCryptocurrency = createSampleCryptocurrency(id);

        when(cryptocurrencyService.updateCryptocurrency(id, updatedCryptocurrency)).thenReturn(updatedCryptocurrency);

        Cryptocurrency result = cryptocurrencyController.updateCryptocurrency(id, updatedCryptocurrency);

        assertEquals(updatedCryptocurrency, result);
    }

    @Test
    public void testDeleteCryptocurrency() {
        Long id = 1L;

        cryptocurrencyController.deleteCryptocurrency(id);

        Mockito.verify(cryptocurrencyService).deleteCryptocurrency(id);
    }

    
    /** 
     * @param id
     * @return Cryptocurrency
     */
    
     private Cryptocurrency createSampleCryptocurrency(Long id) {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setId(id);

        return cryptocurrency;
    }

    
    /** 
     * @return Page<Cryptocurrency>
     */
    private Page<Cryptocurrency> createSamplePageOfCryptocurrencies() {
        return new PageImpl<>(List.of(createSampleCryptocurrency(1L), createSampleCryptocurrency(2L)));
    }
}
