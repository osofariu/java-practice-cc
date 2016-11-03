package org.sofariu.coffee;

import javax.inject.Inject;

class CoffeeMaker {

    private Pump pump;
    private Heater heater;

    @Inject
    CoffeeMaker(Pump pump, Heater heater) {
        this.pump = pump;
        this.heater = heater;
    }

    void makeCoffee() {
        heater.on(190, h -> {
            if (Math.abs(h.getTemperature() - 190) <= 5) {
                pump.pump(450);
                pump.off();
            } else {
                heater.off();
            }
        });
    }
}
