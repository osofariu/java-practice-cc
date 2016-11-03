package org.sofariu.coffee.utils;

import javax.inject.Inject;

public class RandomNumberProvider {

    @Inject
    RandomNumberProvider() {}

    public double random() {
        return Math.random();
    }
}
