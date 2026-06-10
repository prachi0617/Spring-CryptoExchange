package com.zipcoder.cryptonator_api.controller;

import com.zipcoder.cryptonator_api.domain.Foo;
import com.zipcoder.cryptonator_api.services.FooService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by leon on 1/22/18.
 */

@RestController
@RequestMapping("/api/foo")
@CrossOrigin(origins = "*")
public class FooController {

    private final FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping
    public List<Foo> getAllFoos() {
        return fooService.getAllFoos();
    }

    @GetMapping("/{symbol}")
    public Foo getFooBySymbol(@PathVariable String symbol) {
        return fooService.getFooBySymbol(symbol);
    }

    @PostMapping("/{symbol}")
    public Foo addFoo(@PathVariable String symbol) {
        return fooService.addFoo(symbol);
    }

    @DeleteMapping("/{id}")
    public void deleteFoo(@PathVariable Long id) {
        fooService.deleteFoo(id);
    }
}