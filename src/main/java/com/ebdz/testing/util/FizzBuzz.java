package com.ebdz.testing.util;

public class FizzBuzz {

    public static String fizzBuzz(int number){
        String result = "";

        if(number % 3 == 0){
            result += "Fizz";
        }

        if(number % 5 == 0){
            result += "Buzz";
        }

        if(result.isEmpty()){
            result = String.valueOf(number);
        }

        return result;
    }
}
