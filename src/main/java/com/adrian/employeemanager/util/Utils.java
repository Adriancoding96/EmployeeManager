package com.adrian.employeemanager.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {

    public String generateRandomUsername() {
        return generateString(8);
    }

    public String generateRandomPassword() {
        return generateString(10);
    }

    private String generateString(int length) {
        Random rand = new Random();
        return rand.ints(48, 123)
                .filter(num -> (num < 58 || num > 64) && (num < 91 || num > 96))
                .limit(length)
                .mapToObj(c -> (char)c).collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)
                .toString();
    }
}
