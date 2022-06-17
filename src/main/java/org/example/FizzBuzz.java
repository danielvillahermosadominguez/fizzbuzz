package org.example;

public class FizzBuzz {
    public static String of(int number) {
        String result = "";
        if(number % 3 == 0) result =  "Fizz";
        if(number % 5 == 0) {
            result +=  "Buzz";
        }
        if(result.isEmpty()) {
            result = String.valueOf(number);
        }

        return result;
    }

}
