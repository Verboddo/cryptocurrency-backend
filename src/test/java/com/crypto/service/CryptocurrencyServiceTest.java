package com.crypto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.crypto.exceptions.CryptocurrencyNotFoundException;
import com.crypto.models.Cryptocurrency;
import com.crypto.respository.CryptocurrencyRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CryptocurrencyServiceTest {

    @InjectMocks
    private CryptocurrencyService cryptocurrencyService;

    @Mock
    private CryptocurrencyRepository cryptocurrencyRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCryptocurrencyById_ExistingId() {
        Long id = 1L;
        Cryptocurrency expectedCryptocurrency = new Cryptocurrency();
        expectedCryptocurrency.setId(id);

        // Mocking the behavior of the repository to return the expected cryptocurrency
        Mockito.when(cryptocurrencyRepository.findById(id)).thenReturn(Optional.of(expectedCryptocurrency));

        Cryptocurrency result = cryptocurrencyService.getCryptocurrencyById(id);

        assertEquals(expectedCryptocurrency, result);
    }

    @Test
    public void testGetCryptocurrencyById_NonExistingId() {
        Long id = 2L;

        // Mocking the behavior of the repository to return an empty Optional
        Mockito.when(cryptocurrencyRepository.findById(id)).thenReturn(Optional.empty());

        CryptocurrencyNotFoundException exception = assertThrows(CryptocurrencyNotFoundException.class, () -> {
            cryptocurrencyService.getCryptocurrencyById(id);
        });

        assertEquals("Cannot find cryptocurrency id: " + id, exception.getMessage());
    }

    @Test
    public void testCreateCryptocurrency() {
        Cryptocurrency newCryptocurrency = new Cryptocurrency.Builder()
        .withId(1L)
        .withName("Bitcoin")
        .withTicker("BTC")
        .withCoins(1870554L)
        .withMarketCap("$181.00")
        .build();

        // Mocking the behavior of the repository to return the saved cryptocurrency
        when(cryptocurrencyRepository.save(newCryptocurrency)).thenReturn(newCryptocurrency);

        Cryptocurrency createdCryptocurrency = cryptocurrencyService.createCryptocurrency(newCryptocurrency);

        assertEquals(newCryptocurrency, createdCryptocurrency);

        // Verifying that the save method was called on the repository
        verify(cryptocurrencyRepository).save(newCryptocurrency);
    }

    @Test
    public void testDeleteCryptocurrency_ExistingId() {
        Long id = 1L;
        Cryptocurrency existingCryptocurrency = new Cryptocurrency();
        existingCryptocurrency.setId(id);

        // Mocking the behavior of the repository to return the existing cryptocurrency
        when(cryptocurrencyRepository.findById(id)).thenReturn(Optional.of(existingCryptocurrency));

        cryptocurrencyService.deleteCryptocurrency(id);

        // Verify that the delete method was called on the repository
        verify(cryptocurrencyRepository).deleteById(id);
    }

    @Test
    public void testDeleteCryptocurrency_NonExistingId() {
        Long id = 2L;

        // Mocking the behavior of the repository to return an empty Optional
        when(cryptocurrencyRepository.findById(id)).thenReturn(Optional.empty());

        CryptocurrencyNotFoundException exception = assertThrows(CryptocurrencyNotFoundException.class, () -> {
            cryptocurrencyService.deleteCryptocurrency(id);
        });

        // Verify that the exception message contains the ID
        String expectedErrorMessage = "Cannot find cryptocurrency id: " + id;
        String actualErrorMessage = exception.getMessage();
        assert(actualErrorMessage.contains(expectedErrorMessage));
    }
}
