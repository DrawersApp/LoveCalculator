package com.drawers.lovecalculator;

import com.drawers.lib.Response;

/**
 * Created by nishant.pathak on 24/04/16.
 */
public class MatchResult implements Response {

    /*
     * {
     * "fname": "Nishant",
     * "sname": "Alice",
     * "percentage": "64",
     * "result": "All the best!"
     * }
     */
    private String fname;
    private String sname;
    private float percentage;
    private String result;

    @Override
    public String toString() {
        return "MatchResult{" +
                "fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", percentage=" + percentage +
                ", result='" + result + '\'' +
                '}';
    }
}
