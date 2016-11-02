package org.sofariu.coffee;

import dagger.Module;
import dagger.Provides;

@Module
public class CoffeeModule {

    @Provides
    Heater makeHeater() {
        return new HeaterImpl(new ThermostatImpl());
    }

    @Provides
    Pump makePump() {
        return new PumpImpl();
    }
}
