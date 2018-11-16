package com.ua.sutty.lab2;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;

public class FractionalNumberOperationImpl implements FractionNumberOperation {

    public FractionalNumberOperationImpl() {
    }

    @Override
    public FractionNumber add(FractionNumber fractionNumber, FractionNumber fractionNumber1) {
        int dividend = fractionNumber.getDividend() * fractionNumber1.getDivisor() + fractionNumber1.getDividend() * fractionNumber.getDivisor();
        int divisor = fractionNumber.getDivisor() * fractionNumber1.getDivisor();
        return new FractionNumberImpl(dividend, divisor);
    }

    @Override
    public FractionNumber sub(FractionNumber fractionNumber, FractionNumber fractionNumber1) {
        int dividend = fractionNumber.getDividend() * fractionNumber1.getDivisor() - fractionNumber1.getDividend() * fractionNumber.getDivisor();
        int divisor = fractionNumber.getDivisor() * fractionNumber1.getDivisor();
        return new FractionNumberImpl(dividend, divisor);
    }

    @Override
    public FractionNumber mul(FractionNumber fractionNumber, FractionNumber fractionNumber1) {
        int dividend = fractionNumber.getDividend() * fractionNumber1.getDividend();
        int divisor = fractionNumber.getDivisor() * fractionNumber1.getDivisor();
        return new FractionNumberImpl(dividend, divisor);
    }

    @Override
    public FractionNumber div(FractionNumber fractionNumber, FractionNumber fractionNumber1) {
        int dividend = fractionNumber.getDividend() * fractionNumber1.getDivisor();
        int divisor = fractionNumber.getDivisor() * fractionNumber1.getDividend();
        return new FractionNumberImpl(dividend, divisor);
    }
}
