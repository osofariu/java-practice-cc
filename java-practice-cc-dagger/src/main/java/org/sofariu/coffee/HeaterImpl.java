package org.sofariu.coffee;

import java.util.function.Consumer;

public class HeaterImpl implements Heater {

    ThermostatImpl thermostat;

    HeaterImpl(ThermostatImpl t) {
        thermostat = t;
    }

    @Override
    public void on(int temperature) {
        System.out.println("HEATER on");
    }

    @Override
    public void on(int temperature, Consumer<HeaterEvent> c) {
        System.out.println("HEATER is hot");
        HeaterEvent he = new HeaterEvent(thermostat.getTemperature());
        c.accept(he);
    }

    @Override
    public void off() {
        System.out.println("HEATER off");
    }
}
