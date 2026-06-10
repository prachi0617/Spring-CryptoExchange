package com.zipcoder.cryptonator_api.services;

import com.zipcoder.cryptonator_api.domain.CryptonatorResponse;
import com.zipcoder.cryptonator_api.domain.Foo;
import com.zipcoder.cryptonator_api.domain.Ticker;
import com.zipcoder.cryptonator_api.repositories.FooRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by leon on 1/22/18.
 */
@Service
public class FooService {

    private final FooRepository fooRepository;
    private final RestTemplate restTemplate;

    public FooService(FooRepository fooRepository, RestTemplate restTemplate) {
        this.fooRepository = fooRepository;
        this.restTemplate = restTemplate;
    }

    public List<Foo> getAllFoos() {
        return fooRepository.findAll();
    }

    public Foo getFooBySymbol(String symbol) {
        return fooRepository.findBySymbolIgnoreCase(symbol)
                .orElseGet(() -> addFoo(symbol));
    }

    public Foo addFoo(String symbol) {
        String url = "https://api.cryptonator.com/api/ticker/"
                + symbol.toLowerCase()
                + "-usd";

        CryptonatorResponse response = restTemplate.getForObject(url, CryptonatorResponse.class);

        if (response == null || response.getTicker() == null) {
            throw new RuntimeException("Could not fetch crypto data for: " + symbol);
        }

        Ticker ticker = response.getTicker();

        Foo foo = fooRepository.findBySymbolIgnoreCase(symbol)
                .orElse(new Foo());

        foo.setSymbol(ticker.getBase());
        foo.setTarget(ticker.getTarget());
        foo.setPrice(ticker.getPrice());
        foo.setVolume(ticker.getVolume());
        foo.setChangeValue(ticker.getChange());
        foo.setLastUpdated(LocalDateTime.now());

        return fooRepository.save(foo);
    }

    @Scheduled(fixedRate = 300000)
    public void updateFoosEveryFiveMinutes() {
        List<Foo> foos = fooRepository.findAll();

        for (Foo foo : foos) {
            addFoo(foo.getSymbol());
        }
    }

    public void deleteFoo(Long id) {
        fooRepository.deleteById(id);
    }
}