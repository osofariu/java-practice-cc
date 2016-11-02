package org.sofariu.coffee;

public class PumpImpl implements Pump {
    @Override
    public void pump(int volumeML) {
        System.out.println("PUMP " + volumeML);
    }

    @Override
    public void off() {
        System.out.println("PUMP off");
    }
}
