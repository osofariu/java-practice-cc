package org.sofariu.coffee;

public class ThermostatImpl implements  Thermostat {
    public int getTemperature() {
        return new Double(190 + 10 * Math.random()).intValue();
    }
}
