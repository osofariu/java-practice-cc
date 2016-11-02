package org.sofariu.coffee;

public class HeaterEvent {
    int temperature;

    public HeaterEvent(int temperature) {
        this.temperature = temperature;
    }

    int getTemperature() {
        return temperature;
    }
}
