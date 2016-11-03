package org.sofariu.coffee;

import org.sofariu.coffee.Thermostat;
import org.sofariu.coffee.utils.RandomNumberProvider;

import javax.inject.Inject;

public class ThermostatDevice implements Thermostat {

    RandomNumberProvider rand;

    @Inject
    public ThermostatDevice(RandomNumberProvider rand) {
        this.rand = rand;
    }

    private double getRandom(int upUntill) {
        return upUntill * rand.random();
    }

    public int getTemperature() {
        return new Double(190 + getRandom(10)).intValue();
    }
}
