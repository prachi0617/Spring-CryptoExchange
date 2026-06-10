package com.zipcoder.cryptonator_api.repositories;

import com.zipcoder.cryptonator_api.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by leon on 1/22/18.
 */

public interface FooRepository extends JpaRepository<Foo, Long> {
    Optional<Foo> findBySymbolIgnoreCase(String symbol);
}
