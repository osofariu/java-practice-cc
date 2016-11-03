package org.sofariu.coffee;

import dagger.Module;
import dagger.Provides;

@Module(includes = {HeaterModule.class, PumpModule.class})
class CoffeeModule {}
