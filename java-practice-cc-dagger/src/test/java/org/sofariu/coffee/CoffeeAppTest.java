package org.sofariu.coffee;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sofariu.coffee.CoffeeApp.Coffee;

import java.util.function.Supplier;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CoffeeAppTest {

    private CoffeeApp coffeeApp;

    @Mock
    private Supplier<Coffee> coffeeSupplier;

    @Mock
    Coffee coffee;

    @Mock
    CoffeeMaker coffeeMaker;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        coffeeApp = new CoffeeApp();
        coffeeApp.coffeeSupplier = coffeeSupplier;
        when(coffeeApp.coffeeSupplier.get()).thenReturn(coffee);
        when(coffee.maker()).thenReturn(coffeeMaker);
    }

    @Test
    public void coffeeMakerShouldMakeCoffeeWhenCofeeAppBrews() {
        coffeeApp.brewCoffee();

        verify(coffeeMaker).makeCoffee();
    }
}
