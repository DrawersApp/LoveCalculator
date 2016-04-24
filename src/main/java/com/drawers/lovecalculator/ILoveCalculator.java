package com.drawers.lovecalculator;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by nishant.pathak on 24/04/16.
 */
public interface ILoveCalculator {
    @Headers({
            "Accept: application/json",
            "X-Mashape-Key: gEqQrmnubUmshXJBCtMMxF1CBMN7p1k7cwLjsnHQHkmQDRzqxx"
    })
    @GET("/getPercentage")
    MatchResult getLove(@Query("fname") String fname, @Query("sname") String sname);
}
