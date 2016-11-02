package org.sofariu.coffee;

import java.util.function.Consumer;

public interface Heater {
    void on(int temperature);
    void on(int temperature, Consumer<HeaterEvent> c);
    void off();
}
