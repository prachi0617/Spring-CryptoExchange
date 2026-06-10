package com.zipcoder.cryptonator_api.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FooTest {
    private Foo foo;
    private LocalDateTime now;

    @BeforeEach
    public void setUp() {
        now = LocalDateTime.now();
        foo = new Foo("BTC", "USD", "50000", "100", "1000", now);
    }

    @Test
    public void testFooConstructor() {
        assertNotNull(foo);
        assertEquals("BTC", foo.getSymbol());
        assertEquals("USD", foo.getTarget());
        assertEquals("50000", foo.getPrice());
        assertEquals("100", foo.getVolume());
        assertEquals("1000", foo.getChangeValue());
        assertEquals(now, foo.getLastUpdated());
    }

    @Test
    public void testFooDefaultConstructor() {
        Foo defaultFoo = new Foo();
        assertNotNull(defaultFoo);
        assertNull(defaultFoo.getId());
        assertNull(defaultFoo.getSymbol());
    }

    @Test
    public void testSetId() {
        Long id = 1L;
        foo.setId(id);
        assertEquals(id, foo.getId());
    }

    @Test
    public void testSetSymbol() {
        String newSymbol = "ETH";
        foo.setSymbol(newSymbol);
        assertEquals(newSymbol, foo.getSymbol());
    }

    @Test
    public void testSetTarget() {
        String newTarget = "EUR";
        foo.setTarget(newTarget);
        assertEquals(newTarget, foo.getTarget());
    }

    @Test
    public void testSetPrice() {
        String newPrice = "60000";
        foo.setPrice(newPrice);
        assertEquals(newPrice, foo.getPrice());
    }

    @Test
    public void testSetVolume() {
        String newVolume = "200";
        foo.setVolume(newVolume);
        assertEquals(newVolume, foo.getVolume());
    }

    @Test
    public void testSetChangeValue() {
        String newChangeValue = "2000";
        foo.setChangeValue(newChangeValue);
        assertEquals(newChangeValue, foo.getChangeValue());
    }

    @Test
    public void testSetLastUpdated() {
        LocalDateTime newTime = LocalDateTime.now().plusHours(1);
        foo.setLastUpdated(newTime);
        assertEquals(newTime, foo.getLastUpdated());
    }
}
