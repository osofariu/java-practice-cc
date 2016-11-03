package org.sofariu.coffee;

import javax.inject.Inject;
import java.util.function.Consumer;

public class ElectricHeater implements Heater {

    ThermostatDevice thermostat;

    @Inject
    public ElectricHeater(ThermostatDevice t) {
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
