package com.example.helloworld.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GreetingServiceTest {

    private final GreetingService service = new GreetingService();

    @Test
    void greetsNameInFirstHalf() {
        assertEquals("Hello Alice", service.greet("alice"));
        assertEquals("Hello Mike", service.greet("Mike"));
    }

    @Test
    void trimsWhitespace() {
        assertEquals("Hello Alice", service.greet("  alice "));
    }

    @Test
    void rejectsNameInSecondHalf() {
        assertThrows(InvalidNameException.class, () -> service.greet("nancy"));
        assertThrows(InvalidNameException.class, () -> service.greet("Zoe"));
    }

    @Test
    void rejectsMissingOrBlankName() {
        assertThrows(InvalidNameException.class, () -> service.greet(null));
        assertThrows(InvalidNameException.class, () -> service.greet(""));
        assertThrows(InvalidNameException.class, () -> service.greet("   "));
    }

    @Test
    void rejectsNameNotStartingWithLetter() {
        assertThrows(InvalidNameException.class, () -> service.greet("1alice"));
        assertThrows(InvalidNameException.class, () -> service.greet("élan"));
    }
}
