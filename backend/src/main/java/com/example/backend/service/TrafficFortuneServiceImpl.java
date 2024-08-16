package com.example.backend.service;

import java.util.concurrent.TimeUnit;

public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {
        try {
            // Corrected the typo from "slleep" to "sleep" and added the missing semicolon
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // Handle the exception properly, e.g., print stack trace
            e.printStackTrace();
        }
        return "Heavy traffic";
    }
}
