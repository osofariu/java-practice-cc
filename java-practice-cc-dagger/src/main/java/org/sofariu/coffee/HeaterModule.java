package org.sofariu.coffee;

import dagger.Binds;
import dagger.Module;

@Module
abstract class HeaterModule {
    @Binds
    abstract Heater getHeater(ElectricHeater electricHeater);
}
