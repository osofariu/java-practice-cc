package org.sofariu.coffee;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class CoffeeMakerTest {

    CoffeeMaker coffeeMaker;

    @Mock
    PumpImpl pump;

    @Mock
    HeaterImpl heater;

    @Mock
    ThermostatImpl thermostat;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        heater.thermostat = thermostat;
        coffeeMaker = new CoffeeMaker(pump, heater);
    }

    @Test
    public void whenMakingCoffeeTurnOnHeaterUntilHeaterEventIsReceived() {

        coffeeMaker.makeCoffee();

        Consumer<HeaterEvent> consumer = verifyHeaterOn();
        consumer.accept(new HeaterEvent(0));
    }

    private Consumer verifyHeaterOn() {
        ArgumentCaptor<Integer> temperatureAC = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Consumer> consumerAC = ArgumentCaptor.forClass(Consumer.class);
        verify(heater).on(temperatureAC.capture(), consumerAC.capture());

        assertEquals(Integer.valueOf(190), temperatureAC.getValue());
        return consumerAC.getValue();
    }

    @Test
    public void ifHeaterEventIndicatesItIsHotEnoughThenRunThePumpAndThenTurnPumpOff() {

        coffeeMaker.makeCoffee();
        Consumer<HeaterEvent> consumer = verifyHeaterOn();
        consumer.accept(new HeaterEvent(185));

        ArgumentCaptor<Integer> volumeAC = ArgumentCaptor.forClass(Integer.class);
        verify(pump).pump(volumeAC.capture());
        assertEquals(450, volumeAC.getValue().intValue());
        verify(pump).off();
    }

    @Test
    public void buthWhenHeaterEventIndicatesTemperatureNotWithin5DegreesDontRunPumpAndTurnHeaterOff() {

        coffeeMaker.makeCoffee();

        ArgumentCaptor<Integer> temperatureAC = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Consumer> consumerAC = ArgumentCaptor.forClass(Consumer.class);
        verify(heater).on(temperatureAC.capture(), consumerAC.capture());

        Consumer c = consumerAC.getValue();
        c.accept(new HeaterEvent(184));
        verify(pump, never()).pump(anyInt());
        verify(heater).off();
    }
}
