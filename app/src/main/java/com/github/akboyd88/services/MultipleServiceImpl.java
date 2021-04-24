package com.github.akboyd88.services;

import javax.inject.Inject;

public class MultipleServiceImpl implements MultiplyService {

    @Inject
    public MultipleServiceImpl() {

    }
    @Override
    public double multiply(double a, double b) {
        return a*b;
    }
}
