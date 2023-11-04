package com.crypto.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crypto.models.Cryptocurrency;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {
    // List<Cryptocurrency> findAll(Pageable pageable);
}