package org.sofariu.coffee;

import dagger.Binds;
import dagger.Module;

@Module
abstract class PumpModule {
    @Binds
 abstract Pump providePump(ElectricPump pump);
}
