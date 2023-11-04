package com.crypto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "crypto_table")
public class Cryptocurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotBlank(message = "Ticker cannot be null")
    private String ticker;

    @NotNull
    private Long coins;

    @NotBlank(message = "Market cannot be null")
    private String market;
    
    public Cryptocurrency() {
        
    }

    
    /** 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /** 
     * @return Long
     */
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getTicker() {
        return ticker;
    }

    public Long getCoins() {
        return coins;
    }

    public String getMarket() {
        return market;
    }
    
    public static class Builder {
        private Cryptocurrency currency;

        public Builder() {
            currency = new Cryptocurrency();
        }

        public Builder withId(Long id) {
            currency.id = id;
            return this;
        }

        public Builder withName(String name) {
            currency.name = name;
            return this;
        }

        public Builder withTicker(String ticker) {
            currency.ticker = ticker;
            return this;
        }

        public Builder withCoins(Long coins) {
            currency.coins = coins;
            return this;
        }

        public Builder withMarketCap(String market) {
            currency.market = market;
            return this;
        }

        public Cryptocurrency build() {
            return currency;
        }
    }

    public static Object Builder() {
        return null;
    }
}