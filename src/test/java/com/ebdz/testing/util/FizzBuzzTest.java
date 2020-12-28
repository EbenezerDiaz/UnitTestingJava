package com.ebdz.testing.util;

import org.junit.Test;

import static com.ebdz.testing.util.FizzBuzz.fizzBuzz;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzTest {
    /*
     * Si el número es divisible por 3, retorna “Fizz”
     * Si el número es divisible por 5, retorna “Buzz”
     * Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
     * En otro caso, retorna el mismo número
     */

    @Test
    public void test_fizz_when_number_is_divisible_by_3(){

        assertThat(fizzBuzz(3), is("Fizz"));
        assertThat(fizzBuzz(6), is("Fizz"));
    }


    @Test
    public void test_fizz_when_number_is_divisible_by_5(){

        assertThat(fizzBuzz(5), is("Buzz"));
        assertThat(fizzBuzz(10), is("Buzz"));
    }

    @Test
    public void test_buzz_when_number_is_divisible_by_3_and_5(){

        assertThat(fizzBuzz(15), is("FizzBuzz"));
        assertThat(fizzBuzz(30), is("FizzBuzz"));
    }

    @Test
    public void test_buzz_when_number_is_not_divisible_by_3_or_5(){
        assertThat(fizzBuzz(2), is("2"));
        assertThat(fizzBuzz(7), is("7"));
        assertThat(fizzBuzz(16), is("16"));
        assertThat(fizzBuzz(23), is("23"));

    }


}