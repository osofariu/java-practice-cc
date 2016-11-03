package org.sofariu.coffee;

import org.sofariu.coffee.Pump;

import javax.inject.Inject;

public class ElectricPump implements Pump {

    @Inject
    ElectricPump() {}

    @Override
    public void pump(int volumeML) {
        System.out.println("PUMP " + volumeML);
    }

    @Override
    public void off() {
        System.out.println("PUMP off");
    }
}
