package com.company;

public class WithdrawLimitException extends Exception {

    private double n;

    public WithdrawLimitException(double n)
    {
        this.n = n;
    }
    public double showbalance()
    {
        return n;
    }
}
