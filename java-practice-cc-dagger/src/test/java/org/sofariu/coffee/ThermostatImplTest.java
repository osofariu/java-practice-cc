package org.sofariu.coffee;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sofariu.coffee.utils.RandomNumberProvider;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ThermostatImplTest {

    Thermostat thermostat;

    @Mock
    RandomNumberProvider rand;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        thermostat = new ThermostatDevice(rand);
    }

    @Test
    public void whenGivenARandomNumberof0point5ReturnTemperatureOf195() {

        when(rand.random()).thenReturn(0.5);
        thermostat.getTemperature();
        assertEquals(195, thermostat.getTemperature());
    }
}