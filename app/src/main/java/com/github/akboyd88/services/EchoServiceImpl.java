package com.github.akboyd88.services;

import javax.inject.Inject;

public class EchoServiceImpl implements EchoService {

    @Inject
    public EchoServiceImpl(){

    }

    @Override
    public String echo(String phrase) {
        return phrase;
    }
}
