package com.crypto.exceptions;

import java.io.Serial;

public class CryptocurrencyNotFoundException extends RuntimeException {
    
    @Serial
    private static final long serialVersionUID = 1L;

    public CryptocurrencyNotFoundException(Long id) {
        super("Cannot find cryptocurrency id: " + id);
    }

    public CryptocurrencyNotFoundException() {
        super("Crytocurrency not found");
    }
}
