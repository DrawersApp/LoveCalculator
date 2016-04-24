package com.drawers.lovecalculator;

import retrofit.RestAdapter;

/**
 * Created by nishant.pathak on 24/04/16.
 */
public class LoveCalculator {
    private static ILoveCalculator calculator;

    static {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://love-calculator.p.mashape.com")
                .build();
        calculator = restAdapter.create(ILoveCalculator.class);
    }

    MatchResult calculate(String fname, String sName) {
        return calculator.getLove(fname, sName);
    }


}
